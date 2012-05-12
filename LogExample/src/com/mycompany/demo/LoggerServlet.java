package com.mycompany.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoggerServlet
 */
@WebServlet("/LoggerServlet")
public class LoggerServlet extends HttpServlet {
	 
	 private static org.apache.log4j.Logger logger = 
		        org.apache.log4j.Logger.getLogger(LoggerServlet.class);
    /**
     * Default constructor. 
     */
    public LoggerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		logger.info("System variable myproperty="+System.getProperty("myproperty"));
		PrintWriter out = response.getWriter();
		out.println("The Servlet just logged.");	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
