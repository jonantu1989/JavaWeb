package com.ipartek.ejemplos.jonantunano.dal;

import com.ipartek.ejemplos.jonantunano.tipos.Productos;

public interface ProductosDAL {

	public void alta(Productos producto);

	public void modificar(Productos producto);

	public void borrar(Productos producto);

	public Productos buscarTodosLosProductosPorId(String id);

	public Productos[] buscarTodosLosProductos();

	public boolean validar(Productos productos);

}
