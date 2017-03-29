<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all.css"></link>
  <script type="text/javascript"  src="extjs/ext-all.js"></script>
  <script type="text/javascript" src="extjs/ext-lang-zh_CN.js"></script>
<title>管理员登出</title>
</head>
<body>
<%
  session.removeAttribute("adminid"); 
  response.sendRedirect("/");
%>
</body>
</html>