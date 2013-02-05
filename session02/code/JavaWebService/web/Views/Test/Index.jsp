<%-- 
    Document   : Index
    Created on : Feb 1, 2013, 2:28:49 PM
    Author     : TroelsLiebeBentsen
--%>
<%@ page import="Models.TestModel" %>
<%
  TestModel model = (TestModel) request.getAttribute("model");
 %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= model.title %></title>
    </head>
    <body>
        <h1><%= model.stuff %></h1>
    </body>
</html>
