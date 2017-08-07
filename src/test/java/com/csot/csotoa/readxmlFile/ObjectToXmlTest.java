package com.csot.csotoa.readxmlFile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liushiqi on 2017/6/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class ObjectToXmlTest {

    private static final Logger logger = LoggerFactory.getLogger(ObjectToXmlTest.class);
    @Test
    public void objectTxmlTest() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "hank");
        map.put("sex", "1");
        map.put("name", "rest");

        try {
            ObjectToXMLUtil.objectXmlEncoder(map, "mapFile.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void xmlToObjectTest() {
        String file = "E:\\intelijjWrokspace\\csotoa\\src\\test\\resources-test\\file.xml";
        try {
            List list = ObjectToXMLUtil.objectXmlDecoder(file);
            logger.info("==========>>"+list.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
