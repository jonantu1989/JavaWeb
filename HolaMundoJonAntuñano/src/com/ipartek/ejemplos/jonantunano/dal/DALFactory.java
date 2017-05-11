package com.ipartek.ejemplos.jonantunano.dal;

public class DALFactory {
	public static UsuarioDAL getUsuarioDAL() {
		// return new UsuarioDALFijo();
		return new UsuarioDALColeccion();
	}
}
