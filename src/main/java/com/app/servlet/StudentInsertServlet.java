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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String message;

        try {
            // 1. Read form parameters
            String sid = request.getParameter("sid");
            String stdName = request.getParameter("sname");
            String sfee = request.getParameter("sfee");
            String sage = request.getParameter("age");
            String smob = request.getParameter("mob");

            // 2. Validate inputs (basic check)
            if (sid == null || stdName == null || sfee == null || sage == null || smob == null ||
                sid.isEmpty() || stdName.isEmpty() || sfee.isEmpty() || sage.isEmpty() || smob.isEmpty()) {
                throw new IllegalArgumentException("All fields are required!");
            }

            // 3. Parse values
            Integer stdId = Integer.parseInt(sid);
            double stdFee = Double.parseDouble(sfee);
            Integer age = Integer.parseInt(sage);
            long mob = Long.parseLong(smob);

            // 4. Create Student object
            Student st = new Student();
            st.setStdId(stdId);
            st.setStdName(stdName);
            st.setStdFee(stdFee);
            st.setAge(age);
            st.setMob(mob);

            // 5. Save using DAO
            IStudentDao dao = new StudentDaoImpl();
            int rowsAffected = dao.saveStudent(st);

            if (rowsAffected > 0) {
                message = "✅ Student '" + stdName + "' created successfully!";
            } else {
                message = "⚠️ Failed to create student.";
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            message = "❌ Invalid number format: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            message = "❌ Error: " + e.getMessage();
        }

        // 6. Send message back to JSP
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
