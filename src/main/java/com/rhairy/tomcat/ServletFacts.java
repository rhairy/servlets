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

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 


/**
 *
 * @author rhair
 */
@WebServlet("/facts")
public class ServletFacts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.getWriter().println(getRandomFact());
        }
        catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
    
    private String getRandomFact() throws Exception {
        String fact;
        
        Connection con = sqlConnect();
        
        Statement stmt = con.createStatement();
        ResultSet results = stmt.executeQuery("SELECT fact FROM facts ORDER BY RANDOM() LIMIT 1");
        results.next();
        
        fact = results.getString(1);
        return fact;
    }
    
    private Connection sqlConnect() throws Exception {
        String dbName = System.getenv("RDS_DB_NAME");
        String userName = System.getenv("RDS_USERNAME");
        String password = System.getenv("RDS_PASSWORD");
        String hostname = System.getenv("RDS_HOSTNAME");
        String port = System.getenv("RDS_PORT");
        String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
        
        // Declare and load Postgresql driver class.
        String dname = "org.postgresql.Driver";
        Class.forName(dname); 
        
        Connection con = DriverManager.getConnection(jdbcUrl); 

        return con;
    }
}
