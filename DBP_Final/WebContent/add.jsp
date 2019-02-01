<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>データ追加</title>
</head>
<body>
<form action="Controller" method="post">
<p><a href=recordListTop.jsp>TOP</a></p>
<p>
<input type="radio" name="d" value="Connect"/>コネクト
<input type="radio" name="d" value="Magia"/>マギア
<input type="radio" name="d" value="Doppel" checked/>ドッペル

</p>
<p>
名前
<input type="text" name="a"/>
</p>
<p>
説明
<input type="text" name="b"/>
</p>
<p>
使用者
<input type="text" name="c"/>
</p>
<button type="submit" name="check" value="abc">登録</button>
</form>
</body>
</html>