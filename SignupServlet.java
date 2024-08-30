package com.thinkertheorist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("Username");
        String password = request.getParameter("inputPassword");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        try {
        	
            Connection con  = CommonMethod.getConnection();
            System.out.println("Connection estatblish !!");
            String insertQuery = "insert into user_details(name,email,password,gender,username) values(?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, gender);
                    preparedStatement.setString(5, username);
                    System.out.println(preparedStatement);
                    int i = preparedStatement.executeUpdate();
                    if(i>0)
                    	 response.sendRedirect("login.jsp");
                    else 
                    	response.sendRedirect("home.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
