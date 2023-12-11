<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/template/user" var ="url"></c:url>

<div class="main">
	<div class="container-fluid">
	
	<!-- BEGIN SIDEBAR -->
	<div class="sidebar col-md-3 col-sm-5">
		<ul class="list-group margin-bottom-25 sidebar-menu">
		<c:forEach items="${cateList}" var="cateList">
			<li class="list-group-item clearfix"><a href='<c:url value="/product/list?categoryid=${cateList.cateID }&sellerid=0"/>'> <img src="<c:url value="/image?fname=category/${cateList.image }"/>" class="img-circle" width="22px">${cateList.cateName }</a></li>
		</c:forEach>
		</ul>
		
		<ul class="list-group margin-bottom-25 sidebar-menu">
		<c:forEach items="${sellerList}" var="sellerList">
			<li class="list-group-item clearfix"><a href='<c:url value="/product/list?sellerid=${sellerList.sellerid }&cateID=0"/>'> <img src="<c:url value="/image?fname=seller/${cateList.image }"/>" class="img-circle" width="22px">${sellerList.sellername }</a></li>
		</c:forEach>
		</ul>
		
		<div class="sidebar-filter margin-bottom-25">
			<h2>Filter</h2>
			<h3>Availability</h3>
				<label><input type="checkbox"> Not Available (3)</label>
				<label><input type="checkbox"> In Stock (26)</label>
		</div>
		
			<h3>Price</h3>
			<p>
				<label for="amount">Range:</label>
				<input type="text" id="amount" style="border:0; color:#f6931f; font-weight:bold;">
			<p>
			<div id="slider-range"></div>
		</div>
	
		<div class="sidebar-product clearfix">
		<h2>Bestsellers</h2>
		
		</div>
	</div>
</div>