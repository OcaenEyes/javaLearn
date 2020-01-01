<%--
  Created by IntelliJ IDEA.
  User: YSilhouette
  Date: 2020/1/1
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/login" method="post">
    <label>用户名</label>
    <input name="username" value=""/>
    <label>密码</label>
    <input name="password" value=""/>
    <br>
    <input type="submit" value="登录">
    <input type="reset" value="取消">
</form>

</body>
</html>
