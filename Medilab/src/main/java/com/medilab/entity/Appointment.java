package com.medilab.entity;

public class Appointment {

	private int patientId;
	private String patientName;
	private String patientEmail;
	private String patientContact;
	private String appointmentDate;
	private String departmentName;
	private String doctorName;
	private String message;
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Appointment(int patientId, String patientName, String patientEmail, String patientContact,
			String appointmentDate, String departmentName, String doctorName, String message) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientContact = patientContact;
		this.appointmentDate = appointmentDate;
		this.departmentName = departmentName;
		this.doctorName = doctorName;
		this.message = message;
	}


	public Appointment(String patientName, String patientEmail, String patientContact, String appointmentDate,
			String departmentName, String doctorName, String message) {
		super();
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientContact = patientContact;
		this.appointmentDate = appointmentDate;
		this.departmentName = departmentName;
		this.doctorName = doctorName;
		this.message = message;
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getPatientEmail() {
		return patientEmail;
	}


	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}


	public String getPatientContact() {
		return patientContact;
	}


	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}


	public String getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "Appointment [patientId=" + patientId + ", patientName=" + patientName + ", patientEmail=" + patientEmail
				+ ", patientContact=" + patientContact + ", appointmentDate=" + appointmentDate + ", departmentName="
				+ departmentName + ", doctorName=" + doctorName + ", message=" + message + "]";
	}
	
	
	
	

	

}
