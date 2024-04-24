package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.jdbc_conn;
import com.entity.Donor;
import com.model.Promodel;

/**
 * Servlet implementation class addNewDonorAction
 */
@WebServlet("/addNewDonorAction")
public class addNewDonorAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewDonorAction() {
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
	    String id=request.getParameter("id");
		System.out.println(id);
		
		String name=request.getParameter("name");
		System.out.println(name);
		
		String father=request.getParameter("father");
		System.out.println(father);
		
		String mother=request.getParameter("mother");
		System.out.println(mother);
		
		String mobilenumber=request.getParameter("mobilenumber");
		System.out.println(mobilenumber);
		
		String gender=request.getParameter("gender");
		System.out.println(gender);
		
		String email=request.getParameter("email");
		System.out.println(email);
		
		String bloodgroup=request.getParameter("bloodgroup");
		System.out.println(bloodgroup);
		
		String address=request.getParameter("address");
		System.out.println(address);
		
		Donor d=new Donor();;
		d.setId(id);
		d.setName(name);
		d.setFather(father);
		d.setMother(mother);
		d.setMobilenumber(mobilenumber);
		d.setGender(gender);
		d.setEmail(email);
		d.setBloodgroup(bloodgroup);
		d.setAddress(address);
		
		Promodel p=new Promodel(jdbc_conn.getConnection());
		try {
			boolean b=p.addDoner(d);
			if(b) {
				response.sendRedirect("addNewDonor.jsp?msg=valid");
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("addNewDonor.jsp?msg=invalid");

		}
		
		
		
		
		
		
	}

}
