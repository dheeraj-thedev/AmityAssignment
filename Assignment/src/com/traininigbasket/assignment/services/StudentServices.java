package com.traininigbasket.assignment.services;

import com.traininigbasket.assignment.beans.Student;
import com.traininigbasket.assignment.dao.StudentDAO;

public class StudentServices {
StudentDAO dao;
	public StudentServices() {
	dao= new StudentDAO();
	}
	public int saveStudent(Student student) {
		return dao.saveStudent(student);
	}
	
	
}
