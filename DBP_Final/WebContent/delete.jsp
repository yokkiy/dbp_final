<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Connect.Connect" %>
<%@page import="Connect.ConnectDAO" %>
<%@page import="Doppel.Doppel" %>
<%@page import="Doppel.DoppelDAO" %>
<%@page import="Magia.Magia" %>
<%@page import="Magia.MagiaDAO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>データ削除</title>
</head>
<body>
<form action="Controller" method="post">
<p><a href=recordListTop.jsp>TOP</a></p>
<%
List<Connect>list1=(List<Connect>)request.getAttribute("list1");
List<Magia>list2=(List<Magia>)request.getAttribute("list2");
List<Doppel>list3=(List<Doppel>)request.getAttribute("list3");
out.println("<p>"+"コネクトリスト"+"</p>");
for(Connect c:list1){
	out.println("<input type="+"checkbox"+" name="+" aa"+" value="+c.getName()+">"+c.getName()+"<br>");
}
out.println("<p>"+"マギアリスト"+"</p>");
for(Magia c:list2){
	out.println("<input type="+"checkbox"+" name="+" bb"+" value="+c.getName()+">"+c.getName()+"<br>");
}
out.println("<p>"+"ドッペルリスト"+"</p>");
for(Doppel c:list3){
	out.println("<input type="+"checkbox"+" name="+" cc"+" value="+c.getName()+">"+c.getName()+"<br>");
}
%>


<button type="submit" name="check" value="del">削除</button>
</form>
</body>
</html>