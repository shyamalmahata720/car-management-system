<%@page import="com.sam.ServletProject.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Cars</title>
</head>
<body>
	
	<table border="1px">
		<tr>
			<th>CarId</th>
			<th>CarModel</th>
			<th>CarBrand</th>
			<th>CarPrice</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<% 
		List<Car> cars = (List)request.getAttribute("carList");
		for(Car car: cars) {%>
		<tr>
			<td><%=car.getCarId()  %></td>
			<td><%=car.getCarModel()  %></td>
			<td><%=car.getCarBrand()  %></td>
			<td><%=car.getCarPrice()  %></td>
			<td><a href="updateCar?carId=<%=car.getCarId()%>">Update</a></td>
			<td><a href="deleteCar?carId=<%=car.getCarId()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
</body>
</html>