package com.csot.csotoa.pagePremitTest;

import com.csot.csotoa.oaRest.mapper.IOaRestMapper;
import com.csot.csotoa.oaRest.service.impl.OaRestServiceImpl;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by liushiqi on 2017/7/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PagePermitTest {
    @Autowired
    private IOaRestMapper oaRestMapper;
    @Autowired
    private OaRestServiceImpl oaRestService;

    private String html = "<xform:right mode_N2=\"hidden\" mode_g=\"view\" mode_d=\"view\" mode_N8=\"hidden\" mode_N30=\"hidden\" mode_N10=\"hidden\"\n" +
            "             mode_N7=\"hidden\" mode_N6=\"hidden\" mode_N9=\"hidden\" mode_N35=\"hidden\" mode_N106=\"hidden\" mode_N107=\"hidden\"\n" +
            "             mode_N109=\"hidden\" mode_N25=\"hidden\" mode_N37=\"hidden\" mode_N31=\"hidden\" mode_N28=\"hidden\"\n" +
            "             mode_N32=\"hidden\" mode_N53=\"hidden\" mode_N56=\"hidden\" mode_N29=\"hidden\" mode_N33=\"hidden\" mode_N34=\"hidden\"\n" +
            "             mode_N64=\"hidden\" mode_N36=\"hidden\" mode_N65=\"hidden\" mode_N27=\"hidden\" mode_N24=\"view\" mode_N23=\"hidden\"\n" +
            "             mode_N22=\"view\" mode_N63=\"hidden\" mode_N74=\"hidden\" mode_N15=\"hidden\" mode_N14=\"hidden\" mode_N93=\"view\"\n" +
            "             mode_N68=\"hidden\" mode_N67=\"hidden\" mode_N66=\"hidden\" mode_N40=\"hidden\" mode_N39=\"hidden\" mode_N38=\"hidden\"\n" +
            "             mode_N13=\"hidden\" mode_N12=\"hidden\" mode_N91=\"hidden\" mode_N90=\"view\" mode_N89=\"view\" mode_N18=\"hidden\"\n" +
            "             mode_N44=\"hidden\" mode_N92=\"view\" mode_N71=\"hidden\" mode_N41=\"hidden\" mode_N42=\"hidden\" mode_N43=\"hidden\"\n" +
            "             mode_N69=\"hidden\" mode_N70=\"hidden\" mode_N45=\"hidden\" mode_N46=\"view\" mode_N72=\"hidden\" mode_N73=\"hidden\"\n" +
            "             mode_N94=\"view\" mode_N77=\"hidden\" mode_N16=\"hidden\" mode_N48=\"view\" mode_N49=\"hidden\" mode_N75=\"hidden\"\n" +
            "             mode_N76=\"hidden\" mode_N79=\"hidden\" mode_N95=\"hidden\" mode_N17=\"hidden\" mode_N80=\"hidden\" mode_N47=\"edit\"\n" +
            "             mode_N51=\"hidden\" mode_N52=\"hidden\" mode_N78=\"hidden\" mode_N96=\"view\" mode_N81=\"hidden\" mode_N50=\"hidden\"\n" +
            "             mode_N54=\"hidden\" mode_N55=\"hidden\" mode_N87=\"hidden\" mode_N97=\"view\" mode_N82=\"hidden\" mode_N57=\"hidden\"\n" +
            "             mode_N83=\"hidden\" mode_N98=\"view\" mode_N88=\"hidden\" mode_N19=\"hidden\" mode_N58=\"hidden\" mode_N99=\"hidden\"\n" +
            "             mode_N84=\"hidden\" mode_N60=\"hidden\" mode_N85=\"hidden\" mode_N61=\"hidden\" mode_N86=\"hidden\" mode_N101=\"view\"\n" +
            "             mode_N102=\"hidden\" mode_N103=\"view\" mode_N20=\"view\" mode_N62=\"hidden\" mode_N21=\"edit\" def_N2=\"false\"\n" +
            "             def_N35=\"false\" def_N34=\"false\" def_N8=\"false\" def_N30=\"false\" def_N10=\"false\" def_N7=\"false\"\n" +
            "             def_N6=\"false\" def_N9=\"false\" def_N106=\"false\" def_N107=\"false\" def_N109=\"false\" def_N25=\"false\"\n" +
            "             def_N37=\"false\" def_N32=\"false\" def_N31=\"false\" def_N28=\"false\" def_N53=\"false\" def_N56=\"false\"\n" +
            "             def_N29=\"false\" def_N33=\"false\" def_N64=\"false\" def_N36=\"false\" def_N65=\"false\" def_N27=\"false\"\n" +
            "             def_N24=\"false\" def_N23=\"false\" def_N22=\"false\" def_N63=\"false\" def_N74=\"false\" def_N15=\"false\"\n" +
            "             def_N14=\"false\" def_N93=\"false\" def_N68=\"false\" def_N67=\"false\" def_N66=\"false\" def_N40=\"false\"\n" +
            "             def_N39=\"false\" def_N38=\"false\" def_N13=\"false\" def_N12=\"false\" def_N91=\"false\" def_N90=\"false\"\n" +
            "             def_N89=\"false\" def_N18=\"false\" def_N44=\"false\" def_N92=\"false\" def_N71=\"false\" def_N41=\"false\"\n" +
            "             def_N42=\"false\" def_N43=\"false\" def_N69=\"false\" def_N70=\"false\" def_N45=\"false\" def_N46=\"false\"\n" +
            "             def_N72=\"false\" def_N73=\"false\" def_N94=\"false\" def_N77=\"false\" def_N16=\"false\" def_N48=\"false\"\n" +
            "             def_N49=\"false\" def_N75=\"false\" def_N76=\"false\" def_N79=\"false\" def_N95=\"false\" def_N17=\"false\"\n" +
            "             def_N80=\"false\" def_N47=\"false\" def_N51=\"false\" def_N52=\"false\" def_N78=\"false\" def_N96=\"false\"\n" +
            "             def_N81=\"false\" def_N50=\"false\" def_N54=\"false\" def_N55=\"false\" def_N87=\"false\" def_N97=\"false\"\n" +
            "             def_N82=\"false\" def_N57=\"false\" def_N83=\"false\" def_N98=\"false\" def_N88=\"false\" def_N19=\"false\"\n" +
            "             def_N58=\"false\" def_N99=\"false\" def_N84=\"false\" def_N60=\"false\" def_N85=\"false\" def_N61=\"false\"\n" +
            "             def_N86=\"false\" def_N101=\"true\" def_N102=\"false\" def_N103=\"true\" def_N20=\"false\" def_N62=\"false\"\n" +
            "             def_N21=\"false\">\n" +
            "    <TABLE id=fd_3184cb63ad6464 class=tb_normal align=center label=\"主表\" layout2col=\"undefined\" style=\"width:100%;\">\n" +
            "        <TBODY>\n" +
            "        <TR>\n" +
            "            <TD class=td_normal_title width=189 row=\"0\" column=\"0\">\n" +
            "                <LABEL style=\"TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline\">\n" +
            "                    <xform:lang id='fd_3184cb6b956ad0' option='content'/>\n" +
            "                </LABEL>\n" +
            "            </TD>\n" +
            "            <TD width=393 row=\"0\" column=\"1\">\n" +
            "                <LABEL style=\"WIDTH: 208px; DISPLAY: inline\" _required=true>\n" +
            "                    <xform:address propertyId=\"extendDataFormInfo.value(fd_work_handover.id)\"\n" +
            "                                   propertyName=\"extendDataFormInfo.value(fd_work_handover.name)\" mulSelect=\"false\"\n" +
            "                                   orgType=\"ORG_TYPE_PERSON\" subject=\"${xform:subject('fd_work_handover','label')}\"\n" +
            "                                   title=\"${xform:subject('fd_work_handover','label')}\" style=\"WIDTH: 172px\"\n" +
            "                                   required=\"true\"\n" +
            "                                   onValueChange=\"function(value, domElement){__xformDispatch.call(this,value,domElement);$(document).trigger($.Event('relation_event_setvalue'),'fd_work_handover');}\"\n" +
            "                                   isLoadDataDict=\"false\"/>\n" +
            "                </LABEL>\n" +
            "            </TD>\n" +
            "            <TD class=td_normal_title width=231 row=\"0\" column=\"2\">\n" +
            "                <LABEL style=\"TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline\">\n" +
            "                    <xform:lang id='fd_3184cdae1cc930' option='content'/>\n" +
            "                </LABEL>\n" +
            "            </TD>\n" +
            "            <TD width=382 row=\"0\" column=\"3\">\n" +
            "                <LABEL style=\"WIDTH: 208px; DISPLAY: inline\" _required=true>\n" +
            "                    <xform:address propertyId=\"extendDataFormInfo.value(fd_goods_handover.id)\"\n" +
            "                                   propertyName=\"extendDataFormInfo.value(fd_goods_handover.name)\" mulSelect=\"false\"\n" +
            "                                   orgType=\"ORG_TYPE_PERSON\" subject=\"${xform:subject('fd_goods_handover','label')}\"\n" +
            "                                   title=\"${xform:subject('fd_goods_handover','label')}\" style=\"WIDTH: 172px\"\n" +
            "                                   required=\"true\"\n" +
            "                                   onValueChange=\"function(value, domElement){__xformDispatch.call(this,value,domElement);$(document).trigger($.Event('relation_event_setvalue'),'fd_goods_handover');}\"\n" +
            "                                   isLoadDataDict=\"false\"/>\n" +
            "                </LABEL>\n" +
            "            </TD>\n" +
            "        </TR>\n" +
            "        <TR style=\"HEIGHT: 32px\">\n" +
            "            <TD class=td_normal_title width=191 row=\"1\" column=\"0\">\n" +
            "                <LABEL style=\"TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline\">\n" +
            "                    <xform:lang id='fd_3184cdf4472586' option='content'/>\n" +
            "                </LABEL>\n" +
            "            </TD>\n" +
            "            <TD style=\"WIDTH: auto\" width=1020 colSpan=3 row=\"1\" column=\"1,2,3\">\n" +
            "\n" +
            "                <DIV style=\"word-wrap:break-word;word-break:break-all;WIDTH: 748px; DISPLAY: inline\">\n" +
            "                    <xform:textarea property=\"extendDataFormInfo.value(fd_work_item)\" style=\"HEIGHT: 99px; WIDTH: 748px\"\n" +
            "                                    required=\"false\" subject=\"${xform:subject('fd_work_item','label')}\"\n" +
            "                                    title=\"${xform:subject('fd_work_item','label')}\" onValueChange=\"__xformDispatch\"/>\n" +
            "                </DIV>\n" +
            "            </TD>\n" +
            "        </TR>\n" +
            "        <TR>\n" +
            "            <TD class=td_normal_title width=193 row=\"2\" column=\"0\">\n" +
            "                <LABEL style=\"TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline\">\n" +
            "                    <xform:lang id='fd_3184cdfc8c54d0' option='content'/>\n" +
            "                </LABEL>\n" +
            "            </TD>\n" +
            "            <TD style=\"WIDTH: auto\" width=1019 colSpan=3 row=\"2\" column=\"1,2,3\">\n" +
            "\n" +
            "                <DIV style=\"word-wrap:break-word;word-break:break-all;WIDTH: 747px; DISPLAY: inline\">\n" +
            "                    <xform:textarea property=\"extendDataFormInfo.value(fd_goods_item)\"\n" +
            "                                    style=\"HEIGHT: 102px; WIDTH: 747px\" required=\"false\"\n" +
            "                                    subject=\"${xform:subject('fd_goods_item','label')}\"\n" +
            "                                    title=\"${xform:subject('fd_goods_item','label')}\" onValueChange=\"__xformDispatch\"/>\n" +
            "                </DIV>\n" +
            "            </TD>\n" +
            "        </TR>\n" +
            "        <TR>\n" +
            "            <TD class=td_normal_title width=194 row=\"3\" column=\"0\">\n" +
            "                <LABEL style=\"TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline\">\n" +
            "                    <xform:lang id='fd_3184ce03f617fa' option='content'/>\n" +
            "                </LABEL>\n" +
            "            </TD>\n" +
            "            <TD style=\"WIDTH: auto\" width=1018 colSpan=3 row=\"3\" column=\"1,2,3\">\n" +
            "\n" +
            "                <xform:right mode_N2=\"hidden\" mode_g=\"view\" mode_d=\"view\" mode_N8=\"hidden\" mode_N30=\"hidden\"\n" +
            "                             mode_N10=\"hidden\" mode_N7=\"hidden\" mode_N6=\"hidden\" mode_N9=\"hidden\" mode_N35=\"hidden\"\n" +
            "                             mode_N106=\"hidden\" mode_N107=\"hidden\" mode_N109=\"hidden\" mode_N25=\"hidden\"\n" +
            "                             mode_N37=\"hidden\" mode_N31=\"hidden\" mode_N28=\"hidden\" mode_N32=\"hidden\" mode_N53=\"hidden\"\n" +
            "                             mode_N56=\"hidden\" mode_N29=\"hidden\" mode_N33=\"hidden\" mode_N34=\"hidden\" mode_N64=\"hidden\"\n" +
            "                             mode_N36=\"hidden\" mode_N65=\"hidden\" mode_N27=\"hidden\" mode_N24=\"hidden\" mode_N23=\"hidden\"\n" +
            "                             mode_N22=\"hidden\" mode_N63=\"hidden\" mode_N74=\"hidden\" mode_N15=\"hidden\" mode_N14=\"hidden\"\n" +
            "                             mode_N93=\"hidden\" mode_N68=\"hidden\" mode_N67=\"hidden\" mode_N66=\"hidden\" mode_N40=\"hidden\"\n" +
            "                             mode_N39=\"hidden\" mode_N38=\"hidden\" mode_N13=\"hidden\" mode_N12=\"hidden\" mode_N91=\"hidden\"\n" +
            "                             mode_N90=\"hidden\" mode_N89=\"hidden\" mode_N18=\"hidden\" mode_N44=\"hidden\" mode_N92=\"view\"\n" +
            "                             mode_N71=\"hidden\" mode_N41=\"hidden\" mode_N42=\"hidden\" mode_N43=\"hidden\" mode_N69=\"hidden\"\n" +
            "                             mode_N70=\"hidden\" mode_N45=\"hidden\" mode_N46=\"hidden\" mode_N72=\"hidden\" mode_N73=\"hidden\"\n" +
            "                             mode_N94=\"hidden\" mode_N77=\"view\" mode_N16=\"hidden\" mode_N48=\"hidden\" mode_N49=\"hidden\"\n" +
            "                             mode_N75=\"view\" mode_N76=\"hidden\" mode_N79=\"hidden\" mode_N95=\"hidden\" mode_N17=\"hidden\"\n" +
            "                             mode_N80=\"hidden\" mode_N47=\"hidden\" mode_N51=\"hidden\" mode_N52=\"hidden\" mode_N78=\"hidden\"\n" +
            "                             mode_N96=\"edit\" mode_N81=\"hidden\" mode_N50=\"view\" mode_N54=\"hidden\" mode_N55=\"hidden\"\n" +
            "                             mode_N87=\"hidden\" mode_N97=\"edit\" mode_N82=\"hidden\" mode_N57=\"hidden\" mode_N83=\"hidden\"\n" +
            "                             mode_N98=\"view\" mode_N88=\"hidden\" mode_N19=\"hidden\" mode_N58=\"hidden\" mode_N99=\"hidden\"\n" +
            "                             mode_N84=\"hidden\" mode_N60=\"hidden\" mode_N85=\"hidden\" mode_N61=\"hidden\" mode_N86=\"hidden\"\n" +
            "                             mode_N101=\"view\" mode_N102=\"hidden\" mode_N103=\"view\" mode_N20=\"hidden\" mode_N62=\"hidden\"\n" +
            "                             mode_N21=\"hidden\" mode_N100=\"view\" def_N2=\"false\" def_N35=\"false\" def_N34=\"false\"\n" +
            "                             def_N8=\"false\" def_N30=\"false\" def_N10=\"false\" def_N7=\"false\" def_N6=\"false\" def_N9=\"false\"\n" +
            "                             def_N106=\"false\" def_N107=\"false\" def_N109=\"false\" def_N25=\"false\" def_N37=\"false\"\n" +
            "                             def_N32=\"false\" def_N31=\"false\" def_N28=\"false\" def_N53=\"false\" def_N56=\"false\"\n" +
            "                             def_N29=\"false\" def_N33=\"false\" def_N64=\"false\" def_N36=\"false\" def_N65=\"false\"\n" +
            "                             def_N27=\"false\" def_N24=\"false\" def_N23=\"false\" def_N22=\"false\" def_N63=\"false\"\n" +
            "                             def_N74=\"false\" def_N15=\"false\" def_N14=\"false\" def_N93=\"false\" def_N68=\"false\"\n" +
            "                             def_N67=\"false\" def_N66=\"false\" def_N40=\"false\" def_N39=\"false\" def_N38=\"false\"\n" +
            "                             def_N13=\"false\" def_N12=\"false\" def_N91=\"false\" def_N90=\"false\" def_N89=\"false\"\n" +
            "                             def_N18=\"false\" def_N44=\"false\" def_N92=\"false\" def_N71=\"false\" def_N41=\"false\"\n" +
            "                             def_N42=\"false\" def_N43=\"false\" def_N69=\"false\" def_N70=\"false\" def_N45=\"false\"\n" +
            "                             def_N46=\"true\" def_N72=\"false\" def_N73=\"false\" def_N94=\"false\" def_N77=\"false\"\n" +
            "                             def_N16=\"false\" def_N48=\"false\" def_N49=\"false\" def_N75=\"false\" def_N76=\"false\"\n" +
            "                             def_N79=\"false\" def_N95=\"false\" def_N17=\"false\" def_N80=\"false\" def_N47=\"false\"\n" +
            "                             def_N51=\"false\" def_N52=\"false\" def_N78=\"false\" def_N96=\"false\" def_N81=\"false\"\n" +
            "                             def_N50=\"false\" def_N54=\"false\" def_N55=\"false\" def_N87=\"false\" def_N97=\"false\"\n" +
            "                             def_N82=\"false\" def_N57=\"false\" def_N83=\"false\" def_N98=\"true\" def_N88=\"false\"\n" +
            "                             def_N19=\"false\" def_N58=\"false\" def_N99=\"false\" def_N84=\"false\" def_N60=\"false\"\n" +
            "                             def_N85=\"false\" def_N61=\"false\" def_N86=\"false\" def_N101=\"false\" def_N102=\"false\"\n" +
            "                             def_N103=\"false\" def_N20=\"false\" def_N62=\"false\" def_N21=\"false\" def_N100=\"false\">\n" +
            "                    <DIV style=\"WIDTH: 208px; DISPLAY: inline\" _required=true>\n" +
            "                        <xform:datetime property=\"extendDataFormInfo.value(fd_transfer_date)\" style=\"WIDTH: 172px\"\n" +
            "                                        required=\"true\" subject=\"${xform:subject('fd_transfer_date','label')}\"\n" +
            "                                        title=\"${xform:subject('fd_transfer_date','label')}\"\n" +
            "                                        onValueChange=\"__xformDispatch\" dateTimeType=\"date\" isLoadDataDict=\"false\"/>\n" +
            "                    </DIV>\n" +
            "\n" +
            "                </xform:right>\n" +
            "            </TD>\n" +
            "        </TR>\n" +
            "        </TBODY>\n" +
            "    </TABLE>\n" +
            "</xform:right>";

    @Test
    public void testOAgetPagePermit() {
        String fdId = "15d4e85fb9887eda045b91044049489b";
        String templateId = "1429dd1425bc079b0f8dfd04a2b95a0b";
        String name = "huchanglong01";
        List<Map<String, String>> list = new ArrayList<>();
        try {
            Map<String, String> map = oaRestService.getPagePermit(fdId, templateId, name);
            System.out.println("items:===>>" + map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetPagePermit() {
        String fdId = "15d4e85fb9887eda045b91044049489b";
        String node = oaRestMapper.getCurrNode(fdId);
        String templateId = "1429dd1425bc079b0f8dfd04a2b95a0b";
        String html = oaRestMapper.getTemplatePage(templateId);
        System.out.println("node:" + node);
        Map<String, String> list = methodPage(html, node);
        System.out.println("list---->>" + list.toString());

    }

    @Test
    public void testCheckFlowNodeSet() {
        String fdId = "15d83f398d6fe7947a9fa6543d7b42b8";
        String userName="";
        boolean x = oaRestService.checkFlowNodeSet(fdId,userName);
        System.out.println("x==========>>" + x);
    }

    @Test
    public void getHtmlItems() {
        Map<String, String> list = methodPage(html, "N8");
        System.out.println("pageSize====>>" + list.toString());


    }

    @Test
    public void getXmlDate() {
        String xml = "<reviewNode canModifyFlow=\"false\" canModifyMainDoc=\"false\" canModifyNotionPopedom=\"false\" dayOfNotify=\"1\" dayOfPass=\"0\" handlerIds=\"$docCreator$\" handlerNames=\"$申请人$\" handlerSelectType=\"formula\" hasInitSysOrgElment=\"false\" id=\"N4\" ignoreOnHandlerEmpty=\"false\" ignoreOnHandlerSame=\"false\" mustModifyHandlerNodeIds=\"N6\" name=\"申请人确认\" optHandlerCalType=\"2\" optHandlerSelectType=\"org\" orgAttributes=\"optHandlerIds:optHandlerNames;otherCanViewCurNodeIds:otherCanViewCurNodeNames\" processType=\"0\" recalculateHandler=\"true\" tranNotifyDraft=\"0\" tranNotifyPrivate=\"0\" useOptHandlerOnly=\"false\" x=\"360\" y=\"380\">\n" +
                "<operations refId=\"133ef1c3b3eb2dd2331b82f4e70950ee\"/>\n" +
                "</reviewNode>";

        String result = "";
        org.dom4j.Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        org.dom4j.Element root = document.getRootElement();
        System.out.println("root--->>" + root.getName());
        Iterator iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            System.out.println("--------->>" + element.nodeName());
            /*if (element.getName().equals(nodeName)) {
                Attribute att = element.attribute(attr);
                if(null != att){
                    result = att.getValue();
                }
            }*/
        }
    }

    private Map<String, String> methodPage(String html, String nodeStr) {
        // List<Map<String, String>> result = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements elements = doc.getElementsByTag("xform:right");
        ListIterator<Element> listIterator = (ListIterator<Element>) elements.listIterator();

        // 权限信息
        Map<String, String> attrMap = new HashMap<>();
        Map<String, String> node = new HashMap<>();

        while (listIterator.hasNext()) {

            Element element = listIterator.next();
            Attributes attributes = element.attributes();
            Iterator<Attribute> aIterator = attributes.iterator();
            boolean flag = false;
            String attr = "";

            while (aIterator.hasNext()) {
                Attribute attribute = aIterator.next();
                if (attribute.getKey().toLowerCase().equals("mode_" + nodeStr.toLowerCase())) {
                    if (attribute.getValue().equals("hidden") || attribute.getValue().equals("edit")) {
                        // node.put("node", attribute.getKey());
                        attr = attribute.getValue();
                        flag = true;
                    }
                }
            }
            //字段信息
            if (flag) {
                Elements fieldItems = element.getAllElements();
                for (Element fieldItem : fieldItems) {
                    String property = fieldItem.attr("property");
                    if (property != null && property.startsWith("extendDataFormInfo.value(")) {
                        property = property.replace("extendDataFormInfo.value(", "").replace(")", "");
                        int lastDot = property.lastIndexOf(".");
                        if (lastDot > -1 && property.length() > (lastDot + 1)) {
                            property = property.substring(lastDot + 1);
                        }
                        node.put(property.toString(), attr);
                        // node.putAll(attrMap);
                    }
                    String propertyId = fieldItem.attr("propertyId");
                    if (propertyId != null && propertyId.startsWith("extendDataFormInfo.value(")) {
                        propertyId = propertyId.replace("extendDataFormInfo.value(", "").replace(")", "");
                        int lastDot = propertyId.lastIndexOf(".");
                        if (lastDot > -1 && propertyId.length() > (lastDot + 1)) {
                            propertyId = propertyId.substring(0, lastDot);
                        }
                        node.put(propertyId.toString(), attr);
                        // node.putAll(attrMap);
                    }
                }
            }
            // if (!node.isEmpty()) {
            // result.add(node);
            // }
        }
        return node;
    }
}
