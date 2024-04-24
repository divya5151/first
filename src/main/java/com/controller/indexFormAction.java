package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.jdbc_conn;
import com.entity.Bloodrequest;
import com.model.Promodel;

/**
 * Servlet implementation class indexFormAction
 */
@WebServlet("/indexFormAction")
public class indexFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexFormAction() {
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
		String name=request.getParameter("name");
		System.out.println(name);
		String mobilenumber=request.getParameter("mobilenumber");
		System.out.println(mobilenumber);
		String email=request.getParameter("email");
		System.out.println(email);
		String bloodgroup=request.getParameter("bloodgroup");
		System.out.println(bloodgroup);
		String status="pending";
		
	    Bloodrequest b=new Bloodrequest();
	    b.setName(name);
	    b.setMobilenumber(mobilenumber);
	    b.setEmail(email);
	    b.setBloodgroup(bloodgroup);
	    b.setStatus(status);
	    
	    Promodel p=new Promodel(jdbc_conn.getConnection());
	    try {
	    	boolean b1=p.request(b);
	    	if(b1) {
	    		response.sendRedirect("index.jsp?msg=valid");
	    	}
	    	
	    }catch (Exception e) {
			// TODO: handle exception
	    	response.sendRedirect("index.jsp?msg=invalid");
	    
		}
		
	}

}
