<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
			<label>Nhập tên hãng xe:</label>
			<input type="text" name="cateName">
			<label>Nhập link hình ảnh:</label>
			<input type="text" name="image">
			
			<input type="submit" value="Add Category">
	
	</form>

</body>
</html>