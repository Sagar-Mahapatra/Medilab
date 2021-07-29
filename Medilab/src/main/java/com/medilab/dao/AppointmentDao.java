package com.medilab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public void getAllAppointments() {

		List<Appointment> list = new ArrayList<Appointment>();

		Appointment appointment;

		String query = "select * from appointment";

		try {
			prepareStatement = connection.prepareStatement(query);
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("Patient_Id");
				String name = resultSet.getString("Patient_Name");
				String email = resultSet.getString("Patient_Email");
				String phone = resultSet.getString("Patient_Contact");
				String date = resultSet.getString("Appointment_Date");
				String department = resultSet.getString("Department_Name");
				String doctor = resultSet.getString("Doctor_Name");
				String message = resultSet.getString("Message");

				appointment = new Appointment(id, name, email, phone, date, department, doctor, message);
				list.add(appointment);

			}

			list.stream().filter(apntmnt -> Integer.parseInt(apntmnt.getAppointmentDate().substring(0, 1)) > 25)
					.forEach(a -> System.out.println(a));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
