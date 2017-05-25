package com.ipartek.formacion.catalogoapp.dal;

import java.util.HashMap;
import java.util.Map;

import com.ipartek.formacion.catalogoapp.tipos.Productos;

public class ProductosDALColeccion implements ProductosDAL {

	private Map<String, Productos> productos = new HashMap<String, Productos>();

	public void alta(Productos producto) {
		if (productos.containsKey(producto.getNombre()))
			throw new UsuarioYaExistenteDALException("Ya existe el producto "
					+ producto.getNombre());

		productos.put(producto.getNombre(), producto);
	}

	public boolean validar(Productos productos) {

		return productos.containsValue(productos);
	}

	public void modificar(Productos producto) {
		if (!productos.containsKey(producto.getNombre()))
			throw new DALException(
					"Intento de modificar producto no existente " + producto);

		productos.put(producto.getNombre(), producto);
	}

	public void borrar(Productos producto) {

		productos.remove(producto.getNombre());
	}

	public Productos buscarTodosLosProductosPorId(String id) {

		return productos.get(id);
	}

	public Productos[] buscarTodosLosProductos() {

		return productos.values().toArray(new Productos[productos.size()]);
	}

}
