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
			<input type="text" name="productID" value="${pro.productID}" readonly="readonly">
			<label>Nhập tên mẫu xe:</label>
			<input type="text" name="productName" value="${pro.productName}">
			
			<label>Nhập mô tả chi tiết:</label>
			<input type="text" name="desc" value="${pro.desc}">
			
			<label>Nhập giá:</label>
			<input type="text" name="price" value="${pro.price}">
			
			<label>Nhập link hình ảnh:</label>
			<input type="text" name="imageLink" value="${pro.imageLink}">
			
			<label>Nhập hãng xe:</label>
			<input type="text" name="categoryID" value="${pro.categoryID}" readonly="readonly">
			
			<label>Nhập người bán:</label>
			<input type="text" name="sellerID" value="${pro.sellerID}">
			
			<label>Nhập số lượng:</label>
			<input type="text" name="amount" value="${pro.amount}">
			
			<label>Nhập hàng tồn kho:</label>
			<input type="text" name="stoke" value="${pro.stoke}">
			
			<input type="submit" value="Update Product">
	
	</form>

</body>
</html>