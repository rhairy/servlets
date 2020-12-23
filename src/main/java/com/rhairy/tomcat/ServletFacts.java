/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhairy.tomcat;

import javax.servlet.http.HttpServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 

import java.util.Properties;

/**
 *
 * @author rhair
 */
@WebServlet("/facts")
public class ServletFacts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection con = SqlConnect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from facts");
            rs.next();
            resp.getWriter().println(rs.getString(2));
        }
        catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
    
    private Connection SqlConnect() throws Exception {
        InputStream input = ServletFacts.class.getClassLoader().getResourceAsStream("factsDB.properties");
        Properties p = new Properties();
        p.load(input);
        
        String dname = (String) p.get ("Dname"); 
        String url = (String) p.get ("URL"); 
        String username = (String) p.get ("Uname"); 
        String password = (String) p.get ("password"); 
        Class.forName(dname); 
        Connection con = DriverManager.getConnection( 
                url, username, password); 

        return con;
    }
}
