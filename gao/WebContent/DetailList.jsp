<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>詳細</title>
<link rel="STYLESHEET" href="login.css" type="text/css">
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
			<td>AAA.puroject</td>
			<td>×××</td>
			<td>YYYY/MM/DD</td>
			<td>未 or YYYY/MM/DD</td>
		</tr>
		<tr>
			<th colspan="4">メンバー</th>
		</tr>
		<tr>
			<td colspan="4">○○　××.□□　△△.××　□□</td>
		</tr>

		<table class="chart">
		<tr><th colspan="25"text-align="left">詳細</th></tr>
		<tr><th>日付</th><th>3/10</th><th>3/11</th><th>3/12</th><th>3/13</th><th>3/14</th><th>3/15</th>
		   				 <th>3/16</th><th>3/17</th><th>3/18</th><th>3/19</th><th>3/20</th><th>3/21</th>
		   				 <th>3/22</th><th>3/23</th><th>3/24</th><th>3/25</th><th>3/26</th><th>3/27</th>
		   				 <th>3/28</th><th>3/29</th><th>3/30</th><th>3/31</th><th>4/01</th><th>4/02</th></tr>
		<tr><th>見積</th><td>■</td><td>■</td><td>■</td><td></td><td></td><td></td>
		    	         <td></td><td></td><td></td><td></td><td></td><td></td>
		    	         <td></td><td></td><td></td><td></td><td></td><td></td>
		   				 <td></td><td></td><td></td><td></td><td></td><td></td></tr>
		<tr><th>設計</th><td></td><td></td><td></td><td>■</td><td>■</td><td>■</td>
		    	         <td>■</td><td>■</td><td></td><td></td><td></td><td></td>
		    	         <td></td><td></td><td></td><td></td><td></td><td></td>
		   				 <td></td><td></td><td></td><td></td><td></td><td></td></tr>
		<tr><th>施工</th><td></td><td></td><td></td><td></td><td></td><td></td>
		    	         <td></td><td></td><td>■</td><td>■</td><td>■</td><td>■</td>
		    	         <td>■</td><td>■</td><td>■</td><td>■</td><td>■</td><td>■</td>
		   				 <td>■</td><td>■</td><td>■</td><td>■</td><td>■</td><td></td></tr>
		<tr><th>受け渡し</th><td></td><td></td><td></td><td></td><td></td><td></td>
		    	         <td></td><td></td><td></td><td></td><td></td><td></td>
		    	         <td></td><td></td><td></td><td></td><td></td><td></td>
		   				 <td></td><td></td><td></td><td></td><td></td><td>■</td></tr>
		</table>
	</table>
	<table>
		<tr>
			<td>
				<form action="Update.jsp">
					<input type="submit" value="詳細変更">
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