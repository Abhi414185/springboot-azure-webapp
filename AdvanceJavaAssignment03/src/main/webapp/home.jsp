<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- <link rel="stylesheet" href="style.css" type="text/css"> -->

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

<title>Home Page</title>
</head>
<body>
	<section class="container-fluid">
		<div class="row mb-3">
			<div class="col-10 text-center">
				<h3>Product Management Tool</h3>
			</div>
			<div class="col-2 text-center">
				<h6>Hi ${name}</h6>
			</div>
		</div>
	</section>
	<section class="container">
		<div>
			<h6>Please enter product details to add to stock</h6>
			<form method="post" action="AddProduct" enctype="multipart/form-data">
			
			<div>
			<table>
				<tr>
					<td><label for="title">Title</label></td>
					<td><input type="text" id="title"
						name="title"></td>
				</tr>
				<tr>
					<td><label for="quantity">Quantity</label></td>
					<td><input type="text"
						id="quantity" name="quantity"></td>
				</tr>
				<tr>
					<td><label for="size">Size</label></td>
					<td><input type="text" id="size"
						name="size"></td>
				</tr>
				<tr>
					<td><label for="image">Image</label></td>
					<td><input type="file" id="image" accept=".png, .jpg, .jpeg"
						name="image"></td>
				</tr>
			</table>
			</div>

				<button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>
	</section>
<br> 

	<section>
		<div class="container">
			<div class="row">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Sl No.</th>
							<th scope="col">Title</th>
							<th scope="col">Quantity</th>
							<th scope="col">Size</th>
							<th scope="col">Image</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="0" scope="page" />
						<c:forEach items="${itemList}" var="item">
							<tr>
								<c:set var="count" value="${count+1 }" scope="page" />
								<td>${count}</td>
								<td>${item.title}</td>
								<td>${item.quantity}</td>
								<td>${item.size}</td>
								<td><img alt="No image" src="data:image/png;base64,${item.base64Image}" style="width:200px;">
								</td>
								<td>
									<form action="EditProduct" method="get">
										<input type="hidden" name="id" value="${item.productID}">
										<button type="submit" class="btn btn-primary"
											data-toggle="modal" data-target="#exampleModal">Edit</button>
									</form> <a
									href="DeleteProduct?title=${item.title}&quantity=${item.quantity}&size=${item.size}">Delete</a>
								</td>
							</tr>
						</c:forEach>
						
						
					</tbody>
				</table>
				<div><h6>Number of items: ${count}</h6></div>
			</div>
		</div>
	</section>

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>

</body>
</html>