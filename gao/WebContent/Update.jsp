<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>詳細更新</title>
<link rel="STYLESHEET" href="main.css" type="text/css">
</head>
<body>
<% String siteId = request.getParameter("siteId"); %>
<%
	int length = 6;
	int count = 0;
	// データベースへのアクセス開始
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		// JDBCドライバをロード
		Class.forName("com.mysql.jdbc.Driver");
		// データベースに接続するConnectionオブジェクトの取得
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root");
		// データベース操作を行うためのStatementオブジェクトの取得
		stmt = con.createStatement();
		// SQL()を実行して、結果を得る
		rs = stmt.executeQuery("select * from site");
%>
<h1>詳細更新</h1>
<hr>
	<div align="center">
	<%// 得られた結果をレコードごとに表示
	while (rs.next()) {
		if(siteId.equals(rs.getString("siteId"))){
		String hoge = rs.getString("worker");
		String[] worker = hoge.split(" ",0);
		String hoge2 = rs.getString("deadLine");
		String[] deadLine = hoge2.split("-",0);%>
		<table border="0">
			<form action="./RegistService" method="post">
				<tr>
					<th>現場名</th>
					<td><input type="text" name="siteName" value="<%= rs.getString("siteName")%>" size="24"></td>
				</tr>
				<tr>
					<th>担当者</th>
					<td><input type="text" name="responsible" value="<%= rs.getString("responsible")%>" size="24"></td>
				</tr>
				<tr>
					<th>作業者名</th>
					<td>
					<% for (int i = 0 ; i < worker.length ; i++){ %>
					<input type="text" name="worker<%= i+1%>" value="<%= worker[i]%>" placeholder="作業者名" size="12">
				    <% count++;
				    }
					for(int i= count+1;length - count > 0;i++){
				length--;%>
					<input type="text" name="worker<%= i%>" value="" placeholder="作業者名" size="12">
				<%} %>
				    </td>
				</tr>
				<tr>
					<th>期限</th>
					<td>
						<input type="text" name="deadLineYear" value="<%= deadLine[0]%>" size="2">/
						<input type="text" name="deadLineMonth" value="<%= deadLine[1]%>" size="1">/
						<input type="text" name="deadLineDay" value="<%= deadLine[2]%>" size="1">
					</td>
				</tr>

				<% }}
	rs.close();
	rs = stmt.executeQuery("select * from process LEFT OUTER JOIN site_pro USING (processId) LEFT OUTER JOIN site USING (siteId)");
	length = 6;
	count = 0;
		// 得られた結果をレコードごとに表示
		while (rs.next()) {
			if(siteId.equals(rs.getString("siteId"))){
		String hoge3 = rs.getString("startDate");
		String[] startDate = hoge3.split("-",0);
		String hoge4 = rs.getString("endDate");
		String[] endDate = hoge4.split("-",0);%>
				<tr>
					<th>作業日程</th>
					<td><input type="text" name="processName<%= count+1%>" value="<%= rs.getString("processName")%>" placeholder="工程名">
						<input type="text" name="startDateYear<%= count+1%>" value="<%= startDate[0]%>" size="2">/
						<input type="text" name="startDateMonth<%= count+1%>" value="<%= startDate[1]%>" size="1">/
						<input type="text" name="startDateDay<%= count+1%>" value="<%= startDate[2]%>" size="1">
						～
						<input type="text" name="endDateYear<%= count+1%>" value="<%= endDate[0]%>" size="2">/
						<input type="text" name="endDateMonth<%= count+1%>" value="<%= endDate[1]%>" size="1">/
						<input type="text" name="endDateDay<%= count+1%>" value="<%= endDate[2]%>" size="1">
					</td>
				</tr>
				<%count++;}}
		for(int i= count+1;length - count > 0;i++){
				length--;%>
				<tr>
					<th>作業日程</th>
						<td><input type="text" name="processName<%= i%>" value="" placeholder="工程名">
							<input type="text" name="startDateYear<%= i%>" value="2018" size="2">/
							<input type="text" name="startDateMonth<%= i%>" value="01" size="1">/
							<input type="text" name="startDateDay<%= i%>" value="01" size="1">
						～
							<input type="text" name="endDateYear<%= i%>" value="2018" size="2">/
							<input type="text" name="endDateMonth<%= i%>" value="01" size="1">/
							<input type="text" name="endDateDay<%= i%>" value="01" size="1">
						</td>
					</tr>
				<%} %>
				<tr>
					<th class="add_field">完了</th>
					<td class="add_field"><input type="checkbox" name="check" value="1" size="8">完了した </td>
				</tr>
					<td colspan="2" class="add_button">
						<table border="0" align="center">
							<tr>
								<td><input type="submit" value="更新"></td>
			</form>
			<form action="List.jsp">
								<td><input type="submit" value="キャンセル"></td>
							</tr>
						</table>
					</td>
				</tr>
			</form>
		</table>
	</div>
		<%
	}catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect("./Error.jsp");
	}finally {
		// データベースとの接続をクローズ
		try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
            try { con.close(); } catch (Exception e) {}
        }
%>
</body>
</html>