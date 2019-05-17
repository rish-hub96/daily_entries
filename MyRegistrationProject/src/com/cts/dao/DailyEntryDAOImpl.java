package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cts.bean.DailyEntry;

public class DailyEntryDAOImpl implements DailyEntryDAO
{

	Connection con = null;
	PreparedStatement s = null;

	public DailyEntryDAOImpl() {
		con=DBUtil.getConnection();
	}

	@Override
	public boolean addRecords(DailyEntry de)
	{
		System.out.println("inside DAO:  " + de.getOpno());
		int result=0;
		try
		{
		
	    s=con.prepareStatement("insert into TABLE_DAILY_ENTRIES values(?,?,?,?,?,?,?)");
	    
		s.setString(1, de.getOpno());
	    s.setString(2, de.getPatient_type());
		s.setDate(3, de.getDate());
		s.setString(4,de.getDrug1());
		s.setInt(5,de.getNo_of_drug1());
		s.setString(6,de.getDrug2());
		s.setInt(7,de.getNo_of_drug2());
		
		result = s.executeUpdate();
		
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
    	}
		
		if (result==0)
		return false;
		else
		return true;
		
   }

		}
		
	

