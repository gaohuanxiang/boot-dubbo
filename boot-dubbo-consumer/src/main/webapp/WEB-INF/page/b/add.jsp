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
    <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/res/my97/My97DatePicker/WdatePicker.js"></script>
    <title>Title</title>
</head>
<body>
<form id="fm">
    书名<input type="text" name="bookName"><br>
    图书价格<input type="text" name="bookPrice"><br>
    发行日期
    <input type="text" name="releaseTime" onclick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd',skin:'YcloudRed',alwaysUseStartDate:true})"><br>
    <input type="button" onclick="on()" value="注册">
</form>
</body>
<script>
    function on() {
        $.post("${ctx}/b/add",
            $("#fm").serialize(),
            function (result) {
                if(result.code != 200){
                    layer.alert(result.msg, {
                        icon: 2,
                        skin: 'layui-layer-lan'
                    })
                    return;
                }
                layer.msg("添加成功,即将加载到首页",
                    {time:1500},
                    function(){
                        parent.location.href="${ctx}/index/toIndex";
                    })
            });
    }
</script>
</html>
