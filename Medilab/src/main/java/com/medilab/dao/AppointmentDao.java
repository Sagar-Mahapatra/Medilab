package com.medilab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.medilab.entity.Appointment;

public class AppointmentDao {

	private Connection connection;
	private PreparedStatement prepareStatement;

	public AppointmentDao(Connection con) {
		this.connection = con;

	}

//insert data to DB
	public boolean saveAppointment(Appointment appointment) {

		boolean executed = false;

		String query = "insert into appointment(Patient_Name,Patient_Email,Patient_Contact,Appointment_Date,Department_Name,Doctor_Name,Message) values(?,?,?,?,?,?,?)";

		try {
			prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, appointment.getPatientName());
			prepareStatement.setString(2, appointment.getPatientEmail());
			prepareStatement.setString(3, appointment.getPatientContact());
			prepareStatement.setString(4, appointment.getAppointmentDate());
			prepareStatement.setString(5, appointment.getDepartmentName());
			prepareStatement.setString(6, appointment.getDoctorName());
			prepareStatement.setString(7, appointment.getMessage());

			prepareStatement.executeUpdate();
			executed = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return executed;

	}

}
