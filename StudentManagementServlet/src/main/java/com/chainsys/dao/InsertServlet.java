package com.chainsys.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dto.TeacherDb;
import com.chainsys.model.Student;
import com.chainsys.model.Teacher;
import com.studentcrud.util.Connectionutil;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests if necessary
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int attendance = Integer.parseInt(request.getParameter("attendance"));
        String standard = request.getParameter("standard");

        // Get the session, but do not create a new one if it doesn't exist
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            String studentClass = (String) session.getAttribute("teacherClass");
            if (studentClass != null) {
                try {
                    Teacher teacher = TeacherDb.findTeacherDetails(studentClass);
                    insertValues(name, attendance, 0, 0, standard, studentClass, teacher.getName(), teacher.getTeacherName(), 0, 0);
                    response.sendRedirect("studentTable.jsp");
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Student class attribute is missing in session.");
            }
        } else {
            System.out.println("Session is not available.");
        }
    }

    public static void insertValues(String studentName, int atttendence, int studentRank, int quaterYearly, String standard,
            String studentClass, String mentorName, String teacherusername, int halfYearly, int annualExam) throws SQLException, ClassNotFoundException {
        Connection connection = Connectionutil.getConnections();
        String query = "INSERT INTO Student (studentName, attendence, studentRank, total, standard, studentClass, mentorName, teacher_username, half_yearly, Annual_yearly) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, studentName);
        statement.setInt(2, atttendence);
        statement.setInt(3, studentRank);
        statement.setInt(4, quaterYearly);
        statement.setString(5, standard);
        statement.setString(6, studentClass);
        statement.setString(7, mentorName);
        statement.setString(8, teacherusername);
        statement.setInt(9, halfYearly);
        statement.setInt(10, annualExam);
        int execute = statement.executeUpdate();
        System.out.println(execute);
        connection.close();
    }
}

