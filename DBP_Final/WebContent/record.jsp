<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="magicalGirl.magicalGirl" %>
<%@page import="magicalGirl.magicalGirlDAO" %>
<%@page import="Connect.Connect" %>
<%@page import="Connect.ConnectDAO" %>
<%@page import="Doppel.Doppel" %>
<%@page import="Doppel.DoppelDAO" %>
<%@page import="Magia.Magia" %>
<%@page import="Magia.MagiaDAO" %>
<%int id;
String card,name,rarity,attribute,connect,magia,doppel,pic;%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>魔法少女詳細</title>
</head>
<body>

<form action="Controller" method="post">
<p><a href=recordListTop.jsp>TOP</a></p>
<%

List<magicalGirl> list = (List<magicalGirl>)request.getAttribute("magicalGirlList");
Magia getMagia = (Magia)request.getAttribute("mdao");

Connect getConnect =(Connect)request.getAttribute("cdao");
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
out.print("能力表");

String table1 = "<table border=3><tr><td>コネクト</td><td>能力</td></tr>";
table1+="<tr><td>"+getConnect.getName()+"</td><td>"+getConnect.getDiscription()+"</td></tr>"
        +"<tr><td>マギア</td><td>能力</td><tr>"
        +"<tr><td>"+getMagia.getName()+"</td><td>"+getMagia.getDiscription()+"</td></tr>"
        +"<tr><td>ドッペル</td><td>能力</td><tr>";
        
        if(request.getAttribute("ddao")!=null){
        	Doppel getDoppel =(Doppel)request.getAttribute("ddao");
        table1+="<tr><td>"+getDoppel.getName()+"</td><td>"+getDoppel.getDiscription()+"</td></tr>"
                +"</table>";
        }else{
        	table1+="<tr><td>未実装</td><td>未実装</td></tr></table>";
        	
        }
        
     out.print(table1);
%>
</form>
</body>
</html>