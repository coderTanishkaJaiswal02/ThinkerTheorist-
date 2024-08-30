package com.thinkertheorist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addBlogs")
public class DashBoardServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		String comment =  request.getParameter("comment");
		  int uId =  Integer.parseInt((String) request.getParameter("uId"));
		  String uname =  request.getParameter("uname");
		  
		  try {
	        	
	            Connection con  = CommonMethod.getConnection();
	            System.out.println("Connection estatblish !!");
	            String insertQuery = "insert into blogs(blog,u_id) values(?,?)";
	            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
	                    preparedStatement.setString(1, comment);
	                    preparedStatement.setInt(2, uId);
	                    System.out.println(preparedStatement);
	                    int i = preparedStatement.executeUpdate();
	                    if(i>0)
	                    	request.setAttribute("msg", "Blogs Add SuccessFully !!");
	                    else 
	                    	request.setAttribute("msg", "Blogs Add SuccessFully !!");
	                    
	                    String[] blogsArray = CommonMethod.getblogsByUid(uId);
	                	 HttpSession session=request.getSession(false);  
	                     session.setAttribute("uname",uname); 
	                     session.setAttribute("uId", uId);
	                     session.setAttribute("blogs", blogsArray);
	                     RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");  
	                     request.setAttribute("uname", uname);
	                     request.setAttribute("uId",uId);
	                     request.setAttribute("blogs", blogsArray);
	                     rd.forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

}
