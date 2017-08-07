package com.csot.csotoa.oaRest.process;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.csot.csotoa.oaRest.service.impl.OaRestServiceImpl;
import com.csot.csotoa.utils.ObjectXML;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2017/7/13.
 */
public class OaSZWFCommitProcess {

	private static final Logger logger = LoggerFactory.getLogger(OaRestServiceImpl.class);

	/**
	 * 修改外勤申请流程表单xml
	 * 
	 * @param extendDataMap
	 * @return
	 */
	public static String modifyCsotHrMainXmlData(Map<String, Object> extendDataMap, Map<String, String> valueMap)
			throws Exception {
		logger.info("Enter in modifyCsotHrMainXmlData...");
		if (!(CollectionUtils.isEmpty(valueMap)) && !(CollectionUtils.isEmpty(extendDataMap))) {
			for (String key : valueMap.keySet()) {
				if ("fd_real_start".equals(key) || "fd_real_end".equals(key)) {
					if (valueMap.get(key) != null) {
						Long time = Long.valueOf(valueMap.get(key));
						logger.debug("time" + time * 1000);
						extendDataMap.put(key, new Date(time * 1000));
					}
				} else {
					// 相同参数更新，不同增加
					if (valueMap.get(key) != null) {
						extendDataMap.put(key, valueMap.get(key));
					}
				}
			}
		}
		return ObjectXML.objectXmlEncoder(extendDataMap);
	}

