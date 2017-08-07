package com.csot.csotoa.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.XMLDecoder;
import java.io.*;
import java.net.URI;
import java.util.Properties;

public class DOMUtils {
    /**
     * 初始化一个空Document对象返回。
     *
     * @return a Document
     */
    public static Document newXMLDocument() {
        try {
            return newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 初始化一个DocumentBuilder
     *
     * @return a DocumentBuilder
     * @throws ParserConfigurationException
     */
    public static DocumentBuilder newDocumentBuilder()
            throws ParserConfigurationException {
        return newDocumentBuilderFactory().newDocumentBuilder();
    }

    /**
     * 初始化一个DocumentBuilderFactory
     *
     * @return a DocumentBuilderFactory
     */
    public static DocumentBuilderFactory newDocumentBuilderFactory() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        return dbf;
    }

    /**
     * 将传入的一个XML String转换成一个org.w3c.dom.Document对象返回。
     *
     * @param xmlString 一个符合XML规范的字符串表达。
     * @return a Document
     */
    public static Document parseXMLDocument(String xmlString) {
        if (xmlString == null) {
            throw new IllegalArgumentException();
        }
        try {
            return newDocumentBuilder().parse(
                    new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /***
     * 把一个XML字符串转换为一个XML文档对象
     * @param returnXML : XML字符串
     * @return Document xml文档对象
     * @throws Exception
     */
    public static org.w3c.dom.Document getDocument(String returnXML) throws Exception {
        org.w3c.dom.Document doc = null;
        if (returnXML != null && returnXML.length() > 0) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = null;
            try {
                db = dbf.newDocumentBuilder();
            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            }
            try {
                StringReader rd = new StringReader(returnXML);
                InputSource in = new InputSource(rd);
                doc = db.parse(in);

            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (SAXException saxe) {
                saxe.printStackTrace();
            }
        }
        return doc;
    }

    /**
     * 给定一个输入流，解析为一个org.w3c.dom.Document对象返回。
     *
     * @param input
     * @return a org.w3c.dom.Document
     */
    public static Document parseXMLDocument(InputStream input) {
        if (input == null) {
            throw new IllegalArgumentException("参数为null！");
        }
        try {
            return newDocumentBuilder().parse(input);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 给定一个文件名，获取该文件并解析为一个org.w3c.dom.Document对象返回。
     *
     * @param fileName 待解析文件的文件名
     * @return a org.w3c.dom.Document
     */
    public static Document loadXMLDocumentFromFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("未指定文件名及其物理路径！");
        }
        try {
            return newDocumentBuilder().parse(new File(fileName));
        } catch (SAXException e) {
            throw new IllegalArgumentException("目标文件（" + fileName
                    + "）不能被正确解析为XML！" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalArgumentException("不能获取目标文件（" + fileName + "）！"
                    + e.getMessage());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 将给定文件的内容或者给定 URI 的内容解析为一个 XML 文档，并且返回一个新的 DOM Document 对象
     *
     * @param filePath 文件所在路径
     * @return DOM的Document对象
     * @throws Exception
     */
    public static Document xml2Doc(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        FileInputStream inputStream = null;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();

            /* 通过文件方式读取,注意文件保存的编码和文件的声明编码要一致(默认文件声明是UTF-8) */
            File file = new File(filePath);
            doc = builder.parse(file);

            /* 通过一个URL方式读取 */
            URI uri = new URI(filePath);//filePath="http://java.sun.com/index.html"
            doc = builder.parse(uri.toString());

            /* 通过java IO 流的读取 */
            inputStream = new FileInputStream(filePath);
            doc = builder.parse(inputStream);
            return doc;
        } catch (Exception e) {
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    return null;
                }
            }
        }
    }

    /**
     * 把XML文件解码成对象
     * @return 返回生成的对象
     * @throws FileNotFoundException
     */
    public static Object xml2Object(String inFileName) throws FileNotFoundException {
        //构造输入的XML文件的字节输入流
        //BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inFileName));
        ByteArrayInputStream bi = new ByteArrayInputStream(inFileName.getBytes());
        XMLDecoder xmlDecoder = new XMLDecoder(bi);//构造一个XML解码器
        Object obj = xmlDecoder.readObject();//使用XML解码器读对象
        xmlDecoder.close();//关闭解码器
        return obj;
    }


    /*
     * 把dom文件转换为xml字符串
     */
    public static String toStringFromDoc(Document document) {
        String result = null;

        if (document != null) {
            StringWriter strWtr = new StringWriter();
            StreamResult strResult = new StreamResult(strWtr);
            TransformerFactory tfac = TransformerFactory.newInstance();
            try {
                javax.xml.transform.Transformer t = tfac.newTransformer();
                t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                t.setOutputProperty(OutputKeys.INDENT, "yes");
                t.setOutputProperty(OutputKeys.METHOD, "xml"); // xml, html,
                // text
                t.setOutputProperty(
                        "{http://xml.apache.org/xslt}indent-amount", "4");
                t.transform(new DOMSource(document.getDocumentElement()),
                        strResult);
            } catch (Exception e) {
                System.err.println("XML.toString(Document): " + e);
            }
            result = strResult.getWriter().toString();
            try {
                strWtr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * 给定一个节点，将该节点加入新构造的Document中。
     *
     * @param node a Document node
     * @return a new Document
     */

    public static Document newXMLDocument(Node node) {
        Document doc = newXMLDocument();
        doc.appendChild(doc.importNode(node, true));
        return doc;
    }

    /**
     * 将传入的一个DOM Node对象输出成字符串。如果失败则返回一个空字符串""。
     *
     * @param node
     *            DOM Node 对象。
     * @return a XML String from node
     */

    /*
     * public static String toString(Node node) { if (node == null) { throw new
     * IllegalArgumentException(); } Transformer transformer = new
     * Transformer(); if (transformer != null) { try { StringWriter sw = new
     * StringWriter(); transformer .transform(new DOMSource(node), new
     * StreamResult(sw)); return sw.toString(); } catch (TransformerException
     * te) { throw new RuntimeException(te.getMessage()); } } return ""; }
     */

    /**
     * 将传入的一个DOM Node对象输出成字符串。如果失败则返回一个空字符串""。
     *
     * @param node
     *            DOM Node 对象。
     * @return a XML String from node
     */

    /*
     * public static String toString(Node node) { if (node == null) { throw new
     * IllegalArgumentException(); } Transformer transformer = new
     * Transformer(); if (transformer != null) { try { StringWriter sw = new
     * StringWriter(); transformer .transform(new DOMSource(node), new
     * StreamResult(sw)); return sw.toString(); } catch (TransformerException
     * te) { throw new RuntimeException(te.getMessage()); } } return ""; }
     */

    /**
     * 获取一个Transformer对象，由于使用时都做相同的初始化，所以提取出来作为公共方法。
     *
     * @return a Transformer encoding gb2312
     */

    public static Transformer newTransformer() {
        try {
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
            Properties properties = transformer.getOutputProperties();
            properties.setProperty(OutputKeys.ENCODING, "gb2312");
            properties.setProperty(OutputKeys.METHOD, "xml");
            properties.setProperty(OutputKeys.VERSION, "1.0");
            properties.setProperty(OutputKeys.INDENT, "no");
            transformer.setOutputProperties(properties);
            return transformer;
        } catch (TransformerConfigurationException tce) {
            throw new RuntimeException(tce.getMessage());
        }
    }

    /**
     * 返回一段XML表述的错误信息。提示信息的TITLE为：系统错误。之所以使用字符串拼装，主要是这样做一般 不会有异常出现。
     *
     * @param errMsg
     *            提示错误信息
     * @return a XML String show err msg
     */
    /*
     * public static String errXMLString(String errMsg) { StringBuffer msg = new
     * StringBuffer(100);
     * msg.append("<?xml version="1.0" encoding="gb2312" ?>");
     * msg.append("<errNode title="系统错误" errMsg="" + errMsg + ""/>"); return
     * msg.toString(); }
     */
    /**
     * 返回一段XML表述的错误信息。提示信息的TITLE为：系统错误
     *
     * @param errMsg
     *            提示错误信息
     * @param errClass
     *            抛出该错误的类，用于提取错误来源信息。
     * @return a XML String show err msg
     */
    /*
     * public static String errXMLString(String errMsg, Class errClass) {
     * StringBuffer msg = new StringBuffer(100);
     * msg.append("<?xml version='1.0' encoding='gb2312' ?>");
     * msg.append("<errNode title="
     * 系统错误" errMsg=""+ errMsg + "" errSource=""+ errClass.getName()+ ""/>");
     * 　return msg.toString(); }
     */

    /**
     * 返回一段XML表述的错误信息。
     *
     * @param title    提示的title
     * @param errMsg   提示错误信息
     * @param errClass 抛出该错误的类，用于提取错误来源信息。
     * @return a XML String show err msg
     */

    public static String errXMLString(String title, String errMsg, Class errClass) {
        StringBuffer msg = new StringBuffer(100);
        msg.append("<?xml version='1.0' encoding='utf-8' ?>");
        msg.append("<errNode title=" + title + "errMsg=" + errMsg
                + "errSource=" + errClass.getName() + "/>");
        return msg.toString();
    }

}





