package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bean.UserBean;
import com.java.dao.UserDAO;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
     
		String mail = request.getParameter("email");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		UserBean user = new UserBean();
		user.setEmail(mail);
		user.setPassword(pass);
    
		UserDAO dao = new UserDAO();
		if (mail.equals(null) || mail == "" || pass.equals(null) || pass == "") {
			request.setAttribute("msg", "* All fields are mandatory *");
			getServletContext().getRequestDispatcher("/bookflight.jsp").forward(request, response);
		} else {
			if (dao.validateUser(user)) {
				session.setAttribute("user",mail);
				request.setAttribute("msg", "* You have loggedin successfully *");
				getServletContext().getRequestDispatcher("/userwelcome.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "* Invalid Credentials *");
				getServletContext().getRequestDispatcher("/bookflight.jsp").forward(request, response);
			}
		}
	}
}
