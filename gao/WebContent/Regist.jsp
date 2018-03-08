<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登録</title>
<link rel="STYLESHEET" href="main.css" type="text/css">
</head>
<body>
<%

%>
<h1>作業登録</h1>
	<hr>
		<div align="center">
			<table border="0">
				<form action="./RegistService" method="post">
					<tr>
						<th>現場名</th>
						<td><input type="text" name="siteName" value="" size="24"></td>
					</tr>
					<tr>
						<th>担当者</th>
						<td><input type="text" name="responsible" value="" size="24"></td>
					</tr>
				<tr>
					<th>作業者名</th>
					<td><input type="text" name="worker" value="" placeholder="作業者名" size="12">
					    <input type="text" name="name" value="" placeholder="作業者名" size="12">
					    <input type="text" name="name" value="" placeholder="作業者名" size="12">
					    <input type="text" name="name" value="" placeholder="作業者名" size="12">
					    <input type="text" name="name" value="" placeholder="作業者名" size="12">
					    <input type="text" name="name" value="" placeholder="作業者名" size="12">
					    </td>
				</tr>
				<tr>
					<th>期限</th>
					<td>
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>
				<tr>
					<th>作業日程</th>
					<td><input type="text" name="processName" value="" placeholder="工程名">
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" value="" placeholder="工程名">
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" value="" placeholder="工程名">
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" value="" placeholder="工程名">
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" value="" placeholder="工程名">
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" value="" placeholder="工程名">
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="year">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="month">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="day">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>


			</table>

			<table border="0">
				<tr>
					<td><input type="submit" value="登録"></td>
					</form>
					<form action="List.jsp">
						<td><input type="submit" value="キャンセル"></td>
				</tr>
			</table>
			</td>
			</tr>
			</form>
		</div>
</body>
</html>