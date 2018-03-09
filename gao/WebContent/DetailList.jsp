<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>詳細</title>
<link rel="STYLESHEET" href="main.css" type="text/css">
</head>
<body>

	<h1>現場詳細</h1>
	<hr />
	<br />

	<div align="center">
		<table border="0" class="list">
			<tr>
				<th>お客様名</th>
				<th>担当者</th>
				<th>期限</th>
				<th>完了</th>
			</tr>
			<tr>
				<td><%=request.getAttribute("siteName")%></td>
				<td><%=request.getAttribute("responsible")%></td>
				<td><%=request.getAttribute("deadLine")%></td>
				<td><%=request.getAttribute("compDate")%></td>

			</tr>
		</table >
		//カレンダーテスト
		<%
			Calendar cal1 = Calendar.getInstance();
			cal1.set(2017, 3, 9);
			Calendar cal2 = Calendar.getInstance();
			cal2.set(2017, 3, 20);
			Calendar cal3 = Calendar.getInstance();
			cal3.set(2017, 3, 10);
			Calendar cal4 = Calendar.getInstance();
			cal4.set(2017, 3, 15);
		%>
		<table border="0" class="list">
		<tr>
			<%
				do {
			%>
				<td><%=cal1.get(Calendar.MONTH)%>/<%=cal1.get(Calendar.DATE)%></td>
			<%
				cal1.add(Calendar.DATE, 1);
				} while (cal1.before(cal2));
			%>
			</tr>
			<tr>
				<%
					cal1.set(2017, 3, 9);
					do {
						if (cal1.before(cal3)) {
				%>
				<td></td>
				<%
					} else {
							if (cal1.before(cal4)) {
				%>
				<td>■</td>
				<%
					} else {
				%>
				<td></td>
				<%
					}
						}
						cal1.add(Calendar.DATE, 1);
					} while (cal1.before(cal2));
				%>
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<form action="Update.jsp">
						<input type="submit" value="詳細更新">
					</form>
				</td>
				<td>
					<form action="Delete.jsp">
						<input type="submit" value="削除">
					</form>
				</td>
				<td>
					<form action="List.jsp">
						<input type="submit" value="戻る">
					</form>
				</td>
			</tr>

		</table>
	</div>

</body>
</html>