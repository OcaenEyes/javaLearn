<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: YSilhouette
  Date: 2019/12/31
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<jsp:useBean id="regUser" class="entity.Users" scope="session"></jsp:useBean>
<table>
    <tr>
        <td><jsp:getProperty name="regUser" property="username"></jsp:getProperty></td>
    </tr>
    <tr>
        <td><jsp:getProperty name="regUser" property="password"></jsp:getProperty></td>
    </tr>
    <tr>
        <td><jsp:getProperty name="regUser" property="eamil"></jsp:getProperty></td>
    </tr>
    <tr>
        <td><jsp:getProperty name="regUser" property="gender"></jsp:getProperty></td>
    </tr>
    <tr>
        <td>
            <%
                SimpleDateFormat sdf = new SimpleDateFormat();
                String date = sdf.format(regUser.getBirthday());
            %>
            <%=date%>
        </td>
    </tr>
    <tr>
        <td>
            <%
                String[] favorites = regUser.getFavorite();
                for (String f:favorites){
            %>
                <%=f%>;
            <%
                }
            %>
        </td>
    </tr>
    <tr>
        <td><jsp:getProperty name="regUser" property="introduce"></jsp:getProperty></td>
    </tr>
    <tr>
        <td><jsp:getProperty name="regUser" property="accept"></jsp:getProperty></td>
    </tr>
</table>
</body>
</html>
