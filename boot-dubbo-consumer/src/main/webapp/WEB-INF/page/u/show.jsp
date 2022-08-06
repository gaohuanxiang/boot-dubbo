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
</head>
<body>
<form id="fr">
    <input type="hidden" name="pageSize" value="3">
    <input type="hidden" name="pageNo" value="1" id="sp">
  姓名模糊查<input type="text" name="userName" onchange="search()"><br>
    <%--  最小年龄<input type="text" name="minAge" onchange="search()">~
    <input type="text" name="maxAge" onchange="search()">最大年龄<br>--%>
</form>
    <table style="margin-top:100px" align="center" border="1" cellspacing="1">
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>密码</td>
            <td>昵称</td>
            <td>操作</td>
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

        $.post("${ctx}/u/show",
            $("#fr").serialize(),
            function (result) {
                var htmls = "";
                var htmlsq = "";
                for (let i = 0; i < result.data.records.length; i++) {
                    var a = result.data.records[i];
                    htmls += "<tr>";
                    htmls += "<td>"+a.id+"</td>";
                    htmls += "<td>"+a.userName+"</td>";
                    htmls += "<td>"+a.password+"</td>";
                    htmls += "<td>"+a.nickName+"</td>";
                    htmls += "<td><input type='button' value='拥有书量' onclick='upda("+a.id+")'></td>";
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
        $.get("${ctx}/u/show/"+re,{}, function (result) {
            console.log(result);
            layer.alert("拥有书量"+result.data.bookNumber+"本");

        });
    }
</script>
</html>
