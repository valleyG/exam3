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

@WebServlet("/student/updateStudent")
public class UpdateStudent extends HttpServlet {
    private IStudentService studentService = new StudentServiceImpl();
    private IGradeService gradeService = new GradeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = RequestBeanUtils.requestToBean(req, Student.class);
        boolean flag = studentService.updateStudent(student);
        List<Student> students = studentService.queryStudent(new Student());
        List<Grade> grades = gradeService.queryGrades(new Grade());
        if (flag){
            req.setAttribute("tip", "修改成功");
        }else{
            req.setAttribute("tip", "修改失败");
        }
        req.setAttribute("students", students);
        req.setAttribute("grades", grades);
        req.getRequestDispatcher("/view/student/student_list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer sId =Integer.parseInt( req.getParameter("sId"));
        Student student = new Student();
        student.setsId(sId);
        Student currentStudent = studentService.queryStudent(student).get(0);
        List<Grade> grades = gradeService.queryGrades(new Grade());
        req.setAttribute("currentStudent", currentStudent);
        req.setAttribute("grades", grades);
        req.getRequestDispatcher("/view/student/student_update.jsp").forward(req, resp);
    }
}
