<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<style>
.active {
	background-color: #0062cc;
	color: #ffffff;
}
</style>
<h4>Danh mục các hãng xe</h4>
<br>
<c:forEach var="item" items="${listcate}">
	<c:forEach var="item1" items="${countCID}">
		<c:if test="${item1.categoryID == item.cateID && item1.total !=0 }">
				<article class="filter-group">
					<header class="card-header">
						<a href='<c:url value="/user/listprocate?cateID=${item.cateID}" />'>
							<span class="${setactive==item.cateID?'active':''}">
								${item.cateName}</span> <small> (${item1.total}) </small>
						</a>
					</header>
				</article>
		</c:if>
	</c:forEach>
</c:forEach>