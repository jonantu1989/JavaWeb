package com.ipartek.formacion.catalogoapp.dal;

import com.ipartek.formacion.catalogoapp.tipos.Usuario;

public class UsuarioDALUsuarioUnico implements UsuarioDAL {

	private Usuario usuario;

	public void alta(Usuario usuario) {
		if (this.usuario.getNombre().equals(usuario.getNombre()))
			throw new DALException("Ya existe un usuario con ese nombre: "
					+ usuario);

		this.usuario = usuario;
	}

	public boolean validar(Usuario usuario) {
		return this.usuario != null && this.usuario.equals(usuario);
	}

	public void modificar(Usuario usuario) {
		if (!this.usuario.getNombre().equals(usuario.getNombre()))
			throw new DALException(
					"No se ha encontrado el usuario a modificar " + usuario);
		this.usuario = usuario;

	}

	public void borrar(Usuario usuario) {
		if (this.usuario.equals(usuario))
			this.usuario = null;
	}

	public Usuario buscarPorID(String id) {

		return null;
	}

	public Usuario[] buscarTodosLosUsuarios() {

		return null;
	}

}
