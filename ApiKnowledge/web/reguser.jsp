<%--
  Created by IntelliJ IDEA.
  User: YSilhouette
  Date: 2019/12/31
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>注册</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        .label{
            width: 20%
        }
        .controler{
            width: 80%
        }
    </style>
    <script type="text/javascript" src="js/Calendar3.js"></script>
</head>

<body>
<h1>用户注册</h1>
<hr>
<form name="regForm" action="/reguser" method="post" >
    <table border="0" width="800" cellspacing="0" cellpadding="0">
        <tr>
            <td class="lalel">用户名：</td>
            <td class="controler"><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td class="label">密码：</td>
            <td class="controler"><input type="password" name="password" ></td>

        </tr>
        <tr>
            <td class="label">确认密码：</td>
            <td class="controler"><input type="password" name="confirmpass" ></td>

        </tr>
        <tr>
            <td class="label">电子邮箱：</td>
            <td class="controler"><input type="text" name="email" ></td>

        </tr>
        <tr>
            <td class="label">性别：</td>
            <td class="controler"><input type="radio" name="gender" checked="checked" value="Male">男<input type="radio" name="gender" value="Female">女</td>

        </tr>

        <tr>
            <td class="label">出生日期：</td>
            <td class="controler">
                <input name="birthday" type="text" id="control_date" size="10"
                       maxlength="10" onclick="class Calendar{
} new Calendar().show(this);"/>
            </td>
        </tr>
        <tr>
            <td class="label">爱好：</td>
            <td class="controler">
                <input type="checkbox" name="favorite" value="nba"> NBA &nbsp;
                <input type="checkbox" name="favorite" value="music"> 音乐 &nbsp;
                <input type="checkbox" name="favorite" value="movie"> 电影 &nbsp;
                <input type="checkbox" name="favorite" value="internet"> 上网 &nbsp;
            </td>
        </tr>
        <tr>
            <td class="label">自我介绍：</td>
            <td class="controler">
                <textarea name="introduce" rows="10" cols="40"></textarea>
            </td>
        </tr>
        <tr>
            <td class="label">接受协议：</td>
            <td class="controler">
                <input type="checkbox" name="accept" value="true">是否接受霸王条款
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册"/>&nbsp;&nbsp;
                <input type="reset" value="取消"/>&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>