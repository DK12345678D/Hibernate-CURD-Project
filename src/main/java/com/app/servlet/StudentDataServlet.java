package com.app.servlet;

import java.io.IOException;
import java.util.List;

import com.app.dao.IStudentDao;
import com.app.dao.impl.StudentDaoImpl;
import com.app.model.student.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/StudData")
public class StudentDataServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//1. create object to POJI-POJO
		IStudentDao dao = new StudentDaoImpl();
//2. call get operation
		List<Student> st = dao.getAllStud();
//3. add list to request memory
		request.setAttribute("list", st);
//4. dispatch to UI
		request.getRequestDispatcher("Data.jsp").forward(request, response);
		
//		try {
//			IStudentDao dao = new StudentDaoImpl();
//			List<Student> students = dao.getAllStud();
//			request.setAttribute("students", students);
//			request.getRequestDispatcher("Data.jsp").forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("message", "Error loading students.");
//			request.getRequestDispatcher("error.jsp").forward(request, response);
//		}

	}
}