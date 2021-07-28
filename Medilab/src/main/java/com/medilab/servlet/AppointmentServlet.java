package com.medilab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medilab.dao.AppointmentDao;
import com.medilab.dao.ConnectionProvider;
import com.medilab.entity.Appointment;

/**
 * Servlet implementation class AppointmentServlet
 */
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppointmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Appointment appointment;
		AppointmentDao appointmentDao = null;

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String date = request.getParameter("date");
		String department = request.getParameter("department");
		String doctor = request.getParameter("doctor");
		String message = request.getParameter("message");

		appointment = new Appointment();
		appointment.setPatientName(name);
		appointment.setPatientEmail(email);
		appointment.setPatientContact(phone);
		appointment.setAppointmentDate(date);
		appointment.setDepartmentName(department);
		appointment.setDoctorName(doctor);
		appointment.setMessage(message);

		try {
			appointmentDao = new AppointmentDao(ConnectionProvider.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean saveAppointment = appointmentDao.saveAppointment(appointment);

		HttpSession httpSession = request.getSession();

		if (saveAppointment) {

			httpSession.setAttribute("message", "Appointment successful on " + appointment.getAppointmentDate());
			System.out.println("if... ");
			response.sendRedirect("index.jsp");

		} else {

			httpSession.setAttribute("message", "something went wrong!!! please try again...");
			System.out.println("else...");
			response.sendRedirect("index.jsp");

		}

	}

}
