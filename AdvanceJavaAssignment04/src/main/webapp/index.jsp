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
	<div class="my-form container">

		<div class="row">
			<div class="col-4"></div>
			<div class="col-4 py-3 card">
				<form method="post" action="login">
					<!-- <div class="form-group">
				<label for="username">Email address</label> <input type="text"
					name="uname" class="form-control" id="username"
					aria-describedby="emailHelp"
					style="display: inline-block; width: 50%;">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input name="password"
					type="password" class="form-control" id="password">
			</div> -->
					<div>
						<table>
							<tr>
								<td><label for="username">Username: </label></td>
								<td><input type="text" name="uname" class="form-control"
									id="username"></td>
							</tr>
							<tr>
								<td><label for="password">Password: </label></td>
								<td><input name="password" type="password"
									class="form-control" id="password"></td>
							</tr>
						</table>
					</div>
					<br>
					<div class="text-center">
						<button type="submit" class="btn btn-sm btn-success">Login</button>
					</div>
				</form>
			</div>
			<div class="col-4"></div>


		</div>
	</div>
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