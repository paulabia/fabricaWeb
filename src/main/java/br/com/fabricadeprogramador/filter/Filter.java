package br.com.fabricadeprogramador.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes={DispatcherType.REQUEST}, urlPatterns="/*")
public class Filter implements javax.servlet.Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		String uri = httpServletRequest.getRequestURI();
		HttpSession sessao = httpServletRequest.getSession(false); 
		
		if(sessao!=null || uri.lastIndexOf("login.html")!=-1 || uri.lastIndexOf("autenticar")!=-1){
			chain.doFilter(request, response); // significa siga em frente
		}else{
			httpServletResponse.sendRedirect("login.html");
		}
	}

	
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
