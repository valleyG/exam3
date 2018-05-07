package com.nm.exam3.grade.servlet;

import com.my.web.servlet.RequestBeanUtils;
import com.nm.exam3.grade.service.IGradeService;
import com.nm.exam3.grade.service.impl.GradeServiceImpl;
import com.nm.exam3.poji.Grade;
import com.nm.exam3.poji.Student;
import com.nm.exam3.student.service.IStudentService;
import com.nm.exam3.student.service.impl.StudentServiceImpl;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/grade/queryGrades")
public class QueryGrades extends HttpServlet {
    private IGradeService gradeService = new GradeServiceImpl();
    private IStudentService studentService = new StudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = RequestBeanUtils.requestToBean(req, Student.class);

        Grade grade = RequestBeanUtils.requestToBean(req, Grade.class);
        List<Grade> queryGrades = gradeService.queryGrades(grade);
        List<Grade> allGrades = gradeService.queryGrades(new Grade());
        req.setAttribute("condition", student);
        req.setAttribute("queryGrades", queryGrades);
        req.setAttribute("grades", allGrades);
        req.getRequestDispatcher("/view/grade/grade_list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
