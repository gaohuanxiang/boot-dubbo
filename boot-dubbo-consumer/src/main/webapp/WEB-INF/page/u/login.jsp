<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2022/7/31
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/page/common/taglibs.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="fm">
    用户名<input type="text" name="userName"><br>
    密码<input type="password" name="password"><br>
    <input type="button" onclick="on()" value="登录">
    <a href="${ctx}/u/toAdd">没有账号？点击注册</a>
</form>
</body>
<script>
    function on() {
        $.post("${ctx}/u/login",
            $("#fm").serialize(),
            function (result) {
                if(result.code != 200){
                    layer.alert(result.msg, {
                        icon: 2,
                        skin: 'layui-layer-lan'
                    })
                    return;
                }
                location.href="${ctx}/index/toIndex";
        });
    }
</script>
</html>
