package com.CTS.DailyEntries;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DailyEntriesServlet")
public class DailyEntriesServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement s = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con=DBUtil.getConnection();
		SimpleDateFormat sdf=new SimpleDateFormat("mm/yyyy");
		sdf.setLenient(false);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DailyEntry de = new DailyEntry();
		de.setPatient_type(request.getParameter("Patient_type"));
		de.setDate(request.getParameter("Date"));
		de.setOpno(Integer.parseInt(request.getParameter("Opno")));
		de.setDrug1(request.getParameter("Drug1"));
		de.setNo_of_drug1(Integer.parseInt(request.getParameter("No_of_drug1")));
		de.setDrug2(request.getParameter("Drug2"));
		de.setNo_of_drug2(Integer.parseInt(request.getParameter("No_of_drug2")));
		
		System.out.println(de.getPatient_type());
		System.out.println(de.getOpno());
		System.out.println(de.getDate());
		System.out.println(de.getDrug1());
		System.out.println(de.getNo_of_drug1());
		System.out.println(de.getDrug2());
		System.out.println(de.getNo_of_drug2());
	}
	
	@Override
	public void destroy() 
	{
	try {
		con.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	try {
		s.close();
	} catch (SQLException e) 
	{
			e.printStackTrace();
		}
		super.destroy();
	}
}




