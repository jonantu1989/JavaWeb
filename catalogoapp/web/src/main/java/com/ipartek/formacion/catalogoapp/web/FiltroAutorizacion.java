package com.ipartek.formacion.catalogoapp.web;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "admin/" })
public class FiltroAutorizacion implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Has entrado como administrador");
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
