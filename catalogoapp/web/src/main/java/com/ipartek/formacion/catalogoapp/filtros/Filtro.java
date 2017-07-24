package com.ipartek.formacion.catalogoapp.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filtro implements Filter {

	public void init(FilterConfig filterConfig, FilterConfig fConfig)
			throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// acción de inicio de sesión previa
		// obtener nombre de usuario
		String username = req.getParameter("usuario");

		// sacar la url.
		String uri = req.getRequestURI(); // "/...."

		if (username == null
				&& !(uri.equals("/login") || uri
						.equals("/WEB-INF/vistas/login.jsp"))) {
			res.sendRedirect("/login");

		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}