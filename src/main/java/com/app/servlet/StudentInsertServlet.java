package com.app.servlet;

import java.io.IOException;

import com.app.dao.IStudentDao;
import com.app.dao.impl.StudentDaoImpl;
import com.app.model.student.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insertStud")
public class StudentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. Read data from index.jsp
			String sid = request.getParameter("sid");
			String stdName = request.getParameter("sname");
			String sfee = request.getParameter("sfee");
			String sage = request.getParameter("age");
			String smob = request.getParameter("mob");

			// 2. Parse the data
			Integer stdId = Integer.parseInt(sid);
			double stdFee = Double.parseDouble(sfee);
			Integer age = Integer.parseInt(sage);
			long mob = Long.parseLong(smob); // ✅ CORRECT TYPE

			// 3. Create and populate Student object
			Student st = new Student();
			st.setStdId(stdId);
			st.setStdName(stdName);
			st.setStdFee(stdFee);
			st.setAge(age);
			st.setMob(mob);

			// 4. Save using DAO
			IStudentDao dao = new StudentDaoImpl();
			int resStd = dao.saveStudent(st);

			// 5. Final message
			//String msg = ;
			request.setAttribute("message", "Student '" + resStd + "' created successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Error: " + e.getMessage());
		}

		// 6. Forward to index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
