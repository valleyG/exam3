package com.nm.exam3.student.servlet;

import com.my.web.servlet.RequestBeanUtils;
import com.nm.exam3.grade.service.IGradeService;
import com.nm.exam3.grade.service.impl.GradeServiceImpl;
import com.nm.exam3.poji.Grade;
import com.nm.exam3.poji.Student;
import com.nm.exam3.student.service.IStudentService;
import com.nm.exam3.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/queryStudent")
public class QueryStudent extends HttpServlet {
    private IStudentService studentService= new StudentServiceImpl();
    private IGradeService gradeService = new GradeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = RequestBeanUtils.requestToBean(req, Student.class);
        List<Student> students = studentService.queryStudent(student);
        List<Grade> grades = gradeService.queryGrades(new Grade());
        req.setAttribute("students", students);
        req.setAttribute("grades", grades);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/view/student/student_list.jsp").forward(req, resp);
    }
}
