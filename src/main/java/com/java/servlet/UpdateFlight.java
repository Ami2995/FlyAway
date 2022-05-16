package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.FlightsBean;
import com.java.dao.FlightsDAO;

/**
 * Servlet implementation class UpdateFlight
 */
public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sn = 0;
		try {
			sn = Integer.parseInt(request.getParameter("sno"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String fid = request.getParameter("flight_id");
		String sou = request.getParameter("source");
		String dest = request.getParameter("destination");
		String fname = request.getParameter("flight_name");
		String dat = request.getParameter("jdate");
		String dtim = request.getParameter("dept_time");
		String atim = request.getParameter("arr_time");
		double pri = 0.0;
		try {
			pri = Double.parseDouble(request.getParameter("price"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		FlightsBean fly = new FlightsBean();
		fly.setSno(sn);
		fly.setFlight_id(fid);
		fly.setSource(sou);
		fly.setDestination(dest);
		fly.setFlight_name(fname);
		fly.setJdate(dat);
		fly.setDept_time(dtim);
		fly.setArr_time(atim);
		fly.setPrice(pri);

		FlightsDAO dao = new FlightsDAO();
		if (fid.equals(null) || fid == "" || sou.equals(null) || sou == "" || dest.equals(null) || dest == ""
				|| fname.equals(null) || fname == "" || dat.equals(null) || dat == "" || dtim.equals(null) || dtim == ""
				|| atim.equals(null) || atim == "") {
			request.setAttribute("msg", "* All fields are mandatory *");
			getServletContext().getRequestDispatcher("/editflight.jsp").forward(request, response);
		} else {
			int row = dao.updateFlights(fly);
			if (row > 0) {
				request.setAttribute("msg", "* Updated Successfully *");
				getServletContext().getRequestDispatcher("/display.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "* Not Updated *");
				getServletContext().getRequestDispatcher("/editflight.jsp").forward(request, response);
			}

		}

	}

}
