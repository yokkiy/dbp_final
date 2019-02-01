<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新魔法少女登録</title>
</head>
<body>

<p>
${requestScope.message}
</p>
<form action ="magicalGirlManager" method ="post">
<p><a href=recordListTop.jsp>TOP</a></p>
<p><a href=uploadPic.jsp>画像アップロード画面</a></p>
<p>
魔法少女名
<input type="text" name="name" />
</p>

<p>
画像アップロード
<input type="text" name="card"/>
</p>

<p>
<input type="radio" name="rarity" value="☆"/>☆
<input type="radio" name="rarity" value="☆☆"/>☆☆
<input type="radio" name="rarity" value="☆☆☆" checked/>☆☆☆
<input type="radio" name="rarity" value="☆☆☆☆"/>☆☆☆☆
<input type="radio" name="rarity" value="☆☆☆☆☆"/>☆☆☆☆☆
</p>

<p>
<input type="radio" name="attribute" value="火" checked/>火
<input type="radio" name="attribute" value="水" />水
<input type="radio" name="attribute" value="木" />木
<input type="radio" name="attribute" value="光" />光
<input type="radio" name="attribute" value="闇" />闇
<input type="radio" name="attribute" value="無" />無
</p>


<p>
コネクト
<input type="text" name="connect"/>
</p>


<p>
マギア
<input type="text" name="magia">
</p>


<p>
ドッペル
<input type="text" name="doppel"/>
</p>

<p>
<button type="submit" name="check" value="touroku">登録</button>
</p>

</form>

</body>
</html>