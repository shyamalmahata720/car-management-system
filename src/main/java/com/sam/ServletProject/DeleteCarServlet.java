package com.sam.ServletProject;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		//Find Car Object
		Car car = ss.get(Car.class, carId);
		//Delete Car Object
		ss.delete(car);
		
		//Fetch the updated list of Car Object
		Query<Car> query = ss.createQuery("FROM Car");
		List<Car> cars = query.list();
		
		
		tr.commit();
		ss.close();
		
		req.setAttribute("carList", cars);
		
		req.getRequestDispatcher("DisplayAllCars.jsp").forward(req, resp);
	}
}
