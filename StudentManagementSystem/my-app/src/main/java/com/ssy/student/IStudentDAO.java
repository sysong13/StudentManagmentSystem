package com.ssy.student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
	
	public List<Student> findByName(String name) throws SQLException;
	
	public Student findById(int id) throws SQLException;
	/**
	 * @param s 要添加的Student
	 * @return 添加成功返回Student，失败则返回null
	 * @throws SQLException
	 */
	public Student add(Student s) throws SQLException;
	
	/**
	 * @param oldStu 原Student
	 * @param newStu 更新的Student
	 * @return	成功返回更新后的Student,失败返回null
	 */
	public Student update(Student oldStu, Student newStu) throws SQLException;
	
	public Student delete(Student s) throws SQLException;
	
	public List<Student> findAll() throws SQLException;

}
