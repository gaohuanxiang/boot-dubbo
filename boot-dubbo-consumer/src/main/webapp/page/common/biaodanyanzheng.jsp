<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2022/7/5
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/page/common/taglibs.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/res/validation/jquery.validate.js"></script>
    <script type="text/javascript" src="${ctx}/res/validation/messages_zh.js"></script>
</head>
<body>
    <form id="fr">
        <div>
        用户名: <input type="text" name="userName" ><br>
        密码: <input type="password" name="userPwd" id="userPwd" ><br>
        确认密码: <input type="password" name="userPwd1"><br>
        性别:
            <input type="radio" name="userSex" value="男" >
            <input type="radio" name="userSex" value="女"><br>
        爱好<select name="hobby" id="hobby">
                <option value="">请选择</option>
                <option value="篮球">篮球</option>
                <option value="足球">足球</option>
                <option value="排球">排球</option>
            </select><br>
        年龄: <input type="number" name="userAge"><br>
       手机号: <input type="number" name="phone"><br>
        邮箱:<input type="text" name="email">
        <button onclick="on()">提交</button>
        </div>
    </form>
</body>
<script type="text/javascript">
    function on(){
        var flag = $("#fr").valid(); // 获取valdata的值
        if (!flag) {
            return;
        }
    }
    $(function() {
        check();
    });

    function check() {
        $("#fr").validate({
            // rules 是给自己的name 定义自己的规则
            rules: {
                userName: {
                    required: true,
                    minlength: 2,  //设置最小长度。
                    maxlength: 11 //设置最大长度
                },
                userPwd: {
                    required: true,
                    rangelength:[3, 11]
                },
                userPwd1: {
                    required: true,
                    rangelength:[3, 11],
                    equalTo: "#userPwd"
                },
                userSex: {
                    required: true,
                },
                hobby: {
                    required: true,
                },
                userAge: {
                    required: true,
                    max:99 //设置最大长度
                },
                phone: {
                    required: true,
                    minlength: 11,
                    maxlength: 11 //设置最大长度
                },
                email: {
                    required: true,
                    email:true
                },

            },
            // messages 是给自己定义的规则 加上提示
            messages: {
                // errorPlacement 是给自己定义的错误提示位置
                errorPlacement: function (error, element) { //指定错误信息位置
                    if (element.is(':radio') || element.is(':checkbox')) { //如果是radio或checkbox
                        var eid = element.attr('rank'); //获取元素的name属性
                        error.appendTo(element.parent()); //将错误信息添加当前元素的父结点后面
                    } else {
                        error.insertAfter(element);
                    }
                }
            }
        });
    }
</script>
<style>
    .error{
        color:red;
    }
</style>
</html>
