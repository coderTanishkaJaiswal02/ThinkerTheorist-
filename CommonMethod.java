package com.thinkertheorist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommonMethod {

	  public static Connection getConnection() throws ClassNotFoundException, SQLException {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/mysql_database", "root", "root");
		return connection;
	  }
	  
	  public static String[] getblogsByUid(int uId) {
		  try {

				Connection con = CommonMethod.getConnection();
				System.out.println("Connection estatblish !!");
				String insertQuery = "select * from blogs where u_id =? ";
				PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
				preparedStatement.setInt(1, uId);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				ArrayList<String> blogList = new ArrayList<String>();
				while(rs.next()) {
					String blog = rs.getString(2);
					blogList.add(blog);
				}
				
				return blogList.toArray(new String[0]);
		  	  }catch (Exception e) {
		  		  System.out.println("Exception occurs:"+e);
		  	  }
		  return null;
	  }
}
