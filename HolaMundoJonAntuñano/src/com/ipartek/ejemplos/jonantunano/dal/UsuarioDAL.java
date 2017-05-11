package com.ipartek.ejemplos.jonantunano.dal;

import com.ipartek.ejemplos.jonantunano.tipos.Usuario;

public interface UsuarioDAL {

	public void alta(Usuario usuario);

	public void modificar(Usuario usuario);

	public void borrar(Usuario usuario);

	public Usuario buscarPorID(String id);

	public Usuario[] buscarTodosLosUsuarios();

	public boolean validar(Usuario usuario);

}
