<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ログイン</title>
<link rel="STYLESHEET" href="main.css" type="text/css">
</head>
<body>
<form method="post" action="./LoginService" name="Login">
	<fieldset>
	<h1>Login</h1>
	<form>
		<div class="iconUser"></div>
		<input type="text" placeholder="UserID" name="UserID" required>
		<div class="iconPassword"></div>
		<input type="password" placeholder="Password" name="Password" required>
		<input type="submit" name="login" value="Enter">
    </fieldset>
	</form>
</body>
</html>