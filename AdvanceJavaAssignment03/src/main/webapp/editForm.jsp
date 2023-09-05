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

<title>Edit Page</title>
</head>
<body>
	<%-- <p>${item.productID}</p> --%>

	<section class="container">
		<div>
			<h6>Edit the item...</h6>
			<form method="post" action="UpdateProduct" enctype="multipart/form-data">
				<div>
					<table>
						<tr>
							<td><label for="title">Title</label></td>
							<td><input type="text" id="title" name="title" placeholder="${item.title }"></td>
						</tr>
						<tr>
							<td><label for="quantity">Quantity</label></td>
							<td><input type="text" id="quantity" name="quantity" placeholder="${item.quantity }"></td>
						</tr>
						<tr>
							<td><label for="size">Size</label></td>
							<td><input type="text" id="size" name="size" placeholder="${item.size }"></td>
						</tr>
						<tr>
							<td><label for="image">Image</label></td>
							<td><input type="file" id="image" accept=".png, .jpg, .jpeg"
								name="image"></td>
						</tr>
					</table>
				</div>
				<input type="hidden" name="id" value="${item.productID}">
				<button type="submit" class="btn btn-primary">Save Changes</button>
			</form>
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