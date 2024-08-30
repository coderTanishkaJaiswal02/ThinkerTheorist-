package com.thinkertheorist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("Username");
        String password = request.getParameter("inputPassword");
        try {
            Connection con  = CommonMethod.getConnection();
            System.out.println("Connection estatblish !!");
            String insertQuery = "select * from user_details where username = ? and password = ? ";
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
            	preparedStatement.setString(1, username);    
            	preparedStatement.setString(2, password);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                	 String[] blogsArray = CommonMethod.getblogsByUid(rs.getInt(1));
                	 HttpSession session=request.getSession(false);  
                     session.setAttribute("uname",rs.getString(2)); 
                     session.setAttribute("uId", rs.getInt(1));
                     session.setAttribute("blogs", blogsArray);
                     RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");  
                     request.setAttribute("uname", rs.getString(2));
                     request.setAttribute("uId", rs.getInt(1));
                     request.setAttribute("blogs", blogsArray);
                     rd.forward(request, response);
                }else {
                	
                	response.sendRedirect("login.jsp");
                }
                   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
