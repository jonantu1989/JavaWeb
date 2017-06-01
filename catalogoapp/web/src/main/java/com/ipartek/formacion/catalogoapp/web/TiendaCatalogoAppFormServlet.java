package com.ipartek.formacion.catalogoapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.catalogoapp.dal.DALException;
import com.ipartek.formacion.catalogoapp.dal.ProductosDAL;
import com.ipartek.formacion.catalogoapp.tipos.Productos;

public class TiendaCatalogoAppFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("opform");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("decripcion");
		int precio = request.getContentLength();

		RequestDispatcher rutaListado = request
				.getRequestDispatcher(TiendaCatalogoAppCrudServlet.RUTA_SERVLET_LISTADO);

		RequestDispatcher rutaFormulario = request
				.getRequestDispatcher(TiendaCatalogoAppCrudServlet.RUTA_FORMULARIO);

		if (op == null) {
			rutaListado.forward(request, response);

		}
		Productos productos = new Productos(id, nombre, descripcion, precio);
		ServletContext application = request.getServletContext();
		ProductosDAL dal = (ProductosDAL) application.getAttribute("dal");
		switch (op) {
		case "alta":
			if (id != null) {
				dal.alta(productos);
				rutaListado.forward(request, response);
				return;
			} else {
				productos.setErrores("Los id coinciden");
				request.setAttribute("productos", productos);
				rutaFormulario.forward(request, response);
				return;
			}
		case "modificar":
			if (id.equals(id)) {
				try {
					dal.modificar(productos);
				} catch (DALException de) {
					productos.setErrores(de.getMessage());
					request.setAttribute("productos", productos);
					rutaFormulario.forward(request, response);
					return;
				}
				rutaListado.forward(request, response);
				return;
			} else {
				productos.setErrores("El producto no existe");
				request.setAttribute("productos", productos);
				rutaFormulario.forward(request, response);
			}
			break;
		case "borrar":
			dal.borrar(productos);
			rutaListado.forward(request, response);
			return;
		}
	}

}