package com.ipartek.formacion.catalogoapp.dal;

public class DALFactory {
	public static UsuarioDAL getUsuarioDAL() {
		// return new UsuarioDALFijo();
		return new UsuarioDALColeccion();
	}
}
