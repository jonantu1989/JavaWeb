package com.ipartek.formacion.catalogoapp.dal;

public class DALFactoryProductos {
	public static ProductosDAL getProductosDAL() {
		return new ProductosDALColeccion();
	}

}
