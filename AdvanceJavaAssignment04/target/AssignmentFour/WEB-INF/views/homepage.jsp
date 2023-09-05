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

<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">



<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>
	<section class="container-fluid">
		<div class="row mb-3">
			<div class="col-12 text-center">
				<h3>Product Management Tool</h3>
			</div>
		</div>
	</section>
	<%-- <h1>${user.username}</h1> --%>

	<section>
		<div class="container">
			<div class="row">
				<div class="col-6">
					<form action="homepage" method="get">
						<button type="submit" class="btn btn-sm btn-success">Reset</button>
					</form>
				</div>
				<div class="col-4 card">
					<form action="search" method="get">
						<div>
							<table>
								<tr>
									<td><label for="color" class="required">Color<span
											style="color: #ff0000">*</span> :
									</label></td>
									<td><input type="text" id="color" name="color"></td>
								</tr>
								<tr>
									<td><label for="size" class="required">Size<span
											style="color: #ff0000">*</span> :
									</label></td>
									<td><select name="size" id="size">
											<option value="S">Small</option>
											<option value="M">Medium</option>
											<option value="L">Large</option>
											<option value="XL">Extra Large</option>
									</select></td>
								</tr>
								<tr>
									<td><label for="gender" class="required">Gender<span
											style="color: #ff0000">*</span> :
									</label></td>
									<td><select name="gender" id="gender">
											<option value="M">Male</option>
											<option value="F">Female</option>
											<option value="U">Unisex</option>
									</select></td>
								</tr>
								<tr>
									<td><label for="outputPreference" class="required">Preference<span
											style="color: #ff0000">*</span> :
									</label></td>
									<td><select name="outputPreference" id="outputPreference">
											<option value="1">By Price</option>
											<option value="2">By Rating</option>
											<option value="3">By both</option>
									</select></td>
								</tr>
							</table>
						</div>
						<button type="submit" class="btn-sm btn btn-success">Search</button>
					</form>

				</div>
			</div>
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
							<th scope="col">Name</th>
							<th scope="col">Color</th>
							<th scope="col">Gender</th>
							<th scope="col">Size</th>
							<th scope="col">Price</th>
							<th scope="col">Rating</th>
							<th scope="col">Availability</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="0" scope="page" />
						<c:forEach items="${list}" var="item">
							<tr>
								<c:set var="count" value="${count+1 }" scope="page" />
								<td>${count}</td>
								<td>${item.name}</td>
								<td>${item.color}</td>
								<td>${item.gender}</td>
								<td>${item.size}</td>
								<td>${item.price}</td>
								<td>${item.rating}</td>
								<td>${item.availability}</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
				<div>
					<h6>Number of items: ${count}</h6>
				</div>
			</div>
		</div>
	</section>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
    -->
</body>
</html>