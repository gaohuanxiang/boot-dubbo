<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><a href="<%=request.getContextPath()%>/u/toShow" target="right">用户展示</a></h2>
	<h2><a href="<%=request.getContextPath()%>/b/toShow" target="right">展示图书</a></h2>
	<h2><a href="<%=request.getContextPath()%>/b/toAdd" target="right">新增图书</a></h2>
	<%--<h2><a href="<%=request.getContextPath()%>/s/toShow" target="right">商品展示</a></h2>--%>
</body>
</html>