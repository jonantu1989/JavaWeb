package com.ipartek.formacion.catalogoapp.dal;

public class UsuarioDALFactory {
	public static UsuarioDAL getUsuariosDAL() {
		// return new UsuariosDALUsuarioUnico();
		return new UsuarioDALColeccion();
	}
}


