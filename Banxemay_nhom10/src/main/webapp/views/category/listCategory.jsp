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
	<a href='<c:url value= "/admin/category/add"/> '
		class="btn btn-success float-right">Thêm hãng xe</a>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Name</th>
				<th scope="col">Icon</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.cateID}</td>
					<td><a
						href='<c:url value="/admin/product/findprobycate?cateID=${item.cateID}" /> '>${item.cateName}</a></td>
					<td>${item.image}</td>

					<td><a
						href='<c:url value="/admin/category/update?id=${item.cateID}" /> '
						class="btn btn-primary">Update</a> <a
						href='<c:url value="/admin/category/delete?id=${item.cateID}" /> '
						class="btn btn-danger">Delete</a></td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>