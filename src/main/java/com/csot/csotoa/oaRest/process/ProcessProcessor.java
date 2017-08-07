package com.csot.csotoa.oaRest.process;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.csot.csotoa.oaRest.mapper.IOaRestMapper;
import com.csot.csotoa.utils.ObjectXML;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ProcessProcessor {

	private IOaRestMapper mapper = null;

	public ProcessProcessor(IOaRestMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public String defaultProcess(Map<String, Object> extendDataMap, JSONObject extendJson, Map<String, String> attrDef,
			Map<String, String> tableAndIdMaping) throws FileNotFoundException, IOException, Exception {

		JSONObject textJson = extendJson.optJSONObject("editText");
		if (textJson == null || textJson.isNullObject()) {
			return ObjectXML.objectXmlEncoder(extendDataMap);
		}
		extendDataMap = processText(extendDataMap, textJson, attrDef);

		JSONObject checkboxJson = extendJson.optJSONObject("checkboxs");
		if (checkboxJson == null || checkboxJson.isNullObject()) {
			return ObjectXML.objectXmlEncoder(extendDataMap);
		}
		extendDataMap = processCheckBox(extendDataMap, checkboxJson, attrDef);

		JSONObject tableJson = extendJson.optJSONObject("editTable");
		if (tableJson == null || tableJson.isNullObject()) {
			return ObjectXML.objectXmlEncoder(extendDataMap);
		}

		for (String tableId : tableAndIdMaping.keySet()) {
			String rowId = tableAndIdMaping.get(tableId);
			JSONArray workDetailsJson = tableJson.getJSONArray(tableId);
			extendDataMap = processTable(extendDataMap, workDetailsJson, tableId, rowId, attrDef);
		}
		return ObjectXML.objectXmlEncoder(extendDataMap);
	}

	public Date toDate(String text) {
		Long time = Long.valueOf(text);
		return new Date(time * 1000);
	}

	public String toBoolean(String text) {
		if ("是".equals(text)) {
			return "1";
		} else {

		}
		return "0";
	}

	public Map<String, String> toUser(String text) {

		JSONObject json = JSONObject.fromObject(text);
		if (json == null) {
			throw new NullPointerException("jsonString required!eg: {employeenumber:12345,name:张三} ");
		}

		String employeenumber = json.optString("employeenumber");
		if (StringUtils.isEmpty(employeenumber)) {
			throw new NullPointerException("Attribute employeenumber required! eg: {employeenumber:12345,name:张三} ");
		}

		Map<String, String> userMap = this.mapper.getUserByEmloyeeNo(employeenumber);

		if (userMap == null || CollectionUtils.isEmpty(userMap)) {
			throw new NullPointerException("Can not find user by employeenumber:" + employeenumber);
		}

		Map<String, String> lowerCaseUserMap = new HashMap<>();

		for (String key : userMap.keySet()) {
			String value = userMap.get(key);
			lowerCaseUserMap.put(key.toLowerCase(), value);
		}
		return lowerCaseUserMap;
	}

	public Object getValue(JSONObject textJson, String key, Map<String, String> attrDef) {
		if (attrDef == null || StringUtils.isEmpty(attrDef.get(key))) {
			return textJson.get(key);
		}
		String valueType = attrDef.get(key);
		if ("Date".equalsIgnoreCase(valueType)) {
			return toDate(textJson.optString(key));
		} else if ("Boolean".equalsIgnoreCase(valueType)) {
			return toBoolean(textJson.optString(key));
		} else if ("User".equalsIgnoreCase(valueType)) {
			return toUser(textJson.optString(key));
		}
		return textJson.optString(key);
	}

	public Map<String, Object> processText(Map<String, Object> extendDataMap, JSONObject textJson,
			Map<String, String> attrDef) {
		return mergeMap(extendDataMap, textJson, attrDef);
	}

	/**
	 * 仅支持单值
	 * 
	 * checkboxs:{fddz:{name:张三,id:zhangsan} }
	 * 
	 * @param extendDataMap
	 * @param textJson
	 * @param attrDef
	 * @return
	 */
	public Map<String, Object> processCheckBox(Map<String, Object> extendDataMap, JSONObject textJson,
			Map<String, String> attrDef) {
		if (CollectionUtils.isEmpty(textJson)) {
			return extendDataMap;
		}

		for (Object keyObj : textJson.keySet()) {
			String key = (String) keyObj;
			String textValue = textJson.optString(key);
			if (StringUtils.isEmpty(textValue)) {
				continue;
			}

			Object value = getValue(textJson, key, attrDef);
			extendDataMap.put(key, value);
		}
		return extendDataMap;
	}

	public Map<String, Object> findMatches(String rowIdKey, String rowId, List<Map<String, Object>> lists) {
		if (lists == null) {
			return null;
		}
		for (Map<String, Object> map : lists) {
			String rowIdValue = (String) map.get(rowIdKey);
			if (rowId.equalsIgnoreCase(rowIdValue)) {
				return map;
			}
		}
		return null;
	}

	public Map<String, Object> mergeMap(Map<String, Object> extendDataMap, JSONObject textJson,
			Map<String, String> attrDef) {

		if (CollectionUtils.isEmpty(textJson)) {
			return extendDataMap;
		}

		for (Object keyObj : textJson.keySet()) {
			String key = (String) keyObj;
			String textValue = textJson.optString(key);
			if (StringUtils.isEmpty(textValue)) {
				continue;
			}
			Object value = getValue(textJson, key, attrDef);
			extendDataMap.put(key, value);
		}
		return extendDataMap;
	}

	public Map<String, Object> processTable(Map<String, Object> extendDataMap, JSONArray editArray, String tableId,
			String rowIdKey, Map<String, String> attrDef) {

		if (CollectionUtils.isEmpty(editArray) || editArray.isEmpty()) {
			return extendDataMap;
		}
		List<Map<String, Object>> lists = (List<Map<String, Object>>) extendDataMap.get(tableId);
		if (lists == null) {
			lists = new ArrayList<Map<String, Object>>();
			extendDataMap.put(tableId, lists);
		}
		for (int i = 0; i < editArray.size(); i++) {
			JSONObject json = JSONObject.fromObject(editArray.get(i));
			String editRowId = json.optString(rowIdKey);
			Map<String, Object> rowMap = findMatches(rowIdKey, editRowId, lists);

			if (rowMap == null) {// 不增加数据
				rowMap = mergeMap(new HashMap<String, Object>(), json, attrDef);
				lists.add(rowMap);
			} else {
				rowMap = mergeMap(rowMap, json, attrDef);
			}
		}
		return extendDataMap;
	}

}
