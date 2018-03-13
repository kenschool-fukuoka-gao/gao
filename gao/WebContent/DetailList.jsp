<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="model.ProcessBean"%>
<%@page import="model.SiteBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>詳細</title>
<link rel="STYLESHEET" href="main.css" type="text/css">
</head>
<body>
<%
// siteId取得
	String siteId = request.getParameter("siteId");
%>
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
				<%
			if(request.getAttribute("compDate") != null){
%>
				<td><%= request.getAttribute("compDate") %></td>
<%
			}else{
%>
				<td><%= "未完了" %></td>
<%
			}
%>
			<tr>
				<th colspan="4">メンバー</th>
			</tr>
			<tr>
				<td colspan="4"><%= request.getAttribute("worker") %></td>

			</tr>
		</table>
		<%
			ArrayList<ProcessBean> list = (ArrayList<ProcessBean>) request.getAttribute("List");
			ArrayList<Calendar> cal_startDay = new ArrayList<Calendar>();
			ArrayList<Calendar> cal_endDay = new ArrayList<Calendar>();
			ArrayList<String> processNameLlist = new ArrayList<String>();
			Calendar cal_start_top = Calendar.getInstance();
			Calendar cal_end_top = Calendar.getInstance();
			for (int i = 0; i < list.size(); i++) {
				ProcessBean processBean = list.get(i);
				String name = processBean.getProcessName();
				processNameLlist.add(name);
				String[] startDay = (processBean.getStartDate()).split("-", 0);
				String[] endDay = (processBean.getEndDate()).split("-", 0);
				Calendar cal_start = Calendar.getInstance();
				cal_start.set(Integer.parseInt(startDay[0]), Integer.parseInt(startDay[1]),Integer.parseInt(startDay[2]));
				cal_startDay.add(cal_start);
				%>
				<%
				Calendar cal_end = Calendar.getInstance();
				cal_end.set(Integer.parseInt(endDay[0]), Integer.parseInt(endDay[1]), Integer.parseInt(endDay[2]));
				cal_endDay.add(cal_end);
				%>
				<%
			}
			int ys = cal_startDay.get(0).get(Calendar.YEAR);
			int ms = cal_startDay.get(0).get(Calendar.MONTH);
			int ds = cal_startDay.get(0).get(Calendar.DATE);
			cal_start_top.set(ys, ms, ds);
			for (int i = 0; i < cal_startDay.size(); i++) {
				if (cal_startDay.get(i).before(cal_start_top)) {
					cal_start_top.clear();
					int y = cal_startDay.get(i).get(Calendar.YEAR);
					int m = cal_startDay.get(i).get(Calendar.MONTH);
					int d = cal_startDay.get(i).get(Calendar.DATE);
					cal_start_top.set(y, m, d);
				}
			}
			%>
			<%
			int ye = cal_endDay.get(0).get(Calendar.YEAR);
			int me = cal_endDay.get(0).get(Calendar.MONTH);
			int de = cal_endDay.get(0).get(Calendar.DATE);
			cal_end_top.set(ye, me, de);
			for (int i = 0; i < cal_endDay.size(); i++) {
				if (cal_endDay.get(i).after(cal_end_top)) {
					cal_end_top.clear();
					int y = cal_endDay.get(i).get(Calendar.YEAR);
					int m = cal_endDay.get(i).get(Calendar.MONTH);
					int d = cal_endDay.get(i).get(Calendar.DATE);
					cal_end_top.set(y, m, d);
				}
			}
			cal_end_top.add(Calendar.DATE, 1);
			int y = cal_start_top.get(Calendar.YEAR);
			int m = cal_start_top.get(Calendar.MONTH);
			int d = cal_start_top.get(Calendar.DATE);
			%>
		<table border="0" class="list">
			<tr>
				<td>日程</td>
				<%

					do {
				%>
				<td><%=cal_start_top.get(Calendar.MONTH)%>/<%=cal_start_top.get(Calendar.DATE)%></td>
				<%
					cal_start_top.add(Calendar.DATE, 1);
					} while (cal_start_top.before(cal_end_top));
				%>
			</tr>
				<%

				for (int i = 0; i < cal_startDay.size(); i++) {
					cal_endDay.get(i).add(Calendar.DATE, 1);

					%>
					<tr>
					<td><%=processNameLlist.get(i)%></td>
					<%
					cal_start_top.set(y, m, d);
				do{
					if(cal_start_top.before(cal_startDay.get(i))){
						%>
						<td></td>
						<%
					} else {
					if(cal_start_top.before(cal_endDay.get(i))){
						%>
						<td>■</td>
						<%
					}else{
						%>
						<td></td>
						<%
					}
					}
				cal_start_top.add(Calendar.DATE, 1);
				} while (cal_start_top.before(cal_end_top));
				}
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
					<form action="Delete.jsp?siteId=<%= siteId %>" method="post">
						<input type="submit" value="削除" />
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
