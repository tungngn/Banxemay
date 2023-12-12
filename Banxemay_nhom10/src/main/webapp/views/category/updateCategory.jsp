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
	<form action="update" method="post">
			<label>ID:</label>
			<input type="text" name="cateID" value="${cate.cateID}" readonly="readonly">
			<label>Nhập tên hãng xe:</label>
			<input type="text" name="cateName" value="${cate.cateName}">
			<label>Nhập link hình ảnh:</label>
			<input type="text" name="image" value="${cate.image}">
			
			<input type="submit" value="Update Category">
	
	</form>

</body>
</html>