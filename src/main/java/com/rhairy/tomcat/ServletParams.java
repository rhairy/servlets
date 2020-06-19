package com.rhairy.tomcat; 

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

@WebServlet("/params")
public class ServletParams extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		if(name == null) {
			name = "";
		}
		resp.getWriter().println("Hello " + name);
	}
}
