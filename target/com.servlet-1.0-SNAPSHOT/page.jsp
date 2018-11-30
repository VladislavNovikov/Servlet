<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.*"%>
<%@ page import="com.servlet.User" %>
<%@ page import="com.servlet.Info" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connection with DB</title>
</head>
<body>
<%User user = (User)request.getAttribute("user");
    String str1 = (user!=null)?user.toString():"";
%>
<%
    Integer sum = (Integer)request.getAttribute("sum");
    String str2 = (sum!=null)?Integer.toString(sum):"";
%>


<form method="det" action="/Servlet1">
    RichestUser <input value="<%out.print(str1);%>" type="text" name = "user" size="25">
    <input type="submit" value="Get">
</form>
<form method="get" action="/Servlet2">
    AccountsSum <input value="<%out.print(str2);%>" type="text" name = "sum">
    <input type="submit" value="Get">
</form>
</body>
</html>
