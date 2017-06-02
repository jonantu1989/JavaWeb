package com.ipartek.formacion.catalogoapp.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.catalogoapp.dal.DALFactoryProductos;
import com.ipartek.formacion.catalogoapp.dal.ProductosDAL;
import com.ipartek.formacion.catalogoapp.rutas.Rutas;
import com.ipartek.formacion.catalogoapp.tipos.ProductoStockImagen;

public class TiendaCatalogoAppCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * LLamamos a una funcion doPost.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * 
	 * Metodo doPost....
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// Primero recogemos los datos...??
		ServletContext applicationProductos = getServletContext();
		ProductosDAL dalProductos = (ProductosDAL) applicationProductos.getAttribute("dalProductos");

		// Las operaciones.
		// TODO hacerlo:
		// https://github.com/ipartek/JavaServidorTardes/blob/master/HolaMundo/src/com/ipartek/ejemplos/javierlete/controladores/UsuarioCRUDServlet.java

		// Miramos que la dalProductos no este vacia.
		if (dalProductos == null) {

			dalProductos = DALFactoryProductos.getProductosDAL();

			// Creamos unos productos de prueba.
			// dalProductos.altaProducto(new ProductoStockImagen());

			applicationProductos.setAttribute("dalProductos", dalProductos);
		}

		// Creamos op.
		String op = request.getParameter("op");

		if (op == null) {

			ProductoStockImagen[] productos = dalProductos.buscarTodosLosProductos();
			request.setAttribute("productos", productos);
			request.getRequestDispatcher(Rutas.RUTA_LISTADO).forward(request, response);
		} else {

			String id = request.getParameter("id");

			ProductoStockImagen producto;

			switch (op) {
			case "modificar":
			case "borrar":
				producto = dalProductos.buscarProductoPorId(id);
				request.setAttribute("producto", producto);
			case "alta":
				request.getRequestDispatcher(Rutas.RUTA_FORMULARIO).forward(request, response);
				break;
			default:
				request.getRequestDispatcher(Rutas.RUTA_LISTADO).forward(request, response);
			}
		}
	}
}
