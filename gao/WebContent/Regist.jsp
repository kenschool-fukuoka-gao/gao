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
<h1>作業登録</h1>
	<hr>
		<div align="center">
			<table border="0">
				<form action="./RegistService" method="post">
					<tr>
						<th>現場名</th>
						<td><input type="text" name="siteName" size="24"></td>
					</tr>
					<tr>
						<th>担当者</th>
						<td><input type="text" name="responsible" size="24"></td>
					</tr>
				<tr>
					<th>作業者名</th>
					<td><input type="text" name="worker1" placeholder="作業者名" size="12">
					    <input type="text" name="worker2" value="" placeholder="作業者名" size="12">
					    <input type="text" name="worker3" value="" placeholder="作業者名" size="12">
					    <input type="text" name="worker4" value="" placeholder="作業者名" size="12">
					    <input type="text" name="worker5" value="" placeholder="作業者名" size="12">
					    <input type="text" name="worker6" value="" placeholder="作業者名" size="12">
					    </td>
				</tr>
				<tr>
					<th>期限</th>
					<td>
					<select name="deadLineYear">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="deadLineMonth">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="deadLineDay">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>
				<tr>
					<th>作業日程</th>
					<td><input type="text" name="processName1" placeholder="工程名">
					<select name="startDateYear1">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="startDateMonth1">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="startDateDay1">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="endDateYear1">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="endDateMonth1">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="endDateDay1">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>
				<tr>
					<th>作業日程</th>
					<td><input type="text" name="processName2" placeholder="工程名">
					<select name="startDateYear2">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="startDateMonth2">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="startDateDay2">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="endDateYear2">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="endDateMonth2">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="endDateDay2">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr><tr>
					<th>作業日程</th>
					<td><input type="text" name="processName3" placeholder="工程名">
					<select name="startDateYear3">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="startDateMonth3">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="startDateDay3">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="endDateYear3">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="endDateMonth3">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="endDateDay3">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr><tr>
					<th>作業日程</th>
					<td><input type="text" name="processName4" placeholder="工程名">
					<select name="startDateYear4">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="startDateMonth4">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="startDateDay4">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="endDateYear4">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="endDateMonth4">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="endDateDay4">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr><tr>
					<th>作業日程</th>
					<td><input type="text" name="processName5" placeholder="工程名">
					<select name="startDateYear5">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="startDateMonth5">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="startDateDay5">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="endDateYear5">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="endDateMonth5">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="endDateDay5">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr><tr>
					<th>作業日程</th>
					<td><input type="text" name="processName6" placeholder="工程名">
					<select name="startDateYear6">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="startDateMonth6">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="startDateDay6">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>～
					<select name="endDateYear6">
							<% for(int i = 2018; i <= 2050; i++){%>
								<option value="<%= i %>" ><%= i %></option>
							<%} %>
						</select>/
					<select name="endDateMonth6">
						<% for(int i = 1; i <= 12; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>/
					<select name="endDateDay6">
						<% for(int i = 1; i <= 31; i++){ %>
							<option value="<%= i %>" ><%= i %></option>
						<%} %>
					</select>
					</td>
				</tr>
			</table>
			<table border="0">
				<tr>
					<td><input type="submit" value="登録" method="post"></td>
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