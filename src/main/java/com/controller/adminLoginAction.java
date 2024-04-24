package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.jdbc_conn;
import com.entity.Adminlogin;
import com.model.Promodel;

/**
 * Servlet implementation class adminLoginAction
 */
@WebServlet("/adminLoginAction")
public class adminLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username=request.getParameter("username");
		System.out.println(username);
		String password=request.getParameter("password");
		System.out.println(password);
		
		Adminlogin l=new Adminlogin();
		l.setUsername(username);
		l.setPassword(password);
		
		Promodel p=new Promodel(jdbc_conn.getConnection());
		try {
			Adminlogin l1=p.checkadmin(username,password);
			if(l1!=null) {
				response.sendRedirect("home.jsp");
			}else {
				response.sendRedirect("adminLogin.jsp?msg=invalid");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
