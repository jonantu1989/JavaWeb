package com.ipartek.ejemplos.jonantunano.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/guardar")
public class GuardarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("dato");

		HttpSession session = request.getSession();

		session.setAttribute("dato", dato);

		// session.setAttribute("usuario", new Usuario("jon", "yepa")); Se puede
		// meter cualquier tipo de dato

		// request.getSession().setAttribute("dato", dato);
	}

}
