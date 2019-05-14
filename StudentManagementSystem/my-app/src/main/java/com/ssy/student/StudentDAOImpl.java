package com.ssy.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssy.student.Student.StudentBuilder;
import com.ssy.util.db.DBUtils;

public class StudentDAOImpl implements IStudentDAO {

	@Override
	public List<Student> findByName(String name) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StudentBuilder sb = null;
		Student s = null;
		List<Student> ls = new ArrayList<>();
		String sql = "select id,age,sex,score from student where name = ?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				sb = new StudentBuilder(rs.getInt(1));
				s = sb.age(rs.getInt(2)).sex(rs.getString(3)).score(rs.getInt(4))
						.name(name).build();
				ls.add(s);
			}
		}catch(SQLException e) {
			throw new SQLException("查询学生:" + name + "信息失败");
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return ls;
	}

	@Override
	public Student findById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StudentBuilder sb = null;
		Student s = null;
		String sql = "select name,age,sex,score from student where id = ?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				sb = new StudentBuilder(id);
				s = sb.name(rs.getString(1))
						.age(rs.getInt(2))
						.sex(rs.getString(3))
						.score(rs.getInt(4))
						.build();
			}
		}catch(SQLException e) {
				throw new SQLException("查询学生id:" + id + " 信息失败");
		}finally {
				DBUtils.close(rs, ps, conn);
		}

		return s;
	}

	@Override
	public Student add(Student s) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into student(name,id,age,sex,score) values(?,?,?,?,?)";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getId());
			ps.setInt(3, s.getAge());
			ps.setString(4, s.getSex());
			ps.setInt(5, s.getScore());
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new SQLException("添加数据失败");
		}finally {
			DBUtils.close(null, ps, conn);
		}
		return s;
	}

	@Override
	public Student update(Student oldStu, Student newStu) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update student set name=?,age=?,sex=?,score=? where id=?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newStu.getName());
			ps.setInt(2, newStu.getAge());
			ps.setString(3, newStu.getSex());
			ps.setInt(4, newStu.getScore());
			ps.setInt(5, oldStu.getId());
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new SQLException("更新数据失败");
		}finally {
			DBUtils.close(null, ps, conn);
		}
		return newStu;
	}

	@Override
	public Student delete(Student s) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from student where id=?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			throw new SQLException("删除数据失败");
		}finally {
			DBUtils.close(null, ps, conn);
		}
		return s;
	}

	@Override
	public List<Student> findAll() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StudentBuilder sb = null;
		Student s = null;
		List<Student> ls = new ArrayList<>();
		String sql = "select * from student";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				sb = new StudentBuilder(rs.getInt(2));
				s = sb.age(rs.getInt(3)).sex(rs.getString(4)).score(rs.getInt(5))
						.name(rs.getString(1)).build();
				ls.add(s);
			}
		}catch(SQLException e) {
			throw new SQLException("查询学生信息失败");
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return ls;
	}

}
