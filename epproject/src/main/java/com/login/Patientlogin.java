package com.login;

import java.sql.*;

import com.model.Patient;

public class Patientlogin {
	
	public boolean validate(Patient pa) throws ClassNotFoundException {
        boolean status = false;

        //Class.forName("com.mysql.jdbc.Driver");
        Connection con=null;
        PreparedStatement ps=null;
        try 
        {
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","atkurisisir");
        	ps=con.prepareStatement("select * from patient where pid=? and pname=?");
            ps.setInt(1, pa.getPid());
            ps.setString(2, pa.getPname());

            //System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
