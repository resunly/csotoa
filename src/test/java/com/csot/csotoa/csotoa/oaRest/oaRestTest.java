package com.csot.csotoa.csotoa.oaRest;

import com.csot.csotoa.oaRest.mapper.IOaRestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liushiqi on 2017/6/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class oaRestTest {

    private static final Logger logger = LoggerFactory.getLogger(oaRestTest.class);
    @Autowired
    private IOaRestMapper oaRestMapper;

    @Test
    public void TestGetTemplateId(){
        String fdId= "15ca9a6bdcfbe307a9c927c4601a88c5";
        String templateId = oaRestMapper.getTempletIdByfdId(fdId);
        logger.info("templateId------------>>>"+templateId);
    }
}
