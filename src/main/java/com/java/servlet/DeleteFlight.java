package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.FlightsDAO;

/**
 * Servlet implementation class DeleteFlight
 */
public class DeleteFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sn = 0;
        try {
       	 sn = Integer.parseInt(request.getParameter("sno"));
        }catch(NumberFormatException e) {
       	 e.printStackTrace();
        }
		
		
		FlightsDAO dao = new FlightsDAO();
		
			int row = dao.deleteFlights(sn);
			if (row > 0) {
				request.setAttribute("msg", "* Deleted Successfully *");
				getServletContext().getRequestDispatcher("/display.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "* Not Deleted *");
				getServletContext().getRequestDispatcher("/deleteflight.jsp").forward(request, response);
			}

	
	}

}
