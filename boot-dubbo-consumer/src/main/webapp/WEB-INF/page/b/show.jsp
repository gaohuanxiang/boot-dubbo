<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2022/7/18
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/page/common/taglibs.jsp" %>
<html>
<head>
    <title>Title</title>
    <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/res/my97/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form id="fr">
    <input type="hidden" name="pageSize" value="3">
    <input type="hidden" name="pageNo" value="1" id="sp">
    书名模糊查:
    <input type="text" name="bookName" onchange="search()"><br>
    查询时间:
    <input type="text" name="minTime" onchange="search()" onclick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd',skin:'YcloudRed',alwaysUseStartDate:true})">
    ~
    <input type="text" name="maxTime" onchange="search()" onclick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd',skin:'YcloudRed',alwaysUseStartDate:true})"><br>
</form>
    <table style="margin-top:100px" align="center" border="1" cellspacing="1">
        <tr>
            <td>序号</td>
            <td>书名</td>
            <td>价格</td>
            <td>创建时间</td>
            <td>作者</td>
        </tr>
        <tbody id="tb"></tbody>
    </table>
    <div id="div"></div>
</body>
<script>

    $(function () {
        search();
    });
    function search() {

        $.post("${ctx}/b/show",
            $("#fr").serialize(),
            function (result) {
            console.log(result);
                var htmls = "";
                var htmlsq = "";
                for (let i = 0; i < result.data.records.length; i++) {
                    var a = result.data.records[i];
                    htmls += "<tr>";
                    htmls += "<td>"+a.id+"</td>";
                    htmls += "<td>"+a.bookName+"</td>";
                    htmls += "<td>"+a.bookPrice+"</td>";
                    htmls += "<td>"+a.releaseTime+"</td>";
                    htmls += "<td>"+a.userName+"</td>";
                    htmls += "</tr>";
                }
                $("#tb").html(htmls);
                htmlsq += "<input type='button' value='上一页' onclick='up(true)'>";
                htmlsq += "<input type='button' value='下一页' onclick='up(false, "+result.data.pages+")'><br/>";
                $("#div").html(htmlsq);
        });
    }
    var pageNo = 1;
    function up(re, pages) {
        if (re) {
            if (pageNo == 1){
                layer.msg("已经是首页了")
                return;
            }
            pageNo--;
            layer.msg("第"+pageNo+"页");
        } else {
            if (pageNo == pages) {
                layer.msg("已经是尾页了")
                return;
            }
            pageNo++;
            layer.msg("第"+pageNo+"页");
        }
        $("#sp").val(pageNo);
        search(pageNo);
    }
    function upda(re) {
        location.href = "${ctx}/u/toUpdate/"+re;
    }
    function del(re) {
        $.post(
            "${ctx}/u/deleteUser",
            {id:re},
            function (result) {
                if(result.code !== 200){
                    layer.alert(result.msg, {
                        icon: 2,
                        skin: 'layui-layer-lan'
                    })
                    return;
                }
                layer.msg("删除成功,即将加载到首页",
                    {time:1500},
                    function(){
                        search(1);
                    })
        });
    }


</script>
</html>
