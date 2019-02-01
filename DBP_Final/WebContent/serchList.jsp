<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import="magicalGirl.magicalGirl" %>
    <%@page import="magicalGirl.magicalGirlDAO" %>
    <%@page import="java.sql.*" %>
    <% List<magicalGirl>list = new ArrayList<>();
String select ="select * from magicalgirl";
String driverClassName = "org.postgresql.Driver";
String url = "jdbc:postgresql://localhost/test";
String user = "dbpuser";
String password = "hogehoge";
String sql ="select * from magical_girl";
Connection connection;
ResultSet resultSet;
PreparedStatement pps;
Statement statement;
magicalGirlDAO mgdao = new magicalGirlDAO();

int id;
String card,name,rarity,attribute,connect,magia,doppel,pic;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マギレコ一覧表Top</title>
</head>
<body>

<div>
<p><a href=recordListTop.jsp>TOP</a></p>
<p>魔法少女リスト</p>
<form action="Controller" method="post">

<p>
<input type="radio" name="rarity" value="☆"/>☆
<input type="radio" name="rarity" value="☆☆"/>☆☆
<input type="radio" name="rarity" value="☆☆☆" checked/>☆☆☆
<input type="radio" name="rarity" value="☆☆☆☆"/>☆☆☆☆
<input type="radio" name="rarity" value="☆☆☆☆☆"/>☆☆☆☆☆
<button type="submit" name="check" value="rarity">レア度検索</button>
</p>
<p>
<input type="radio" name="attribute" value="火" checked/>火
<input type="radio" name="attribute" value="水" />水
<input type="radio" name="attribute" value="木" />木
<input type="radio" name="attribute" value="光" />光
<input type="radio" name="attribute" value="闇" />闇
<input type="radio" name="attribute" value="無" />無
<button type="submit" name="check" value="attribute">属性検索</button>
<button type="submit" name="check" value="sinki">新規登録</button>
</p>
<p><input type="text" name="keyword" /><button type="submit" name="check" value="serch">キーワード検索</button></p>
<%
String table = "<table border=3><tr><td>ID</td><td>画像</td><td>名前</td><td>レアリティ</td><td>属性</td><td>コネクト</td><td>マギア</td><td>ドッペル</td></tr>";

try{

	list = (List)request.getAttribute("Afterlist");
	
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
		
         table +="<tr><td><a href=\"./Controller?check=girl&ID="+id+" \">"
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

}catch(Exception e){

}
%>
</form>
</div>
</body>
</html>