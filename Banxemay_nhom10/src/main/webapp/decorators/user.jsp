<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Trang chủ bán xe máy</title>
<!-- CSS -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href='<c:url value="/template/user/css/style.css" />'
	rel="stylesheet" type="text/css">
</head>

<body>
	<%@ include file="/common/user/header.jsp"%>

	<div class="container">
		<table border="1" style="width: 100%">
			<tr>
				<td valign="top" style="width: 30%; padding: 30px;"><%@ include
						file="/common/user/left.jsp"%></td>
				<td valign="top" style="width: 70%; padding: 30px;"><decorator:body></decorator:body></td>
			</tr>
		</table>
	</div>
	<%@ include file="/common/user/footer.jsp"%>
	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>