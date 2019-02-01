<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="magicalGirl.magicalGirl" %>
<%@page import="magicalGirl.magicalGirlDAO" %>

<%int id;
String card,name,rarity,attribute,connect,magia,doppel,pic;%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有魔法少女一覧</title>

</head>
<body>

<form action="Controller" method="post">
<p><a href=recordListTop.jsp>TOP</a></p>
<%

List<magicalGirl> list = (List<magicalGirl>)request.getAttribute("list");



out.print("魔法少女");
String table = "<table border=3><tr><td>ID</td><td>画像</td><td>名前</td><td>レアリティ</td><td>属性</td><td>コネクト</td><td>マギア</td><td>ドッペル</td></tr>";
for(magicalGirl m:list){
	id = m.getID();
	card = m.getCard();
	name = m.getName();
	rarity = m.getRarity();
	attribute = m.getAttribute();
	connect = m.getConnect();
	magia = m.getMagia();
	doppel = m.getDoppel();
	pic="<img src ="+"./データベース/魔法少女/"+card+" "+"width="+"130"+" "+"height="+"200"+ ">";
	
     table +="<tr><td>"
    		 +id+"</a></td><td>"
    		 +pic+"</td><td>"
    		 +name+"</td><td>"
    		 +rarity+"</td><td>"
    		 +attribute+"</td><td>"
    		 +connect+"</td><td>"
    		 +magia+"</td><td>"
    		 +doppel+"</td><td>";
}
table+="</table>";
out.print(table);

%>
</form>
</body>
</html>