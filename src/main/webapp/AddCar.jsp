<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Car</title>
</head>
<body>
	<h2>Enter Car details: </h2>
	<form action="AddCarServlet" method="post">
		<input type="number" placeholder="Enter CarId" name="carId"><br><br>
		<input type="text" placeholder="Enter CarModel" name="carModel"><br><br>
		<input type="text" placeholder="Enter CarBrand" name="carBrand"><br><br>
		<input type="number" placeholder="Enter CarPrice" name="carPrice"><br><br>
		<input type="submit" value="add"><br>
	</form>
</body>
</html>