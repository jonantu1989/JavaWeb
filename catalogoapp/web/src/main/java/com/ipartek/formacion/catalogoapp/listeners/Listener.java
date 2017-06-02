package com.ipartek.formacion.catalogoapp.listeners;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
public class Listener implements ServletContextListener, HttpSessionListener,
		HttpSessionActivationListener, ServletRequestListener {

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {

	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {

	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("NUEVO USUARIO");
		se.getSession().setAttribute("carrito", new ArrayList<String>());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ARRANQUE DE APLICACION");
		sce.getServletContext().setAttribute("productos",
				new ArrayList<String>());

	}

}
