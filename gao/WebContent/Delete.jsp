<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SiteBean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>削除</title>
<link rel="STYLESHEET" href="main.css" type="text/css">
</head>
<body>
<h1>削除確認</h1>
        <hr>
        <div align="center">
            <table border="0">
                <form action="./DeleteService" method="post">
                	<input type="hidden" name="action" value="delete" />

                    <tr>
                        <td class="add_field">
                            削除します。<br/>
                            よろしいですか？
                        </td>
	            </tr>
                    <tr>
                        <td class="add_button">
                            <table border="0">
                                <tr>
                                    <td>
                                        <input type="submit" value="削除" />
                                    </td>
                                    </form>
                                    <form action="DetailList.jsp" method="post">
                                    <td>
                                        <input type="submit" value="キャンセル" />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </form>
            </table>
         </div>

</body>
</html>