package com.csot.csotoa.oaRest;

import com.csot.csotoa.config.TemplateDateUtil;
import com.csot.csotoa.oaRest.mapper.IOaRestMapper;
import com.csot.csotoa.oaRest.service.impl.OaRestServiceImpl;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * Created by liushiqi on 2017/6/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class oaRestTest {

    private static final Logger logger = LoggerFactory.getLogger(oaRestTest.class);
    @Autowired
    private IOaRestMapper oaRestMapper;

    @Autowired
    private TemplateDateUtil templateDateUtil;
    @Autowired
    private OaRestServiceImpl oaRestService;

    @Autowired
    private ICsotUtilMapper csotUtilMapper;

    @Test
    public void TestGetTemplateId() {
        String fdId = "15ca9a6bdcfbe307a9c927c4601a88c5";
        String templateId = oaRestMapper.getTempletIdByfdId(fdId);
        logger.info("templateId------------>>>" + templateId);
    }

    @Test
    public void TestTemplateDateString() {
        Map<String, String> map = templateDateUtil.getTemplateOfMobile();
        logger.info("读取配置文件中配置的模板ID：size():" + map.size() + " content: " + map.keySet().toString());
    }

    @Test
    public void TestCheckFlowNodeSet(){
        String fdId= "15d7d4b474a9c4731632e304e7398440";
        String userName="";
        boolean result = oaRestService.checkFlowNodeSet(fdId,userName);
        if(result){
           System.out.println("======");
        }
    }

    @Test
    public void getUserIdByLoginName(){
        String loginName="huchanglong01";
        String id = csotUtilMapper.getIdByLoginName(loginName);
        System.out.println("id=====>>"+id);
    }
}

