<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="admin-insertpro" method="post" enctype="multipart/form-data">
			<label>Enter Product Name:</label>
			<input type="text" name="productName"><br>
			<label>Enter Description:</label>
			<textarea name="desc" cols="5" class="form-control" style="width:100%"></textarea><br>
			<label>Enter Price:</label>
			<input type="text" name="price"><br>
			<label>Enter Image Link:</label>
			<input type="file" name="imageLink"><br>
			<label for="category">Category:</label>
							<select name="categoryID">
								<c:forEach items="${list}" var="item">
									<option value="${item.cateID}">${item.cateName}</option>
								</c:forEach>
							</select><br>
			<label>Enter Stoke:</label>
			<input type="text" name="stoke"><br>
			
			<input type="submit" value="Insert product">
	
	</form>

</body>
</html>