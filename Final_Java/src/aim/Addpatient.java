package aim;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.*;
import entities.*;

@WebServlet("/Addpatient")
public class Addpatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Addpatient() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		business.Controller ctrl = new Controller();
		String name=request.getParameter("name");
		String surname = request.getParameter("surname");
		String affiliateNHP = request.getParameter("affiliateNHP");
	    String birthdate = request.getParameter("birthdate");
		
	    Patient patient = new Patient();
	    patient.setname(name);
	    patient.setsurname(surname);
	    //patient.setbirthdate(birthdate);
	    patient.setaffiliateNumberHP(Integer.parseInt(affiliateNHP));
	   ctrl.addPatient(patient);
	    
		
			
			//HttpSession session = request.getSession(true);
			//session.setAttribute("userSession", patient);
			//request.getRequestDispatcher(".jsp").forward(request, response);
		
			System.out.println("Patient Added!");
			response.sendRedirect("addpatient.jsp");
		}
	}
