<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${message!=null}">
		<span>${message}</span>
	</c:if>
	<c:if test="${error!=null}">
		<span>${error}</span>
	</c:if>

	<a href='<c:url value= "/admin/product/admin-insertpro"/> '
		class="btn btn-success float-right">Add product</a>
	<h3>Danh sách sản phẩm</h3>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Name</th>
				<th scope="col">Description</th>
				<th scope="col">Price</th>
				<th scope="col">Image</th>
				<th scope="col">Category</th>
				<th scope="col">Amount</th>
				<th scope="col">Stock</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${listpro}">
				<tr>
					<td>${item.productID}</td>
					<td>${item.productName}</td>
					<td><c:if test="${item.desc.length() <= 20}">
         					${item.desc}
      					</c:if>
      					<c:if test="${item.desc.length() > 20}">
         					${item.desc.substring(0,20)}...
      					</c:if></td>
					<td>${item.price}</td>
					<td>${item.imageLink}</td>
					<td>${item.categoryID}</td>
					<td>${item.amount}</td>
					<td>${item.stoke}</td>

					<td><a
						href='<c:url value="/admin/product/update?id=${item.productID}" /> '
						class="btn btn-primary">Update</a> <a
						href='<c:url value="/admin/product/delete?id=${item.productID}" /> '
						class="btn btn-danger">Delete</a></td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
</body>
</html>