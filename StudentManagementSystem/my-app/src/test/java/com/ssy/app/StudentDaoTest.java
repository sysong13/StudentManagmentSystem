package com.ssy.app;

import java.sql.SQLException;

import com.ssy.student.Student;
import com.ssy.student.StudentDAOImpl;

public class StudentDaoTest {
	static StudentDAOImpl dao = new StudentDAOImpl();
	public static void addTest(Student s) {
		try {
			dao.add(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteTest(Student s) {
		try {
			dao.delete(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void findByIdTest(int id) {
		Student s = null;
		try {
			s = dao.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student.StudentBuilder(21760241).name("ssy").age(23).sex("female").score(100).build();
		//addTest(s);
		findByIdTest(s.getId());
		//deleteTest(s);

	}

}
