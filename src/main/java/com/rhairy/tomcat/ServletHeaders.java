package com.rhairy.tomcat; 

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import java.util.Locale;

@WebServlet("/headers")
public class ServletHeaders extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		if(name == null) {
			name = "";
		}
		Locale locale = req.getLocale();
		String languageTag = locale.toLanguageTag();

		String[] language = languageTag.split("-");

		resp.getWriter().println(languageTag);

		String greeting = null;
		switch(language[0]) {
			case "fil":
				greeting = "Helo";
				break;
			case "es":
				greeting = "Hola";
				break;
			default:
				greeting = "Hello";
				languageTag = "en";
		}
		
		resp.setHeader("Content-Language", languageTag);
		resp.getWriter().println(greeting + " " + name);
	}
}
