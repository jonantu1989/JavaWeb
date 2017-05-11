package com.ipartek.ejemplos.jonantunano.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/alta")
public class ChatAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("nombre");

		HttpSession session = request.getSession();

		session.setAttribute("nombre", nombre);

		out.println(request.getHeader("Nombre: " + nombre));

	}

}
