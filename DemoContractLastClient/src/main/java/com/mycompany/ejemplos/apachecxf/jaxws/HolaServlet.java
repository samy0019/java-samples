package com.mycompany.ejemplos.apachecxf.jaxws;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet de pruebas que utiliza un cliente Web Service.
 * 
 * @author joedayz
 * 
 */
public class HolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Interface del Web Service, la implementaci—n se obtiene del
	 * ApplicationContext de Spring.
	 */
	private Hola hola;

	/**
	 * No se puede hacer inyecci—n de dependencias desde un Servlet, aqu’ se
	 * obtiene la implementaci—n de la interface del ApplicationContext de
	 * Spring.
	 */
	@Override
	public void init() throws ServletException {
		this.hola = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext()).getBean(
						"hola", Hola.class);
	}

	/**
	 * En una petici—n GET el Servlet llama al Web Service y setea la respuesta
	 * para ser mostrada en el JSP.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", hola.saludar("Pepe"));
		request.getRequestDispatcher("/WEB-INF/jsp/helloWorld.jsp").forward(
				request, response);
	}
}
