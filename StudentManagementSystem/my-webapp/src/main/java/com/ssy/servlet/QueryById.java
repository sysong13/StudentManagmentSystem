package com.ssy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ssy.student.Student;
import com.ssy.student.StudentDAOImpl;

/**
 * Servlet implementation class QueryById
 */
@WebServlet("/QueryById")
public class QueryById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAOImpl dao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		dao = new StudentDAOImpl();
		Student stu = null;
		try {
		    stu = dao.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = null;
		if(stu == null) {
			out.write("error");
			return ;
		}
		String json = JSON.toJSONString(stu);
		out.write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
