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
 * Servlet implementation class ChangePasswordServlet
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldp = request.getParameter("oldpass");
		String newp = request.getParameter("newpass");
		String rnewp = request.getParameter("renewpass");
		
		HttpSession session = request.getSession();
		String cpass = (String)session.getAttribute("password");
		String uname = (String)session.getAttribute("user");
		
		AdminLoginBean admin = new AdminLoginBean();
		admin.setPassword(newp);
		admin.setUser_name(uname);
		
		AdminLoginDAO dao = new AdminLoginDAO();
		
		if(oldp.equals(null) || oldp=="" || newp.equals(null) || newp=="" || rnewp.equals(null) || rnewp=="") {
			request.setAttribute("msg", "* All fields are mandatory *");
			getServletContext().getRequestDispatcher("/resetpassword.jsp").forward(request, response);
		}else if(!newp.equals(rnewp)) {
			request.setAttribute("msg", "* Password does not match *");
			getServletContext().getRequestDispatcher("/resetpassword.jsp").forward(request, response);	
		}else if(!cpass.equals(oldp)) {
			request.setAttribute("msg", "* Old password is not correct *");
			getServletContext().getRequestDispatcher("/resetpassword.jsp").forward(request, response);
		}else {
			int row = dao.changePassword(admin);
			if(row>0) {
				request.setAttribute("msg", "* Password Changed Successfully *<br> * Login Again *");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
				session.invalidate();
			}else {
				request.setAttribute("msg", "* Password not Updated *");
				getServletContext().getRequestDispatcher("login.jsp").forward(request, response);
				session.invalidate();
			}
		}
	}

}
