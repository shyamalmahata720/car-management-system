<%@page import="com.sam.ServletProject.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Car</title>
</head>
<body>
	<% Car car = (Car)request.getAttribute("existingCar"); %>
	<h1>Update Car</h1>
	<form action="saveUpdatedCar" method="post">
		<input type="number" name="carId" value="<%=car.getCarId() %>" readonly="true"><br><br>
		<input type="text" name="carModel" value="<%=car.getCarModel() %>"><br><br>
		<input type="text" name="carBrand" value="<%=car.getCarBrand() %>"><br><br>
		<input type="number" name="carPrice" value="<%=car.getCarPrice() %>"><br><br>
		<input type="submit">
	</form>
</body>
</html>