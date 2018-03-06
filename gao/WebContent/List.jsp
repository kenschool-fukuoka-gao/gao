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
<title>一覧</title>
<link rel="STYLESHEET" href="main.css" type="text/css">
</head>
<body>
<%
        // データベースへのアクセス開始
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        //GregorianCalendar cal = new GregorianCalendar();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //String datestr = format.format(cal.getTime());
        try {
            // JDBCドライバをロード
            Class.forName("com.mysql.jdbc.Driver");
            // データベースに接続するConnectionオブジェクトの取得
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sample",
                "root", "root");
            // データベース操作を行うためのStatementオブジェクトの取得
            stmt = con.createStatement();
            // SQL()を実行して、結果を得る
            rs = stmt.executeQuery(
              "select siteName, responsible, deadLine, compDate from indexps join site using (siteId)");
            HttpSession hsession = request.getSession();
            String employeeName = (String) session.getAttribute("employeeName");
%>
<h1>現場一覧</h1>
	<hr>
		<div align="right">ようこそ <%= employeeName %> さん</div>
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
					<th>現場名</th>
					<th>担当者</th>
					<th>期限</th>
					<th>完了</th>
					<form action="DetailList.jsp">
				</tr>
<%
				// 得られた結果をレコードごとに表示
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

						<td><input type="submit" value="詳細"></td>
				</tr>
<%
            }

        } catch (Exception e) {
            e.printStackTrace();
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