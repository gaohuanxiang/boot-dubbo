<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2022/8/4
  Time: 14:49
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
    昵称<input type="text" name="nickName"><br>
    <input type="button" onclick="on()" value="注册">
</form>
</body>
<script>
    function on() {
        $.post("${ctx}/u/add",
            $("#fm").serialize(),
            function (result) {
                if(result.code != 200){
                    layer.alert(result.msg, {
                        icon: 2,
                        skin: 'layui-layer-lan'
                    })
                    return;
                }
                location.href="${ctx}/u/toLogin";
            });
    }
</script>
</html>
