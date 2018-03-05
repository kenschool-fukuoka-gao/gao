<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>検索</title>
<link rel="STYLESHEET" href="login.css" type="text/css">
</head>
<body>
<h1>検索結果</h1>
	</br>
	</br>

		<table border="0" class="list">
			<tr>
				<th>お客様名</th>
				<th>担当者</th>
				<th>期限</th>
				<th>完了</th>
				<form action="DetailList.jsp">
					<td align="center" rowspan="2"><input type="submit" value="詳細"></td>
				</form>
			</tr>
			<tr>
				<td>AAA.puroject</td>
				<td>×××</td>
				<td>YYYY/MM/DD</td>
				<td>未 or YYYY/MM/DD</td>

			</tr>
		</table>
		<table border="0">
			<tr>
				<form action="List.jsp">
					<td><input type="submit" value="戻る"></td>
				</form>
			</tr>
		</table>

</body>
</html>