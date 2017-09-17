<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>どこつぶ</title>
</head>
<body>
<c:choose>
<c:when test="${not empty loginUser}">
ログイン成功<br>
ようこそ<c:out value="${loginUser.name}"/>さん<br>
<a href="/docoTsubu/Main">つぶやき投稿・閲覧へ</a>
</c:when>
<c:otherwise>
ログイン失敗
<a href="/docoTsubu/">TOPへ</a>
</c:otherwise>
</c:choose>
</body>
</html>