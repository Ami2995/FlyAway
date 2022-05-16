package com.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bean.FlightsBean;
import com.java.dao.FlightsDAO;

/**
 * Servlet implementation class ShowFlights
 */
public class ShowFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFlights() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sou = request.getParameter("source");
		String dest = request.getParameter("destination");
		String date = request.getParameter("jdate");

		HttpSession session = request.getSession();
		FlightsBean flight = new FlightsBean();
		flight.setSource(sou);
		flight.setDestination(dest);
		flight.setJdate(date);

		FlightsDAO dao = new FlightsDAO();
		if (sou.equals(null) || sou == "" || dest.equals(null) || dest == "" || date.equals(null) || date == "") {
			request.setAttribute("msg", "* Please provide details*");
			getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		} else {
			List<FlightsBean> flights = dao.getAvailableFlights(flight);
			session.setAttribute("flights", flights);
			getServletContext().getRequestDispatcher("/showflights.jsp").forward(request, response);
		}
	}
}
