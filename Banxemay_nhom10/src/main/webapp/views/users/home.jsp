<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>${title}</h2>

<div class="container d-flex justify-content-center">
	<div class="row">
		<c:forEach var="item" items="${listpro}">
			<div class="col-md-4 mt-2">
				<div class="card">
					<div class="card-body">
						<div class="card-img-actions">
							<img
								src='<c:url value="/image?fname=product/${item.imageLink}" />'
								class="card-img img-fluid" width="96" height="350" alt="">
						</div>
					</div>
					<div class="card-body bg-light text-center">
						<div class="mb-2">
							<h6 class="font-weight-semibold mb-2">
								<a href='<c:url value="/user/detail?id=${item.productID}" />'
									class="text-default mb-2" data-abc="true">${item.productName}</a>
							</h6>
							<a href="#" class="text-muted" data-abc="true">${item.category.cateName}</a>
						</div>
						<p class="mb-0">${item.price}VNĐ</p>
						<div class="d-flex">
							<button type="button" class="btn btn-primary mr-2"
								data-toggle="modal"
								data-target="#exampleModal-${item.productID}">View</button>
							<button type="button" class="btn btn-success">
								<i class="fa fa-cart-plus mr-2"></i> Add to cart
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- BEGIN fast view of a product -->
			<!-- Modal -->
			<div class="modal fade" id="exampleModal-${item.productID}"
				tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true">
				<div class="modal-dialog modal-xl" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div id="product${item.productID}">
								<div class="product-page product-pop-up${item.productID}">
									<div class="row">
										<div class="col-md-6 col-sm-6 col-xs-3">
											<div class="product-main-image">
												<img
													src='<c:url value="/image?fname=product/${item.imageLink}" />'
													class="img-fluid" alt="Cool green dress with red bell"
													class="img-responsive">
											</div>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-9">
											<h1>${item.productName}</h1>
											<div class="price-availability-block clearfix mt-1">
												<div class="price">
													<strong>${item.price} <span>VND</span></strong>
													<!--<em>${item.price} <span>VND</span></em>-->
												</div>
											</div>
											<div class="description">
												<p>${item.desc}</p>
											</div>
											<div class="product-page-options">
												<div class="pull-left">
													<label class="control-label">Color:</label> <select
														class="form-control input-sm">
														<option>Black</option>
														<option>White</option>
														<option>Red</option>
														<option>Other</option>
													</select>
												</div>
											</div>
											<div class="product-page-cart mt-1">
												<div class="product-quantity">
													<input id="product-quantity" type=number value="1"
														name="product-quantity" class="form-control input-sm">
												</div>
												<button class="btn btn-primary mt-1" type="submit">Add
													to cart</button>
												<a href='<c:url value="/user/detail?id=${item.productID}" />'
													class="btn btn-default">More details</a>
											</div>
										</div>
										<div class="sticker sticker-sale"></div>
									</div>
								</div>
							</div>
							<!-- END fast view of a product -->
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>