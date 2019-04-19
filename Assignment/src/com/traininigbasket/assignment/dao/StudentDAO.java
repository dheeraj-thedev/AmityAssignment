package com.traininigbasket.assignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.traininigbasket.assignment.beans.Student;

public class StudentDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";
	Connection conn = null;
	Statement stmt = null;

	public StudentDAO() {

	}

	List<Student> students = new ArrayList<Student>();

	public List<Student> getAllStudent() {
		int status = 110;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("select records from the table...");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM students.studentinfo;";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
		         //Retrieve by column name
				Student student = new Student(); 
				student.setStudentId(rs.getInt("ID"));
		         student.setStudentName( rs.getString("name"));
		       
		         student.setDepartment(rs.getString("department"));
		         
		         students.add(student);
		      }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return students;
	}

	public int saveStudent(Student student) {
		int status = 110;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();

			String sql = "INSERT INTO `students`.`studentinfo`(`name`,`department`) " + " VALUES ( '"
					+ student.getStudentName() + "', '" + student.getDepartment() + "')";
			status = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return status;
		}
		return status;
	}

	public static void main(String[] args) {
		Student s = new Student();
		s.setStudentName("raman");
		s.setDepartment("pawan");
		System.out.println(new StudentDAO().saveStudent(s));

	}
}
