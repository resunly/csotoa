package com.csot.csotoa.readxmlFile;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liushiqi on 2017/6/22.
 */
public class ObjectToXMLUtil {

    /**
     * 把java的可序列化的对象(实现Serializable接口)序列化保存到XML文件里面,如果想一次保存多个可序列化对象请用集合进行封装
     * 保存时将会用现在的对象原来的XML文件内容
     * @param obj 要序列化的可序列化的对象
     * @param fileName 带完全的保存路径的文件名
     * @throws FileNotFoundException 指定位置的文件不存在
     * @throws IOException 输出时发生异常
     * @throws Exception 其他运行时异常
     */
    public static void objectXmlEncoder(Object obj, String fileName)
            throws FileNotFoundException, IOException, Exception {
        //创建输出文件
        File fo = new File(fileName);
        //文件不存在,就创建该文件
        if (!fo.exists()) {
            //先创建文件的目录
            String path = fileName.substring(0, fileName.lastIndexOf('.'));
            File pFile = new File(path);
            pFile.mkdirs();
        }
        //创建文件输出流
        FileOutputStream fos = new FileOutputStream(fo);
        //创建XML文件对象输出类实例
        XMLEncoder encoder = new XMLEncoder(fos);
        //对象序列化输出到XML文件
        encoder.writeObject(obj);
        encoder.flush();
        //关闭序列化工具
        encoder.close();
        //关闭输出流
        fos.close();
    }


    /**
     * 读取由objSource指定的XML文件中的序列化保存的对象,返回的结果经过了List封装
     * @param objSource 带全部文件路径的文件全名
     * @return 由XML文件里面保存的对象构成的List列表(可能是一个或者多个的序列化保存的对象)
     * @throws FileNotFoundException 指定的对象读取资源不存在
     * @throws IOException 读取发生错误
     * @throws Exception 其他运行时异常发生
     */
    public static List objectXmlDecoder(String objSource) throws FileNotFoundException, IOException, Exception {
        List objList = new ArrayList();
        File fin = new File(objSource);
        FileInputStream fis = new FileInputStream(fin);
        XMLDecoder decoder = new XMLDecoder(fis);
        Object obj = null;
        try {
            while ((obj = decoder.readObject()) != null) {
                objList.add(obj);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
        fis.close();
        decoder.close();
        return objList;
    }

    /**
     * 对象输到XML文件
     * @param obj 待输出的对象
     * @param outFileName 目标XML文件的文件名
     * @return 返回输出XML文件的路径
     * @throws FileNotFoundException
     */
    public static String object2XML(Object obj, String outFileName) throws FileNotFoundException {
        //构造输出XML文件的字节输出流
        File outFile = new File(outFileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
        XMLEncoder xmlEncoder = new XMLEncoder(bos);//构造一个XML编辑器
        xmlEncoder.writeObject(obj);//使用XML编码器写对象
        xmlEncoder.close();//关闭编码器
        return outFile.getAbsolutePath();
    }

    /**
     * 把XML文件解码成对象
     * @param inFileName输入的XML文件
     * @return 返回生成的对象
     * @throws FileNotFoundException
     */
    public static Object xml2Object(String inFileName) throws FileNotFoundException {
        //构造输入的XML文件的字节输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inFileName));
        XMLDecoder xmlDecoder = new XMLDecoder(bis);//构造一个XML解码器
        Object obj = xmlDecoder.readObject();//使用XML解码器读对象
        xmlDecoder.close();//关闭解码器
        return obj;
    }

}
