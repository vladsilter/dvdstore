package com.dvdstore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvdstore.model.Customers;
import com.dvdstore.model.CustomersImpl;

/**
 * Servlet implementation class MainControllerRegistra
 */
@WebServlet("/MainControllerRegistra")
public class MainControllerRegistra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String msg = null;
		RequestDispatcher disp;
		CustomersImpl cs=new CustomersImpl();
		if(cs.alreadysub(email)) {
			msg="già registrato";
			request.setAttribute("1",msg);
		}
		else {
			cs.add(email, password, nome);
			msg="Complimenti ti sei registrato";
			request.setAttribute("1",msg);	
		}
		//disp=request.getRequestDispatcher("views/profilo.jsp");
		//disp.forward(request, response);
	}
			
	
}