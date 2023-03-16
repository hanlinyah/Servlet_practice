<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>index_jsp</title>
</head>
<body>
<h2>Servlet 測試主頁</h2>
<a href="./demo01">servlet註解(urlPatterns)測試</a><br>
<a href="./webdemo01">servlet透過web.xml配置映射文件測試</a><br>
<span>http請求測試-GET</span>
<form action="./demo02" method="get">
    用戶名稱<input type="text" name="username">
    密碼<input type="password" name="password">
    <input type="submit">
</form>
<span>http請求測試-POST</span>
<form action="./demo02" method="post">
    用戶名稱<input type="text" name="username">
    密碼<input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>
