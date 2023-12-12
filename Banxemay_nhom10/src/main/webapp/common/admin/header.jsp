<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href='<c:url value="/user/home" />'>Group 10 - Banxemay</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end"
			id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
				<li class="nav-item ${setActiveHeader=='home'?'active':''}"><a
					class="nav-link" href='<c:url value="/user/home" />'>Home <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item ${setActiveHeader=='categories'?'active':''}"><a
					class="nav-link" href='<c:url value="/admin/category/findAll" />'>Categories</a>
				</li>
				<li class="nav-item ${setActiveHeader=='product'?'active':''}"><a
					class="nav-link" href='<c:url value="/admin/product/listproduct" />'>Product</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="product.html">Cart</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#contact">Contact</a>
				</li>
			</ul>

			<form class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input type="text" class="form-control" placeholder="Search...">
					<div class="input-group-append">
						<button type="button" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<a class="btn btn-success btn-sm ml-3" href="cart.html"> <i
					class="fa fa-shopping-cart"></i> Cart <span
					class="badge badge-light">3</span>
				</a>
			</form>
		</div>
	</div>
</nav>

<section class="jumbotron text-center bg-banner">
	<div class="container">
		<h1 class="jumbotron-heading">Bán xe máy</h1>
		<p class="lead text-white mb-0">Dẫn đầu sự di chuyển với chất
			lượng và phong cách tại mỗi quãng đường!</p>
	</div>
</section>