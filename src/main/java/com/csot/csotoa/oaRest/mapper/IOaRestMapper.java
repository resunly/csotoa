package com.csot.csotoa.oaRest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by liushiqi on 2017/6/16.
 */
@Mapper
public interface IOaRestMapper {

	public Map<String, String> getUserByEmloyeeNo(@Param("employeeNo") String employeeNo);

	public String getTempletIdByfdId(@Param("fdId") String fdId);

	public String getModelName(@Param("fdId") String fdId);

	public String getCurrNode(@Param("fdId") String fdId);

	public String updateDateXml(@Param("tableName") String tableName, @Param("dateXml") String dateXml,
			@Param("fdId") String fdId);

	public String getDateXml(@Param("tableName") String tableName, @Param("fdId") String fdId);

	public List<String> getEditNodes(@Param("templateId") String templateId);

	public List<String> getTemplateId(@Param("fdId") String fdId);

	public List<String> getTemplateNames(@Param("templateId") String templateId);

	public String getTemplatePage(String templateId);

	public Map<String, String> getFlowCurrentNode(Map<String, String> map);

	public List getSignFlowCurrentNode(String fdId);

	public String getFlowNodeSet(String fdId);

	public String getFllowNodeSetByNode(Map<String,String> map);

	public List getFlowNodeHandel(Map<String, String> map);
}
