package com.ssy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ssy.student.Student;
import com.ssy.student.StudentDAOImpl;

/**
 * Servlet implementation class QueryAll
 */
@WebServlet("/QueryAll")
public class QueryAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAOImpl dao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		dao = new StudentDAOImpl();
		List<Student> list = null;
		//JSONArray jsonArray = new JSONArray();
		try {
			list = dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list==null||list.size()==0) {
			out.write("error");
			return;
		}
		String json = JSON.toJSONString(list);
		System.out.println(json);
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
