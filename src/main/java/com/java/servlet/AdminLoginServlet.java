package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bean.AdminLoginBean;
import com.java.dao.AdminLoginDAO;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String uname = request.getParameter("user_name");
		String pass = request.getParameter("password");
        HttpSession session = request.getSession();
		AdminLoginBean admin = new AdminLoginBean();
		admin.setUser_name(uname);
		admin.setPassword(pass);

		AdminLoginDAO dao = new AdminLoginDAO();
		if (uname.equals(null) || uname == "" || pass.equals(null) || pass == "") {
			request.setAttribute("msg", "* All fields are mandatory *");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			if(dao.validateAdmin(admin)) {
				session.setAttribute("user", uname);
				session.setAttribute("password", pass);
				request.setAttribute("msg", "* You have loggedin successfully *");
				getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "* Invalid Credentials *");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}

}
