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

@WebServlet("/saveUpdatedCar")
public class SaveUpdatedCarServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		String carModel = req.getParameter("carModel");
		String carBrand = req.getParameter("carBrand");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));
		
		Car c= new Car();
		
		c.setCarId(carId);
		c.setCarModel(carModel);
		c.setCarBrand(carBrand);
		c.setCarPrice(carPrice);
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		ss.update(c);
		org.hibernate.query.Query<Car> query = ss.createQuery("FROM Car");
		List<Car> cars = query.list();
		
		
		
		tr.commit();
		ss.close();
		req.setAttribute("carList", cars);
		
		req.getRequestDispatcher("DisplayAllCars.jsp").forward(req, resp);

	}
}
