package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.java.bean.UserBean;
import com.java.dao.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("fname");
		String mail = request.getParameter("email");
		String cont = request.getParameter("contact");
		String pass = request.getParameter("password");

		UserBean user = new UserBean();
		user.setFname(name);
		user.setEmail(mail);
		user.setContact(cont);
		user.setPassword(pass);
		

		UserDAO dao = new UserDAO();
		if (name.equals(null) || name == "" || mail.equals(null) || mail == "" || cont.equals(null) || cont == ""
				|| pass.equals(null) || pass == "") {
                request.setAttribute("msg", "* All fields are mandatory *");
                getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
		}else {
			int row = dao.signupUser(user);
			if(row>0) {
				 request.setAttribute("msg", "* You register succesfully* <br>* Please Login *");
	                getServletContext().getRequestDispatcher("/bookflight.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "* Not registered *");
                getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
			}
		}
	}

}
