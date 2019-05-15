package com.CTS.DailyEntries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.CTS.DailyEntries.*;

public class DBUtil 
{
	static Connection con = null;

		public static Connection getConnection()
		{
		try 
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password123");
		} catch (ClassNotFoundException e) 
		{
				e.printStackTrace();
		} catch (SQLException e) 
		{
				e.printStackTrace();
		}
			return con;
		}
	}
  