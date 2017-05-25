package com.ipartek.formacion.catalogoapp.dal;

import com.ipartek.formacion.catalogoapp.tipos.Productos;

public interface ProductosDAL {

	public void alta(Productos producto);

	public void modificar(Productos producto);

	public void borrar(Productos producto);

	public Productos buscarTodosLosProductosPorId(String id);

	public Productos[] buscarTodosLosProductos();

	public boolean validar(Productos productos);

}
