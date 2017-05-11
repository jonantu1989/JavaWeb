package com.ipartek.ejemplos.jonantunano.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/texto")
public class ChatTextoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		ServletContext application = getServletContext();

		String texto = (String) application.getAttribute("texto");

		String nombre = (String) session.getAttribute("nombre");

		PrintWriter out = response.getWriter();

		out.println(nombre + ':' + texto);
	}

}
