package com.ipartek.formacion.catalogoapp.dal;

import com.ipartek.formacion.catalogoapp.tipos.ProductoStockImagen;
//import com.ipartek.formacion.catalogoapp.tipos.Productos;

public interface ProductosDAL {

	public void altaProducto(ProductoStockImagen producto);

	public void modificarProducto(ProductoStockImagen producto);

	public void borrarProducto(ProductoStockImagen producto);

	public ProductoStockImagen buscarProductoPorId(String id);

	public ProductoStockImagen[] buscarTodosLosProductos();

	public boolean validarProducto(ProductoStockImagen producto);

}
