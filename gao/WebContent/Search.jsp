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
<title>検索</title>
<link rel="STYLESHEET" href="main.css" type="text/css">
</head>
<body>
<h1>検索結果</h1>
</br>
</br>
<%
	//画面から検索条件タイトルの取得
	String keyword = request.getParameter("keyword");
	// データベースへのアクセス開始
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
%>
	<div>
		<table border="0" class="list">
			<tr>
				<th>現場名</th>
				<th>担当者</th>
				<th>期限</th>
				<th>完了</th>
			</tr>
<%
		// JDBCドライバをロード
		Class.forName("com.mysql.jdbc.Driver");
		// データベースに接続するConnectionオブジェクトの取得
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root");
		// データベース操作を行うためのStatementオブジェクトの取得
		stmt = con.createStatement();
		// SQL()を実行して、結果を得る
		rs = stmt.executeQuery("SELECT * FROM site WHERE siteName LIKE '%"+keyword+"%' OR responsible LIKE '%"+keyword+"%'");
		// 得られた結果をレコードごとに表示
		if(keyword != ""){
			while (rs.next()) {
%>
			<tr>
				<%-- indexpsの現場名を表示 --%>
				<td><%= rs.getString("siteName")%></td>
				<%-- indexpsの担当者を表示 --%>
				<td><%= rs.getString("responsible")%></td>
				<%-- indexpsの期限を表示 --%>
				<td><%= rs.getString("deadLine")%></td>
				<%-- 完了日を表示 --%>
<%
				if(rs.getString("compDate") != null){
%>
					<td><%= rs.getString("compDate") %></td>
<%
				}else{
%>
					<td><%= "未完了" %></td>
<%
				}
%>
				<td><a href="./DetailListService?siteId=<%= rs.getString("siteId")%>"><input type="submit" value="詳細" name="change"></a></td>
			</tr>
<%
			}
		}
%>
		<table border="0">
			<tr>
				<form action="List.jsp">
					<td><input type="submit" value="戻る"></td>
				</form>
			</tr>
		</table>
<%
	} catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect("/Error.jsp");
	} finally {
		// データベースとの接続をクローズ
		try { rs.close(); } catch (Exception e) {}
		try { stmt.close(); } catch (Exception e) {}
		try { con.close(); } catch (Exception e) {}
	}
%>
		</table>
	</div>
</body>
</html>