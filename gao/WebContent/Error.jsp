<!--
	@author 幸田

    @version 1.0
 -->
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>エラー</title>
<link rel="STYLESHEET" href="main.css" type="text/css">
</head>
<body>
<h1>エラー</h1>
<hr>
	<div align="center">
		<table border="0">
			<form action="Login.jsp" method="get">
				<tr>
					<td class="add_field">エラーが発生しました。<br/>
					</td>
				</tr>
				<tr>
					<td class="add_button" >
						<a href="./LogoutService"><input type="submit" value="ログイン画面へ戻る" style="width:100%;" /></a>
					</td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>