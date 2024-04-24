package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.jdbc_conn;
import com.model.Promodel;

/**
 * Servlet implementation class manageStockAction
 */
@WebServlet("/manageStockAction")
public class manageStockAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageStockAction() {
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
		String bloodGroup = request.getParameter("bloodGroup");
        String indec = request.getParameter("indec");
        String units = request.getParameter("units");
        int units1 = Integer.parseInt(units);

        try {
            Promodel p = new Promodel(jdbc_conn.getConnection());
            if (indec.equals("inc")) {
                p.increaseStock(bloodGroup, units1);
            } else {
                p.decreaseStock(bloodGroup, units1);
            }
            response.sendRedirect("manageStock.jsp?msg=valid");
        } catch (SQLException e) {
            response.sendRedirect("manageStock.jsp?msg=invalid");
        }
    }
	}


