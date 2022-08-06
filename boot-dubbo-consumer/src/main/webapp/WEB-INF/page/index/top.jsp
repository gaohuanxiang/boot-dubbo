<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>i'm top page</title>

</head>
<body>
	<body style="background-color: ;">

	<center>
		<h1>👩‍💻欢迎 <font color="red">${user.userName}</font> 来到北京点金教育平台，万元高薪，尽在点金</h1>
		<marquee>🎇天气正好</marquee>
		<marquee>好好学习天天向上</marquee>
	</center>
	<div style="text-align: right; margin-top: 20px;margin-right: 20px;">

<h3><label id="time" style="color: #AC2925; "></label></h3>

</div>
<script>

function mytime(){

var a = new Date();

var b = a.toLocaleTimeString();

var c = a.toLocaleDateString();

document.getElementById("time").innerHTML = c+"&nbsp"+b;

}

setInterval(function() {mytime()},1000);

</script>
</body>

	
	
	
</body>

</html>
