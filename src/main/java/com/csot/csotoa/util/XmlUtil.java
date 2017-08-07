package com.csot.csotoa.util;

import com.csot.csotoa.util.service.impl.CsotUtilServiceImpl;
import org.dom4j.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.XMLDecoder;
import java.io.*;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XmlUtil {
    @Autowired
    public static CsotUtilServiceImpl utilService;

    public static Object stringToMap(String inFileName) throws FileNotFoundException {
        InputStream in = new ByteArrayInputStream(inFileName.getBytes());
        BufferedInputStream bis = new BufferedInputStream(in);
        XMLDecoder xmlDecoder = new XMLDecoder(bis);
        Object obj = xmlDecoder.readObject();
        xmlDecoder.close();
        return obj;
    }

    public static String ClobToString(Clob clob) throws SQLException,IOException {
        String reString = "";
        if(null != clob) {
            java.io.Reader is = clob.getCharacterStream();// 得到流
            BufferedReader br = new BufferedReader(is);
            String s = br.readLine();
            StringBuffer sb = new StringBuffer();
            while (s != null) {
                sb.append(s);
                s = br.readLine();
            }
            reString = sb.toString();
        }
        return reString;
    }

    public static String getNodeAttValue(String str, String nodeName,String attr)
            throws DocumentException {
        String result = "";
        Document document = DocumentHelper.parseText(str);

        Element root = document.getRootElement();
        Iterator iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            if (element.getName().equals(nodeName)) {
                Attribute att = element.attribute(attr);
                if(null != att){
                    result = att.getValue();
                }
                return result;
            }
        }
        return result;
    }

    public static String getOperationStr(String str, String nodeName)throws DocumentException {
        String result = "";
        if(null == str || str.trim().length() == 0){
            return result;
        }
        Document document = DocumentHelper.parseText(str);
        Element root = document.getRootElement();
        Iterator iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            if (element.getName().equals(nodeName)) {
                List list = element.content();
                for(int i = 0; i < list.size(); i ++) {
                    Element obj = (Element) list.get(i);
                    //Attribute optAtt = obj.attribute("type");
                    Attribute optAtt = obj.attribute("name");
                    if (null != optAtt) {
                        String value = optAtt.getValue();
                        if (null != value && value.length() > 0 && !"催办".equals(value)) {
                            if (result.length() > 0) {
                                result = result + ";" + value;
                            } else {
                                result = value;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static Map getNodeAttMap(String str, String nodeName)
            throws DocumentException {
        Map map = new HashMap();
        if(null == str || str.trim().length() == 0){
            return map;
        }
        Document document = DocumentHelper.parseText(str);

        Element root = document.getRootElement();
        Iterator iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            if (element.getName().equals(nodeName)) {
                Attribute nameAttr = element.attribute("name");
                Attribute labelAttr = element.attribute("label");
                String name = nameAttr.getValue();
                String label = labelAttr.getValue();
                map.put(name,label);
            }
        }
        return map;
    }
}
