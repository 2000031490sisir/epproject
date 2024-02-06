package com.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {
	
	Connection con=null;
	PreparedStatement ps=null;
	public List<Appointment> readData()
	{
		List<Appointment> l=new ArrayList<Appointment>();
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","atkurisisir");
			ps=con.prepareStatement("select * from appointment");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Appointment a=new Appointment();
				a.setPid(rs.getInt(1));
				a.setDate(rs.getString(2));
				a.setPurpose(rs.getString(3));
				l.add(a);
			}
			con.close();
		}
		catch(Exception e)
		{
			
		}
		return l;
	}
}
