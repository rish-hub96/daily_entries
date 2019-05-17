package com.cts.dao;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;


public class DBConnection {

	public static Connection getDBConnection()
	{

		System.out.println("dosdf ");
		
		Connection con = null;
		

		try   // oracle.jdbc.driver.OracleDriver
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
		System.out.println("connection estb");
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
		
		if(con!=null)
		{
			System.out.println("connection done ");
		}
		
		
		return con;
		

	}

}
