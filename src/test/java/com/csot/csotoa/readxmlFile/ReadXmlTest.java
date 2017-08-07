package com.csot.csotoa.readxmlFile;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;

/**
 * Created by hank.he on 2017/7/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadXmlTest {
    @Test
    public void getXmlDate(){
        String xml ="<reviewNode canModifyFlow=\"false\" canModifyMainDoc=\"false\" canModifyNotionPopedom=\"false\" dayOfNotify=\"1\" dayOfPass=\"0\" handlerIds=\"$docCreator$\" handlerNames=\"$申请人$\" handlerSelectType=\"formula\" hasInitSysOrgElment=\"false\" id=\"N4\" ignoreOnHandlerEmpty=\"false\" ignoreOnHandlerSame=\"false\" mustModifyHandlerNodeIds=\"N6\" name=\"申请人确认\" optHandlerCalType=\"2\" optHandlerSelectType=\"org\" orgAttributes=\"optHandlerIds:optHandlerNames;otherCanViewCurNodeIds:otherCanViewCurNodeNames\" processType=\"0\" recalculateHandler=\"true\" tranNotifyDraft=\"0\" tranNotifyPrivate=\"0\" useOptHandlerOnly=\"false\" x=\"360\" y=\"380\">\n" +
                "<operations refId=\"133ef1c3b3eb2dd2331b82f4e70950ee\"/>\n" +
                "</reviewNode>";

        String result = "";
        String node = "mustModifyHandlerNodeIds";
        org.dom4j.Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element root = document.getRootElement();
        String nodeString = root.attribute("mustModifyHandlerNodeIds").getStringValue();
        //Iterator iterator = root.elementIterator();
        System.out.println("root--->>"+root.getName());
        System.out.println("nodeString--->>"+nodeString);

        /**
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            System.out.println("element:==>>"+element.getName());
            if (element.getName().equals(nodeName)) {
                Attribute att = element.attribute(attr);
                if(null != att){
                    result = att.getValue();
                }
            }
        }*/
    }

    /*public static void main(String []arg){
        String xml ="<reviewNode canModifyFlow=\"false\" canModifyMainDoc=\"false\" canModifyNotionPopedom=\"false\" dayOfNotify=\"1\" dayOfPass=\"0\" handlerIds=\"$docCreator$\" handlerNames=\"$申请人$\" handlerSelectType=\"formula\" hasInitSysOrgElment=\"false\" id=\"N4\" ignoreOnHandlerEmpty=\"false\" ignoreOnHandlerSame=\"false\" mustModifyHandlerNodeIds=\"N6\" name=\"申请人确认\" optHandlerCalType=\"2\" optHandlerSelectType=\"org\" orgAttributes=\"optHandlerIds:optHandlerNames;otherCanViewCurNodeIds:otherCanViewCurNodeNames\" processType=\"0\" recalculateHandler=\"true\" tranNotifyDraft=\"0\" tranNotifyPrivate=\"0\" useOptHandlerOnly=\"false\" x=\"360\" y=\"380\">\n" +
                "<operations refId=\"133ef1c3b3eb2dd2331b82f4e70950ee\"/>\n" +
                "</reviewNode>";

        String result = "";
        org.dom4j.Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element root = document.getRootElement();
        Iterator iterator = root.elementIterator();
    }*/
}
