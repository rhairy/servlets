package com.rhairy.tomcat; 

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

@WebServlet("/post")
public class ServletPost extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");

		if(firstName != null && lastName != null) {
			resp.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
