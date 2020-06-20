package com.rhairy.tomcat; 

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import java.util.Locale;

import javax.servlet.ServletContext;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/context")
public class ServletContainerContext extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext cxt = req.getServletContext();

		int tempCount =1;
		
		Object att = cxt.getAttribute("counter");

		if (att != null) {
			AtomicInteger count = (AtomicInteger)att;
			tempCount = count.incrementAndGet();
		} else {
			AtomicInteger count = new AtomicInteger(1);
			cxt.setAttribute("counter", count);
		}
		resp.getWriter().println("Servlet Count = " + tempCount);
	}
}
