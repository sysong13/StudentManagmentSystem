package com.ssy.student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
	
	public List<Student> findByName(String name) throws SQLException;
	
	public Student findById(int id) throws SQLException;
	/**
	 * @param s Ҫ��ӵ�Student
	 * @return ��ӳɹ�����Student��ʧ���򷵻�null
	 * @throws SQLException
	 */
	public Student add(Student s) throws SQLException;
	
	/**
	 * @param oldStu ԭStudent
	 * @param newStu ���µ�Student
	 * @return	�ɹ����ظ��º��Student,ʧ�ܷ���null
	 */
	public Student update(Student oldStu, Student newStu) throws SQLException;
	
	public Student delete(Student s) throws SQLException;
	
	public List<Student> findAll() throws SQLException;

}
