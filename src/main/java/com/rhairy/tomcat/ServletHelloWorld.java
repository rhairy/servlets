package com.rhairy.tomcat; 

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

@WebServlet("/hi")
public class ServletHelloWorld extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("HELP! I am trapped in this servlet! Send Help!");	
	}
}
