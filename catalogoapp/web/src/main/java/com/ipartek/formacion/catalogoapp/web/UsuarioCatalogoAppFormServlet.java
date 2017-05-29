package com.ipartek.formacion.catalogoapp.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.catalogoapp.dal.DALException;
import com.ipartek.formacion.catalogoapp.dal.UsuarioDAL;
import com.ipartek.formacion.catalogoapp.tipos.Usuario;

public class UsuarioCatalogoAppFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");

		// response.setContentType("text/plain");
		// PrintWriter out = response.getWriter();
		// out.println(op);
		// out.println(nombre);
		// out.println(pass);
		// out.println(pass2);

		if (op == null) {
			request.getRequestDispatcher(
					TiendaCatalogoAppCrudServlet.RUTA_LISTADO).forward(request,
					response);
			return;
		}
		Usuario usuario = new Usuario(nombre, pass);
		ServletContext application = request.getServletContext();
		UsuarioDAL dal = (UsuarioDAL) application.getAttribute("dal");
		switch (op) {
		case "alta":
			if (pass.equals(pass2)) {
				dal.alta(usuario);
			} else {
				usuario.setErrores("Las contraseñas no coinciden");
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher(
						TiendaCatalogoAppCrudServlet.RUTA_FORMULARIO).forward(
						request, response);
			}
		case "modificar":
			if (pass.equals(pass2)) {
				try {
					dal.modificar(usuario);
				} catch (DALException de) {

				}
				request.getRequestDispatcher(
						TiendaCatalogoAppCrudServlet.RUTA_LISTADO).forward(
						request, response);
			}
		}

	}
}
