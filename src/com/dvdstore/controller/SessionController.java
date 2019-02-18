package com.dvdstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dvdstore.dao.Dao;
import com.dvdstore.model.Cart;
import com.dvdstore.model.CartImpl;
import com.dvdstore.model.Customers;
import com.dvdstore.model.Film;
import com.dvdstore.model.FilmImpl;

/**
 * Servlet implementation class SessionController
 */
@WebServlet("/SessionController")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoRichiesta = request.getParameter("comm");
		HttpSession session = request.getSession(false);
		
		if(tipoRichiesta.equals("logout")) {
			session = request.getSession(false);
			if(session != null) {
				session.invalidate();
				response.sendRedirect("views/homepage.jsp");
				return;
				//request.getRequestDispatcher("dvdstore").forward(request, response);
			}
		}
		
		Cart carrello = (Cart) session.getAttribute("carrello");
		CartImpl cartImpl = new CartImpl();
		FilmImpl filmImpl = new FilmImpl();
		//System.out.println("carrello: "+carrello + "--- film: "+filmImpl.getById(idFilm));
		
		//PrintWriter out = response.getWriter();
		//out.println("carrello: "+carrello + "--- film: "+filmImpl.getById(idFilm));
		if(tipoRichiesta.equals("buy")) {
			cartImpl.confirm(carrello);
			response.sendRedirect("views/profilo.jsp");
			return;
		}
		
		Integer idFilm = Integer.parseInt(request.getParameter("idFilm"));
		
		
		if(tipoRichiesta.equals("add")) {
			cartImpl.addToCart(carrello,filmImpl.getById(idFilm));
		}
		else if(tipoRichiesta.equals("remove")) {
			cartImpl.removeFromCart(carrello,filmImpl.getById(idFilm));
			response.sendRedirect("views/profilo.jsp");
		}
		
		
		
		//response.sendRedirect("views/profilo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = null;
		String psw = null;
		Customers cus = null;
		//String tipo = request.getParameter("tipoRichiesta");
		String tipo = request.getParameter("btnAccedi");
		PrintWriter out = response.getWriter();
		String prevUrl = request.getParameter("initUrl");
		if(tipo.equals("Accedi")) {
			username = request.getParameter("email");
			psw = request.getParameter("password");
			String query = "select customer_id,first_name,last_name,email,address_id from customer where email='" 
					+ username + "' and address_id='" + psw + "'";
			Connection c = Dao.getConnection();
			try {
				Statement s = c.createStatement();
				ResultSet rst = s.executeQuery(query);
				if(rst.first()) {
					if(rst.next() == false) {
						rst.previous();
						cus = new Customers();
						cus.setAddressId(rst.getString("customer_id"));
						cus.setCognome(rst.getString("last_name"));
						cus.setNome(rst.getString("first_name"));
						cus.setEmail(rst.getString("email"));
						HttpSession session = request.getSession(true);
						session.setAttribute("utente", cus);
						session.setAttribute("initUrl", prevUrl);
						session.setAttribute("carrello", new Cart());
						//request.getRequestDispatcher("views/homepage.jsp").forward(request, response);
						response.sendRedirect("views/homepage.jsp");
					}
				}
				else {
					out.println("<p align=" + '"' + "center" + '"' + "><b>Sorry, invalid credentials</b></p> ");
					request.getRequestDispatcher("views/login.jsp").include(request, response);
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				out.close();
			}
		}
		
		
		
	}

}
