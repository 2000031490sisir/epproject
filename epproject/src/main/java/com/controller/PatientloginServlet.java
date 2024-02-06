package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Patientlogin;
import com.model.Patient;

@WebServlet("/login")
public class PatientloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Patientlogin pl;
    public void init()
    {
    	pl =new Patientlogin();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int pid = Integer.parseInt(request.getParameter("pid"));
        String  pname= request.getParameter("pname");
        Patient P=new Patient();
        P.setPid(pid);
        P.setPname(pname);

        try 
        {
            if (pl.validate(P)) 
            {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("loginsuccess.jsp");
            }
            else 
            {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
                response.sendRedirect("loginfailure.jsp");
            }
        } catch (ClassNotFoundException e) 
        {
        	System.out.println(e.getMessage());
        }
	}

}
