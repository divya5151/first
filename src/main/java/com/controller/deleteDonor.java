package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.jdbc_conn;
import com.model.Promodel;

/**
 * Servlet implementation class deleteDonor
 */
@WebServlet("/deleteDonor")
public class deleteDonor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteDonor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id=request.getParameter("id");
		System.out.println(id);
		Promodel p=new Promodel(jdbc_conn.getConnection());
		try {
			boolean b=p.deletedonor(id);
			if(b) {
				response.sendRedirect("editDeleteList.jsp?msg=deleted");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("editDeleteList.jsp?msg=invalid");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
