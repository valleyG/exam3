package com.nm.exam3.student.servlet;

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

@WebServlet("/student/deleteStudent")
public class DeleteStudent extends HttpServlet {
    private IStudentService studentService = new StudentServiceImpl();
    private IGradeService gradeService = new GradeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sId = Integer.parseInt(req.getParameter("sId"));
        boolean flag = studentService.deleteStudent(sId);
        List<Student> students = studentService.queryStudent(new Student());
        List<Grade> grades = gradeService.queryGrades(new Grade());
        if (flag){
            req.setAttribute("tip", "删除成功");
        }else{
            req.setAttribute("tip", "删除失败");
        }
        req.setAttribute("students", students);
        req.setAttribute("grades", grades);
        req.getRequestDispatcher("/view/student/student_list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
