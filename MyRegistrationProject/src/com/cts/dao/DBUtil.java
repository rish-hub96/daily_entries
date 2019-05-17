package com.cts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil 
{
	static Connection con = null;

		public static Connection getConnection()
		{
		
		try   // oracle.jdbc.driver.OracleDriver
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
		} 
		catch (ClassNotFoundException e) 
		{
				//e.printStackTrace();
				System.out.println("db eror"+e.toString());
		} catch (SQLException e) 
		{
			
			System.out.println("db eror"+e.toString());
				//e.printStackTrace();
		}
		
		
			return con;
		}
}
  