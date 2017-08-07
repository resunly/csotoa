<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/resource/jsp/common.jsp" %>
<%@ page import="com.landray.kmss.web.taglib.xform.TagUtils" %>
<TABLE id=fd_2f4bbd16f8efd0 class=tb_normal align=center label="主表" style="width:100%;">
    <TBODY>
    <TR>
        <TD class=td_normal_title style="WIDTH: auto" width=1513 colSpan=7 align=right row="0" column="0,1,2,3,4,5,6">
            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: 微软雅黑;  FONT-WEIGHT: normal; COLOR: #333366; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_2fff35a19ce93e' option='content'/></LABEL>
        </TD>
    </TR>
    <TR>
        <TD class=td_normal_title style="WIDTH: 146px" width=148 row="1" column="0">
            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_2f4bbd19a7868e' option='content'/></LABEL>
        </TD>
        <TD style="WIDTH: 257px" width=250 row="1" column="1">

            <DIV style="WIDTH: 178px; DISPLAY: inline" canShow="true"><xform:xtext
                    property="extendDataFormInfo.value(fdKOSTL)" style="WIDTH: 178px" required="false"
                    subject="${xform:subject('fdKOSTL','label')}" title="${xform:subject('fdKOSTL','label')}"
                    onValueChange="__xformDispatch"/></DIV>


            <DIV style="display:none;" canShow="false"><xform:xtext property="extendDataFormInfo.value(fdISBOM)"
                                                                    style="WIDTH: 62px" required="false"
                                                                    showStatus="noShow"
                                                                    subject="${xform:subject('fdISBOM','label')}"
                                                                    title="${xform:subject('fdISBOM','label')}"
                                                                    onValueChange="__xformDispatch"/></DIV>
        </TD>
        <TD class=td_normal_title style="WIDTH: 116px" width=111 row="1" column="2">
            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3127478d39ea30' option='content'/></LABEL>
        </TD>
        <TD style="WIDTH: 206px" width=208 row="1" column="3">

            <DIV style="WIDTH: 153px; DISPLAY: inline" canShow="true"><xform:xtext
                    property="extendDataFormInfo.value(fd_3127478fddf3c6)" style="WIDTH: 153px" required="false"
                    subject="${xform:subject('fd_3127478fddf3c6','label')}"
                    title="${xform:subject('fd_3127478fddf3c6','label')}" onValueChange="__xformDispatch"/></DIV>
        </TD>
        <TD style="WIDTH: 130px" width=133 row="1" column="4">
            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_2f4e32c2cc685c' option='content'/></LABEL>
        </TD>
        <TD style="WIDTH: 106px" width=195 row="1" column="5">

            <DIV style="WIDTH: 154px; DISPLAY: inline" canShow="true"><xform:xtext
                    property="extendDataFormInfo.value(fdBWART)" style="WIDTH: 154px" required="false"
                    subject="${xform:subject('fdBWART','label')}" title="${xform:subject('fdBWART','label')}"
                    onValueChange="__xformDispatch"/></DIV>
        </TD>
        <TD style="HEIGHT: auto; WIDTH: 570px" rowSpan=2 width=468 row="1,2" column="6">

            <TABLE class=tb_noborder style="WIDTH: 174px; DISPLAY: inline">
                <xform:checkbox property="extendDataFormInfo.value(fdTYPE)" dataType="String" alignment="V"
                                required="false" subject="${xform:subject('fdTYPE','label')}"
                                title="${xform:subject('fdTYPE','label')}" onValueChange="__xformDispatch">
                    <xform:langDataSource><xform:lang id='fdTYPE' option='items'/></xform:langDataSource>
                </xform:checkbox></TABLE>

        </TD>
    </TR>
    <TR style="HEIGHT: 32px">
        <TD class=td_normal_title style="WIDTH: 146px" width=148 row="2" column="0">
            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_2f4e32c9c60882' option='content'/></LABEL>
        </TD>
        <TD style="WIDTH: 257px" width=250 row="2" column="1">

            <DIV style="WIDTH: 176px; DISPLAY: inline" canShow="true"><xform:xtext
                    property="extendDataFormInfo.value(fdRSNUM)" style="WIDTH: 176px" required="false"
                    subject="${xform:subject('fdRSNUM','label')}" title="${xform:subject('fdRSNUM','label')}"
                    onValueChange="__xformDispatch"/></DIV>
        </TD>
        <TD class=td_normal_title style="WIDTH: 116px" width=111 row="2" column="2">
            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_2f4e32d3d9e380' option='content'/></LABEL>
        </TD>
        <TD style="WIDTH: 206px" width=208 row="2" column="3">

            <DIV style="WIDTH: 157px; DISPLAY: inline" canShow="true"><xform:xtext
                    property="extendDataFormInfo.value(fdBDTER)" style="WIDTH: 157px" required="false"
                    subject="${xform:subject('fdBDTER','label')}" title="${xform:subject('fdBDTER','label')}"
                    onValueChange="__xformDispatch"/></DIV>
        </TD>
        <TD style="WIDTH: 130px" width=133 row="2" column="4">
            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_2f4e32da579c44' option='content'/></LABEL>
        </TD>
        <TD style="WIDTH: 106px" width=195 row="2" column="5">

            <DIV style="WIDTH: 178px; DISPLAY: inline" canShow="true"><xform:xtext
                    property="extendDataFormInfo.value(fdAUFNR)" style="WIDTH: 178px" required="false"
                    subject="${xform:subject('fdAUFNR','label')}" title="${xform:subject('fdAUFNR','label')}"
                    onValueChange="__xformDispatch"/></DIV>
        </TD>
    </TR>
    <TR>
        <TD class=td_normal_title style="WIDTH: auto" width=1513 colSpan=7 row="3" column="0,1,2,3,4,5,6">

            <xform:editShow>
                <script>$(function () {
                    var tb = document.getElementById('TABLE_DL_fdItemDetails');
                    tb.setAttribute('tbdraggable', 'true');
                });</script>
            </xform:editShow>
            <xform:viewShow>
                <script>$(function () {
                    var tb = document.getElementById('TABLE_DL_fdItemDetails');
                    tb.setAttribute('tbdraggable', 'false');
                    $(tb).css('margin-bottom', '1px');
                });</script>
            </xform:viewShow>
            <script>Com_IncludeFile('doclist.js');</script>
            <script>DocList_Info.push('TABLE_DL_fdItemDetails');</script>
            <xform:editShow><c:if test="${empty _xformForm.extendDataFormInfo.formData.fdItemDetails}">
                <script>Com_AddEventListener(window, 'load', function () {
                    setTimeout(function () {
                        for (var i = 0; i < 1; i++) {
                            DocList_AddRow(document.getElementById('TABLE_DL_fdItemDetails'))
                        }
                        ;
                    }, 500);
                });</script>
            </c:if></xform:editShow>
            <script>$(function () {
                var tb = document.getElementById('TABLE_DL_fdItemDetails');
                var totalWidth = 0;
                var tds = $(tb).find("tr[type='titleRow']").children();
                var hasPercent = false;
                tds.each(function () {
                    if (!this.width || this.width + ''.indexOf('%') >= 0) {
                        totalWidth += $(this).width();
                        hasPercent = true;
                    } else {
                        totalWidth += parseInt(this.width);
                    }
                });
                var tdWidth = $(tb).parents('td').width();
                if (!hasPercent && totalWidth > tdWidth)$(tb).css('width', totalWidth + 'px');
                var tb_div = document.getElementById('TABLE_DL_fdItemDetails_div');
                $(tb_div).css('width', 'null');
            });</script>
            <div id='TABLE_DL_fdItemDetails_div' style='overflow:auto;'>
                <TABLE id=TABLE_DL_fdItemDetails class=tb_normal style="WIDTH: 100%" align=center label="明细表2"
                       tableName="fd_2f4bbd16f8efd0"
                       columnsWidth="10px;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;7.6923076923076925%;10px"
                       showIndex="true" showRow="1" showStatisticRow="true">
                    <TR class=tr_normal_title type="titleRow">
                        <xform:editShow>
                            <td row='1' column='0' align='center' coltype='selectCol' style='width: 15px;'></td>
                        </xform:editShow>
                        <TD style="WIDTH: 10px" align=center row="0" column="0" colType="noTitle"><kmss:message
                                key="page.serial"/></TD>
                        <TD width="7.69%" align=center row="0" column="1">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebd5d4cb66' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" align=center row="0" column="2">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebd67974b2' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" align=center row="0" column="3">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebd70dc36a' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="4">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebd78eabe2' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="5">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebd7f9d830' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="6">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebd866ecaa' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="7">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebd8d103be' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="8">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebd938c9d2' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="9">
                            <LABEL style="TEXT-DECORATION: none;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_33aadd71cc6e60' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="10">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebd9a5c6a6' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="11">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebda1213e2' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="12">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_3124ebda7b662a' option='content'/></LABEL>
                        </TD>
                        <TD width="7.69%" row="0" column="13">
                            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                                    id='fd_31273dd3916892' option='content'/></LABEL>
                        </TD>

                        <xform:editShow>
                            <TD style="width:48px;" align=center row="0" column="14" colType="addTitle"></TD>
                        </xform:editShow></TR>
                    <%-- 基准行 --%>
                    <TR KMSS_IsReferRow="1" style="display:none" type="templateRow">
                        <xform:editShow>
                            <td row='1' column='0' align='center' coltype='selectCol' style='width: 15px;'><input
                                    type='checkbox' name='DocList_Selected'/></td>
                        </xform:editShow>
                        <TD style="WIDTH: 10px" align=center row="1" column="0" colType="noTemplate" KMSS_IsRowIndex=1>
                            {1}
                        </TD>
                        <TD align=center row="1" column="1">

                            <DIV style="WIDTH: 50px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdLINE)"
                                    style="WIDTH: 50px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdLINE','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdLINE','label')}"
                                    onValueChange="__xformDispatch"/></DIV>

                            <%-- 明细表行ID --%>
                            <xform:text showStatus="noShow"
                                        property="extendDataFormInfo.value(fdItemDetails.!{index}.fdId)"/>
                        </TD>
                        <TD align=center row="1" column="2">

                            <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdMATNR)"
                                    style="WIDTH: 120px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdMATNR','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdMATNR','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD align=center row="1" column="3">

                            <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdMAKTX)"
                                    style="WIDTH: 120px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdMAKTX','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdMAKTX','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD row="1" column="4">

                            <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdATWRT2)"
                                    style="WIDTH: 120px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdATWRT2','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdATWRT2','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD row="1" column="5">

                            <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdATWRT3)"
                                    style="WIDTH: 120px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdATWRT3','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdATWRT3','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD row="1" column="6">

                            <DIV style="WIDTH: 30px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdMEINS)"
                                    style="WIDTH: 30px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdMEINS','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdMEINS','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD row="1" column="7">

                            <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdCHARG)"
                                    style="WIDTH: 120px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdCHARG','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdCHARG','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD row="1" column="8">

                            <DIV style="WIDTH: 60px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdLGORT1)"
                                    style="WIDTH: 60px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdLGORT1','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdLGORT1','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD row="1" column="9">

                            <TABLE class=tb_noborder style="WIDTH: 80px; DISPLAY: inline">
                                <xform:radio property="extendDataFormInfo.value(fdItemDetails.!{index}.fdMSFTK)"
                                             alignment="H" required="false"
                                             subject="${xform:subject('fdItemDetails.!{index}.fdMSFTK','label')}"
                                             title="${xform:subject('fdItemDetails.!{index}.fdMSFTK','label')}"
                                             onValueChange="__xformDispatch">
                                    <xform:langDataSource><xform:lang id='fdItemDetails.!{index}.fdMSFTK'
                                                                      option='items'/></xform:langDataSource>
                                </xform:radio></TABLE>

                        </TD>
                        <TD row="1" column="10">

                            <DIV style="WIDTH: 60px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdMENGE1)"
                                    style="WIDTH: 60px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdMENGE1','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdMENGE1','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD row="1" column="11">

                            <DIV style="WIDTH: 60px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdMENGE2)"
                                    style="WIDTH: 60px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdMENGE2','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdMENGE2','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD row="1" column="12">

                            <DIV style="WIDTH: 60px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdLGORT2)"
                                    style="WIDTH: 60px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdLGORT2','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdLGORT2','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>
                        <TD row="1" column="13">

                            <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                    property="extendDataFormInfo.value(fdItemDetails.!{index}.fdMCODE)"
                                    style="WIDTH: 120px" required="false"
                                    subject="${xform:subject('fdItemDetails.!{index}.fdMCODE','label')}"
                                    title="${xform:subject('fdItemDetails.!{index}.fdMCODE','label')}"
                                    onValueChange="__xformDispatch"/></DIV>
                        </TD>

                        <xform:editShow>
                            <TD style="WIDTH: 48px" align=center row="1" column="14" colType="delCol">
                                <nobr><span style='cursor:pointer' class='optStyle opt_copy_style'
                                            title='<bean:message bundle="sys-xform" key="xform.button.copy" />'
                                            onmousedown='DocList_CopyRow();'></span>&nbsp;&nbsp;<span
                                        style='cursor:pointer' class='optStyle opt_del_style'
                                        title='<bean:message bundle="sys-xform" key="xform.button.delete" />'
                                        onmousedown='DocList_DeleteRow_ClearLast();XFom_RestValidationElements();'></span>&nbsp;&nbsp;
                                </nobr>
                            </TD>
                        </xform:editShow>
                    </TR>
                    <%-- 内容行 --%>
                    <c:forEach items="${_xformForm.extendDataFormInfo.formData.fdItemDetails}" var="_xformEachBean"
                               varStatus="vstatus">
                        <TR KMSS_IsContentRow="1" type="templateRow">
                            <xform:editShow>
                                <td row='1' column='0' align='center' coltype='selectCol' style='width: 15px;'><input
                                        type='checkbox' name='DocList_Selected'/></td>
                            </xform:editShow>
                            <TD style="WIDTH: 10px" align=center row="1" column="0" colType="noTemplate"
                                KMSS_IsRowIndex=1>${vstatus.index + 1}</TD>
                            <TD align=center row="1" column="1">

                                <DIV style="WIDTH: 50px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdLINE)"
                                        style="WIDTH: 50px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdLINE','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdLINE','label')}"
                                        onValueChange="__xformDispatch"/></DIV>

                                    <%-- 明细表行ID --%>
                                <xform:text showStatus="noShow"
                                            property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdId)"/>
                            </TD>
                            <TD align=center row="1" column="2">

                                <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdMATNR)"
                                        style="WIDTH: 120px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdMATNR','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdMATNR','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD align=center row="1" column="3">

                                <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdMAKTX)"
                                        style="WIDTH: 120px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdMAKTX','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdMAKTX','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD row="1" column="4">

                                <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdATWRT2)"
                                        style="WIDTH: 120px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdATWRT2','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdATWRT2','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD row="1" column="5">

                                <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdATWRT3)"
                                        style="WIDTH: 120px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdATWRT3','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdATWRT3','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD row="1" column="6">

                                <DIV style="WIDTH: 30px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdMEINS)"
                                        style="WIDTH: 30px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdMEINS','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdMEINS','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD row="1" column="7">

                                <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdCHARG)"
                                        style="WIDTH: 120px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdCHARG','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdCHARG','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD row="1" column="8">

                                <DIV style="WIDTH: 60px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdLGORT1)"
                                        style="WIDTH: 60px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdLGORT1','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdLGORT1','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD row="1" column="9">

                                <TABLE class=tb_noborder style="WIDTH: 80px; DISPLAY: inline">
                                    <xform:radio
                                            property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdMSFTK)"
                                            alignment="H" required="false"
                                            subject="${xform:subject('fdItemDetails.${vstatus.index}.fdMSFTK','label')}"
                                            title="${xform:subject('fdItemDetails.${vstatus.index}.fdMSFTK','label')}"
                                            onValueChange="__xformDispatch">
                                        <xform:langDataSource><xform:lang id='fdItemDetails.${vstatus.index}.fdMSFTK'
                                                                          option='items'/></xform:langDataSource>
                                    </xform:radio></TABLE>

                            </TD>
                            <TD row="1" column="10">

                                <DIV style="WIDTH: 60px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdMENGE1)"
                                        style="WIDTH: 60px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdMENGE1','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdMENGE1','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD row="1" column="11">

                                <DIV style="WIDTH: 60px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdMENGE2)"
                                        style="WIDTH: 60px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdMENGE2','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdMENGE2','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD row="1" column="12">

                                <DIV style="WIDTH: 60px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdLGORT2)"
                                        style="WIDTH: 60px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdLGORT2','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdLGORT2','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>
                            <TD row="1" column="13">

                                <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                                        property="extendDataFormInfo.value(fdItemDetails.${vstatus.index}.fdMCODE)"
                                        style="WIDTH: 120px" required="false"
                                        subject="${xform:subject('fdItemDetails.${vstatus.index}.fdMCODE','label')}"
                                        title="${xform:subject('fdItemDetails.${vstatus.index}.fdMCODE','label')}"
                                        onValueChange="__xformDispatch"/></DIV>
                            </TD>

                            <xform:editShow>
                                <TD style="WIDTH: 48px" align=center row="1" column="14" colType="delCol">
                                    <nobr><span style='cursor:pointer' class='optStyle opt_copy_style'
                                                title='<bean:message bundle="sys-xform" key="xform.button.copy" />'
                                                onmousedown='DocList_CopyRow();'></span>&nbsp;&nbsp;<span
                                            style='cursor:pointer' class='optStyle opt_del_style'
                                            title='<bean:message bundle="sys-xform" key="xform.button.delete" />'
                                            onmousedown='DocList_DeleteRow_ClearLast();XFom_RestValidationElements();'></span>&nbsp;&nbsp;
                                    </nobr>
                                </TD>
                            </xform:editShow>
                        </TR>
                    </c:forEach>
                    <TR type="statisticRow">
                        <xform:editShow>
                            <td row='1' column='0' align='center' coltype='selectCol' style='width: 15px;'></td>
                        </xform:editShow>
                        <TD style="WIDTH: 10px" align=center row="2" column="0" colType="noFoot">&nbsp;</TD>
                        <TD align=center row="2" column="1">&nbsp;</TD>
                        <TD align=center row="2" column="2">&nbsp;</TD>
                        <TD align=center row="2" column="3">&nbsp;</TD>
                        <TD row="2" column="4">&nbsp;</TD>
                        <TD row="2" column="5">&nbsp;</TD>
                        <TD row="2" column="6">&nbsp;</TD>
                        <TD row="2" column="7">&nbsp;</TD>
                        <TD row="2" column="8">&nbsp;</TD>
                        <TD row="2" column="9">&nbsp;</TD>
                        <TD row="2" column="10">&nbsp;</TD>
                        <TD row="2" column="11">&nbsp;</TD>
                        <TD row="2" column="12">&nbsp;</TD>
                        <TD row="2" column="13">&nbsp;</TD>

                        <xform:editShow>
                            <TD style="WIDTH: 48px" align=center row="2" column="14" colType="emptyCell">&nbsp;</TD>
                        </xform:editShow></TR>
                    <xform:editShow>
                        <tr type='optRow' class='tr_normal_opt'>
                            <td row='3' column='0' align='center' coltype='optCol'>
                                <nobr><span style='cursor:pointer' class='optStyle opt_add_style'
                                            title='<bean:message bundle="sys-xform" key="xform.button.add" />'
                                            onclick='DocList_AddRow();XFom_RestValidationElements();'></span>&nbsp;&nbsp;<span
                                        style='cursor:pointer' class='optStyle opt_up_style'
                                        title='<bean:message bundle="sys-xform" key="xform.button.moveup" />'
                                        onclick='DocList_MoveRowBySelect(-1);'></span>&nbsp;&nbsp;<span
                                        style='cursor:pointer' class='optStyle opt_down_style'
                                        title='<bean:message bundle="sys-xform" key="xform.button.movedown" />'
                                        onclick='DocList_MoveRowBySelect(1);'></span></nobr>
                            </td>
                        </tr>
                    </xform:editShow>

                </TABLE>
            </div>
        </TD>
    </TR>
    <TR>
        <TD class=td_normal_title style="WIDTH: 146px" width=148 row="4" column="0">
            <LABEL style="TEXT-DECORATION: none;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_32d428d88bc26a' option='content'/></LABEL>
        </TD>
        <TD style="WIDTH: auto" width=1366 colSpan=6 row="4" column="1,2,3,4,5,6">

            <DIV style="WIDTH: auto; DISPLAY: inline" _required=true>
                <xform:radio property="extendDataFormInfo.value(fd_is_emergency)" alignment="H" required="true"
                             subject="${xform:subject('fd_is_emergency','label')}"
                             title="${xform:subject('fd_is_emergency','label')}" onValueChange="__xformDispatch">
                    <xform:langDataSource><xform:lang id='fd_is_emergency' option='items'/></xform:langDataSource>
                </xform:radio></DIV>

        </TD>
    </TR>
    <TR>
        <TD class=td_normal_title style="WIDTH: 146px" width=148 row="5" column="0">
            <LABEL style="TEXT-DECORATION: none;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_326983bc209d08' option='content'/></LABEL>
        </TD>
        <TD style="WIDTH: auto" width=1365 colSpan=6 row="5" column="1,2,3,4,5,6">

            <DIV style="WIDTH: 120px; DISPLAY: inline" canShow="true"><xform:xtext
                    property="extendDataFormInfo.value(fdEmpNO)" style="WIDTH: 120px" required="false"
                    subject="${xform:subject('fdEmpNO','label')}" title="${xform:subject('fdEmpNO','label')}"
                    onValueChange="__xformDispatch"/></DIV>

            <LABEL style="TEXT-DECORATION: none;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_326baf62cec8ce' option='content'/></LABEL>
        </TD>
    </TR>
    <TR style="HEIGHT: 106px">
        <TD class=td_normal_title style="WIDTH: 146px" width=148 row="6" column="0">
            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_2f4e33e3e6316e' option='content'/></LABEL>
        </TD>
        <TD style="WIDTH: auto" width=1365 colSpan=6 row="6" column="1,2,3,4,5,6">

            <DIV style="word-wrap:break-word;word-break:break-all;WIDTH: 901px; DISPLAY: inline"><xform:textarea
                    property="extendDataFormInfo.value(fdREMARK)" style="HEIGHT: 88px; WIDTH: 901px" required="false"
                    subject="${xform:subject('fdREMARK','label')}" title="${xform:subject('fdREMARK','label')}"
                    onValueChange="__xformDispatch"/></DIV>


            <DIV style="display:none;" canShow="false"><xform:xtext property="extendDataFormInfo.value(fdDMBTR)"
                                                                    style="WIDTH: 110px" required="false"
                                                                    htmlElementProperties="thousandShow='null'"
                                                                    dataType="Double" showStatus="noShow"
                                                                    subject="${xform:subject('fdDMBTR','label')}"
                                                                    title="${xform:subject('fdDMBTR','label')}"
                                                                    validators=" number number scaleLength(2)"
                                                                    onValueChange="__xformDispatch"/></DIV>
        </TD>
    </TR>
    <TR>
        <TD class=td_normal_title style="WIDTH: auto" width=1513 colSpan=7 row="7" column="0,1,2,3,4,5,6">
            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_312747f62b10d2' option='content'/></LABEL>

            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3128e7eaf8a596' option='content'/></LABEL>

            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3128e8262a8cfe' option='content'/></LABEL>

            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3128e81ebbdf26' option='content'/></LABEL>

            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3128e8455bafa0' option='content'/></LABEL>

            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3128e83dac777c' option='content'/></LABEL>

            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3128e848a0412e' option='content'/></LABEL>

            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3128e853e0ba5c' option='content'/></LABEL>

            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3128e856a09e2c' option='content'/></LABEL>

            <LABEL style="TEXT-DECORATION: none; FONT-FAMILY: null;  FONT-WEIGHT: normal; FONT-STYLE: normal; DISPLAY: inline"><xform:lang
                    id='fd_3128e858e0bfd2' option='content'/></LABEL>
        </TD>
    </TR>
    </TBODY>
</TABLE>