	/**
	 * 修改‘内部调动’表单xml
	 * 
	 * @param extendDataMap
	 * @return
	 * @throws Exception
	 */
	public static String modifyCsotHrMainXmlData(Map<String, Object> extendDataMap, JSONArray jsonArray)
			throws Exception {
		List<Map<String, String>> beforMap = new ArrayList<>();
		if (!(CollectionUtils.isEmpty(extendDataMap)) && !(CollectionUtils.isEmpty(jsonArray))) {
			// 例如:[{"fdWorkItemId":"15bf10b2e3b7332f0de1e8d4cbbac22f","fd_new_check":"0"},
			// {"fdWorkItemId":"15bf10d710622e3fe9fa6194d67bc71c","fd_new_check":"0"}]
			Object obj = extendDataMap.get("work_detail");
			if (obj != null && !CollectionUtils.isEmpty(jsonArray)) {
				List<Map<String, String>> lists = (List<Map<String, String>>) obj;
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject json = JSONObject.fromObject(jsonArray.get(i));
					for (Map<String, String> map : lists) {
						if (json.optString("fdWorkItemId").equalsIgnoreCase(map.get("fdWorkItemId"))) {
							String check = json.optString("fd_new_check");
							if (StringUtils.isNotEmpty(check)) {
								if (check.equals("是")) {
									map.put("fd_new_check", "1");
								}
								map.put("fd_new_check", "0");
							}
						}
						beforMap.add(map);
					}
				}
			}
		} else {
			return ObjectXML.objectXmlEncoder(extendDataMap);
		}
		return ObjectXML.objectXmlEncoder(extendDataMap.put("work_detail", beforMap));
	}

	/**
	 * 修改‘备品备件退库至备件维修’表单xml
	 * 
	 * @param extendDataMap
	 * @return
	 * @throws Exception
	 */
	public static String modifyRepareXmlData(Map<String, Object> extendDataMap, JSONArray jsonArray) throws Exception {
		List<Map<String, String>> beforMap = new ArrayList<>();
		if (!(CollectionUtils.isEmpty(extendDataMap)) && !(CollectionUtils.isEmpty(jsonArray))) {
			// 例如:[{"fdWorkItemId":"15bf10b2e3b7332f0de1e8d4cbbac22f","fd_new_check":"0"},
			// {"fdWorkItemId":"15bf10d710622e3fe9fa6194d67bc71c","fd_new_check":"0"}]
			Object obj = extendDataMap.get("work_detail");
			if (obj != null && !CollectionUtils.isEmpty(jsonArray)) {
				List<Map<String, String>> lists = (List<Map<String, String>>) obj;
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject json = JSONObject.fromObject(jsonArray.get(i));
					for (Map<String, String> map : lists) {
						if (json.optString("fdWorkItemId").equalsIgnoreCase(map.get("fdWorkItemId"))) {
							String check = json.optString("fd_new_check");
							if (StringUtils.isNotEmpty(check)) {
								if (check.equals("是")) {
									map.put("fd_new_check", "1");
								}
								map.put("fd_new_check", "0");
							}
						}
						beforMap.add(map);
					}
				}
			}
		} else {
			return ObjectXML.objectXmlEncoder(extendDataMap);
		}
		return ObjectXML.objectXmlEncoder(extendDataMap.put("work_detail", beforMap));
	}

	/**
	 * 修改特采申请表单的xml信息
	 * 
	 * @param extendDataMap
	 * @param valueMap
	 * @return
	 * @throws Exception
	 */
	public static String modifyCsotSpecialPurchaseXmlData(Map<String, Object> extendDataMap,
			Map<String, String> valueMap) throws Exception {
		if (!(CollectionUtils.isEmpty(valueMap))) {
			for (String key : valueMap.keySet()) {
				String value = valueMap.get(key);
				if (StringUtils.isNotEmpty(value)) {
					extendDataMap.put(key, value);
				}
			}
		}
		return ObjectXML.objectXmlEncoder(extendDataMap);
	}

	/**
	 * 出差/驻场 表单xml修改
	 * 
	 * @param extendDataMap
	 * @param valueMap
	 * @return
	 * @throws Exception
	 */
	public static String modifyCsotHrMainEvectionXmlData(Map<String, Object> extendDataMap,
			Map<String, String> valueMap) throws Exception {
		logger.info("Enter in modifyCsotHrMainEvectionXmlData...");
		if (!(CollectionUtils.isEmpty(valueMap)) && !(CollectionUtils.isEmpty(extendDataMap))) {
			for (String key : valueMap.keySet()) {
				if (StringUtils.isNotEmpty(valueMap.get(key))) {
					if ("fd_real_start".equals(key) || "fd_real_end".equals(key)) {
						Long time = Long.valueOf(valueMap.get(key));
						extendDataMap.put(key, new Date(time * 1000));
					}
					if ("fd_real_day".equals(key) || "fd_real_night".equals(key)) {
						Integer day = Integer.valueOf(valueMap.get(key));
						extendDataMap.put(key, day);
					}
					if ("fd_2ef318839938e6".equals(key)) {
						extendDataMap.put(key, valueMap.get(key));
					}
				}
			}
		}
		return ObjectXML.objectXmlEncoder(extendDataMap);
	}

	/**
	 * 报关业务委托单 表单xml修改
	 * 
	 * @param extendDataMap
	 * @param valueMap
	 * @return
	 * @throws Exception
	 */
	public static String modifyKmReviewMainXmlData(Map<String, Object> extendDataMap, Map<String, String> valueMap)
			throws Exception {
		logger.info("Enter in modifyKmReviewMainXmlData...");
		HashMap<String, String> hashMap = new HashMap<>();
		if (!(CollectionUtils.isEmpty(valueMap))) {
			for (String key : valueMap.keySet()) {
				String jsonValue = valueMap.get(key);
				Map<String, String> kv = str2Map(jsonValue);
				for (String kvStr : kv.keySet()) {
					String json_key = kv.get(kvStr);
					if (StringUtils.isNotEmpty(json_key)) {
						hashMap.put(kvStr, json_key);
					}
				}
			}
		}
		if (hashMap.size() > 0 && !CollectionUtils.isEmpty(extendDataMap)) {
			extendDataMap.put("fd_zdfh", hashMap);
		}
		logger.info("return modifyKmReviewMainXmlData:" + extendDataMap);
		return ObjectXML.objectXmlEncoder(extendDataMap);
	}

	/**
	 * 来宾进入CSOT管制区申请单 表单xml修改
	 * 
	 * @param extendDataMap
	 * @param valueMap
	 * @return
	 */
	public static String modifyKmReviewMain_CSOTManage_XmlData(Map<String, Object> extendDataMap,
			Map<String, String> valueMap) throws Exception {
		logger.info("Enter in modifyKmReviewMain_CSOTManage_XmlData...");
		if (!(CollectionUtils.isEmpty(valueMap)) && !(CollectionUtils.isEmpty(extendDataMap))) {
			for (String key : valueMap.keySet()) {
				if (StringUtils.isNotEmpty(valueMap.get(key))) {
					if ("fd_real_intime".equals(key) || "fd_real_outtime".equals(key)) {
						String time = valueMap.get(key);
						if (StringUtils.isNotEmpty(time)) {
							Long date = Long.valueOf(time);
							extendDataMap.put(key, new Date(date * 1000));
						}
					}
				}
			}
		}
		return ObjectXML.objectXmlEncoder(extendDataMap);
	}

	public static String modifyKmReviewMain_Borrow_XmlData(Map<String, Object> extendDataMap,
			Map<String, String> valueMap) throws Exception {
		logger.info("Enter in modifyKmReviewMain_Borrow_XmlData...");
		if (!(CollectionUtils.isEmpty(valueMap)) && !(CollectionUtils.isEmpty(extendDataMap))) {
			for (String key : valueMap.keySet()) {
				if (StringUtils.isNotEmpty(valueMap.get(key))) {
					if ("fd_return_date".equals(key)) {
						String time = valueMap.get(key);
						if (StringUtils.isNotEmpty(time)) {
							Long date = Long.valueOf(time);
							extendDataMap.put(key, new Date(date * 1000));
						}
					}
					if ("fd_return_type".equals(key)) {
						String type = valueMap.get(key);
						extendDataMap.put(key, type);
					}
				}
			}
		}
		return ObjectXML.objectXmlEncoder(extendDataMap);
	}

	/**
	 *  editTable={"fd_detail_form":[{"fdId":"15d7c99a1e4ee79fcf1feeb4fbfa9dec","fd_change_leave":"是"}]}
	 * 
	 * @param extendDataMap
	 * @param valueMap
	 * @return
	 * @throws Exception
	 */
	public static String modifyLeaveApplyXmlData(Map<String, Object> extendDataMap, Map<String, String> valueMap)
			throws Exception {
		String table = valueMap.get("editTable");
		Object arr = JSONObject.fromObject(table).get("work_detail");
		JSONArray jsonArray = JSONArray.fromObject(arr);
		List<Map<String, String>> beforMap = new ArrayList<>();
		if (!(CollectionUtils.isEmpty(extendDataMap)) && !(CollectionUtils.isEmpty(jsonArray))) {
			// 例如:[{"fdWorkItemId":"15bf10b2e3b7332f0de1e8d4cbbac22f","fd_new_check":"0"},
			// {"fdWorkItemId":"15bf10d710622e3fe9fa6194d67bc71c","fd_new_check":"0"}]
			Object obj = extendDataMap.get("fd_detail_form");
			if (obj != null && !CollectionUtils.isEmpty(jsonArray)) {
				List<Map<String, String>> lists = (List<Map<String, String>>) obj;
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject json = JSONObject.fromObject(jsonArray.get(i));
					for (Map<String, String> map : lists) {
						if (json.optString("fdId").equalsIgnoreCase(map.get("fdId"))) {
							String leaveType = json.optString("fd_change_leave");
							if (StringUtils.isNotEmpty(leaveType)) {
								map.put("fd_change_leave", leaveType);
							}
						}
						beforMap.add(map);
					}
				}
			}
		} else {
			return ObjectXML.objectXmlEncoder(extendDataMap);
		}
		return ObjectXML.objectXmlEncoder(extendDataMap.put("work_detail", beforMap));
	}

	/**
	 * 字符号转换为map格式
	 * 
	 * @param str
	 *            例如：name:qiliang,age:20
	 * @return
	 */
	public static Map<String, String> str2Map(String str) {
		logger.info("Enter in to str2Map...");
		Map<String, String> map = new HashMap<>();
		if (StringUtils.isNotEmpty(str = str.trim())) {
			String value = "";
			if (str.indexOf(",") > -1) {
				value = str.replace(",", ",");
			}
			if (str.indexOf("，") > -1) {
				value = str.replace("，", ",");
			}
			String[] msg_arr = value.split(",");
			if (msg_arr == null) {
				return map;
			}
			for (int i = 0; i < msg_arr.length; i++) {
				String jsonStr = msg_arr[i];
				if (StringUtils.isNotEmpty(jsonStr = jsonStr.trim())) {
					String arr = "";
					if (jsonStr.indexOf(":") > -1) {
						arr = jsonStr.replace(":", ":");
					}
					if (jsonStr.indexOf("：") > -1) {
						arr = jsonStr.replace("：", ":");
					}
					String[] json_arr = arr.split(":");
					if (json_arr == null) {
						return map;
					}
					map.put(json_arr[0], json_arr[1]);
				}
			}
		}
		return map;
	}
}
