package com.ipartek.formacion.catalogoapp.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.catalogoapp.dal.DALFactory;
import com.ipartek.formacion.catalogoapp.dal.UsuarioDAL;
import com.ipartek.formacion.catalogoapp.dal.UsuarioYaExistenteDALException;
import com.ipartek.formacion.catalogoapp.tipos.Usuario;

public class AltaCatalogoAppServlet extends HttpServlet {
	/* package */static final String USUARIOS_DAL = "usuarioDAL";

	private static final long serialVersionUID = 1L;

	/* package */static final String RUTA_ALTA = LoginCatalogoAppServlet.RUTA
			+ "alta.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");

		// Inicio sin datos: mostrar formulario
		// Datos incorrectos: sin rellenar, l�mite de caracteres, no coinciden
		// contrase�as
		// Las contrase�as deben ser iguales
		// Datos correctos: guardar

		Usuario usuario = new Usuario(nombre, pass);

		boolean hayDatos = nombre != null && pass != null && pass2 != null;
		boolean datosCorrectos = validarCampo(nombre) && validarCampo(pass)
				&& validarCampo(pass2);
		boolean passIguales = pass != null && pass.equals(pass2);

		if (hayDatos) {
			if (!datosCorrectos) {
				usuario.setErrores("Todos los campos son requeridos y con un m�nimo de "
						+ LoginCatalogoAppServlet.MINIMO_CARACTERES
						+ " caracteres");
				request.setAttribute("usuario", usuario);
			} else if (!passIguales) {
				usuario.setErrores("Las contrase�as deben ser iguales");
				request.setAttribute("usuario", usuario);
			} else {
				ServletContext application = request.getServletContext();

				UsuarioDAL usuariosDAL = (UsuarioDAL) application
						.getAttribute(USUARIOS_DAL);

				if (usuariosDAL == null) {
					usuariosDAL = DALFactory.getUsuarioDAL();
				}

				try {
					usuariosDAL.alta(usuario);
				} catch (UsuarioYaExistenteDALException de) {
					usuario.setNombre("");
					usuario.setErrores("El usuario ya existe. Elige otro");
					request.setAttribute("usuario", usuario);
				}

				application.setAttribute(USUARIOS_DAL, usuariosDAL);
			}
		}
		request.getRequestDispatcher(RUTA_ALTA).forward(request, response);
		return;
	}

	private boolean validarCampo(String campo) {
		return campo != null
				&& campo.length() >= LoginCatalogoAppServlet.MINIMO_CARACTERES;
	}

}
