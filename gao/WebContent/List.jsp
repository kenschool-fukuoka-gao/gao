<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>一覧</title>
<link rel="STYLESHEET" href="login.css" type="text/css">
</head>
<body>
<h1>現場一覧</h1>
	<hr>
		<div align="right">ようこそ ○○○ さん</div>
		<!-- 作業登録・検索 -->
		<table border="0" class="toolbar">
			<tr>
				<form action="Regist.jsp">
					<td><input type="submit" value="作業登録"></td>
				</form>
				<td align="right">
					<table border="0">
						<tr>
							<td>検索キーワード</td>
							<form action="Search.jsp">
								<td><input type="text" name="keyword" value="" size="24"></td>
								<td><input type="submit" value="検索"></td>
							</form>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<div>
			<table border="0" class="list">
				<tr>
					<th>お客様名</th>
					<th>担当者</th>
					<th>期限</th>
					<th>完了</th>
					<form action="DetailList.jsp">
						<td align="center" rowspan="2"><input type="submit"
							value="詳細"></td>
				</tr>
				<tr>
					<td>AAA.puroject</td>
					<td>×××</td>
					<td>YYYY/MM/DD</td>
					<td>未 or YYYY/MM/DD</td>
				</tr>
			</table>
		</div>

</body>
</html>