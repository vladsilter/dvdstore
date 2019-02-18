package com.dvdstore.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvdstore.model.Actor;
import com.dvdstore.model.ActorImpl;
import com.dvdstore.model.Film;
import com.dvdstore.model.FilmImpl;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titolo = request.getParameter("ricerca");
		String categoria = request.getParameter("category");
		String rTitolo = request.getParameter("srcT");
		String rActor = request.getParameter("srcA");
		String rGenere = request.getParameter("srcCat");
		String allSearch = request.getParameter("param");
		FilmImpl fImpl = new FilmImpl();
		ActorImpl aImpl = new ActorImpl();
		RequestDispatcher disp = null;
		
		if(rTitolo != null) {
			disp = request.getRequestDispatcher("/views/allFilms.jsp");
			request.setAttribute("fullList", fImpl.getByTitle(titolo));
			disp.forward(request, response);
		}
		
		if(rActor != null) {
			disp = request.getRequestDispatcher("/views/allActors.jsp");
			request.setAttribute("fullList",aImpl.findByName(titolo));
			disp.forward(request, response);
		}
		if(rGenere != null) {
			disp = request.getRequestDispatcher("/views/allFilms.jsp");
			request.setAttribute("fullList", fImpl.getByCategory(Integer.parseInt(categoria)));
			disp.forward(request, response);
		}
		if(allSearch != null) {
			if(Integer.parseInt(allSearch) == 1) {
				disp = request.getRequestDispatcher("/views/allActors.jsp");
				request.setAttribute("fullList", aImpl.getAll());
				disp.forward(request, response);
			}
			if(Integer.parseInt(allSearch) == 2) {
				disp = request.getRequestDispatcher("/views/allFilms.jsp");
				request.setAttribute("fullList", fImpl.getAll());
				disp.forward(request, response);
			}
		}
	}

}