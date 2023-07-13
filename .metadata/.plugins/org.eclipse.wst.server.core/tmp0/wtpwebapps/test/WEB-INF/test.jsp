<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-3.7.0.min.js"></script>
<script src="js/jquery.qrcode.min.js"></script>
<script type="text/JavaScript">
$(function(){
	var qrtext = "url";
	//var utf8qrtext = decodeURI(qrtext);
	$("#img-qr").html("");
	$("#img-qr").qrcode({text:qrtext})
})
</script>
<meta charset="UTF-8">
<title>テスト</title>
</head>
<body>
<div id = "img-qr"></div>
</body>
</html>