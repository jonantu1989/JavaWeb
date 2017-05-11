package com.ipartek.ejemplos.jonantunano.dal;

public class DALFactoryProductos {
	public static ProductosDAL getProductosDAL() {
		return new ProductosDALColeccion();
	}

}
