package com.ipartek.formacion.catalogoapp.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.catalogoapp.dal.DALFactoryProductos;
import com.ipartek.formacion.catalogoapp.dal.ProductosDAL;
import com.ipartek.formacion.catalogoapp.tipos.Productos;

public class TiendaCatalogoAppCrudServlet extends HttpServlet {
	static final String RUTA_FORMULARIO = "/WEB-INF/vistas/tiendaform.jsp";
	static final String RUTA_LISTADO = "/WEB-INF/vistas/tiendacrud.jsp";
	static final String RUTA_SERVLET_LISTADO = "/tienda";

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();

		ProductosDAL dal = (ProductosDAL) application.getAttribute("dal");
		if (dal == null) {
			dal = DALFactoryProductos.getProductosDAL();
			dal.alta(new Productos("1", "nombre1", "descripcion1", 50));
			dal.alta(new Productos("2", "nombre2", "descripcion2", 100));
			application.setAttribute("dal", dal);
		}

		String op = request.getParameter("op");

		if (op == null) {

			Productos[] productos = dal.buscarTodosLosProductos();

			request.setAttribute("productos", productos);

			request.getRequestDispatcher(RUTA_LISTADO).forward(request,
					response);
			return;

		} else {

			String id = request.getParameter("id");

			Productos productos;

			switch (op) {
			case "modificar":
			case "borrar":
				productos = dal.buscarTodosLosProductosPorId(id);
				request.setAttribute("productos", productos);
			case "alta":

				request.getRequestDispatcher(RUTA_FORMULARIO).forward(request,
						response);

				break;
			default:

				request.getRequestDispatcher(RUTA_LISTADO).forward(request,
						response);
				return;
			}

		}
	}
}