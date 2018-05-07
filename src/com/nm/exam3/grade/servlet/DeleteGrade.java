package com.nm.exam3.grade.servlet;

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

@WebServlet("/grade/deleteGrade")
public class DeleteGrade extends HttpServlet {
    private IGradeService gradeService = new GradeServiceImpl();
    private IStudentService studentService = new StudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Grade grade = RequestBeanUtils.requestToBean(req, Grade.class);
        Student student = new Student();
        student.setcId(grade.getcId());
        List<Student> students = studentService.queryStudent(student);

        if (students.size()>0){
            req.setAttribute("tip", "该班级还有学生，不能删除！！！");

        }else {
            boolean b = gradeService.deleteGrade(grade.getcId());
            if (b){
                req.setAttribute("tip", "删除成功");
            }else{
                req.setAttribute("tip", "删除失败");
            }
        }
        List<Grade> grades = gradeService.queryGrades(new Grade());
        req.setAttribute("queryGrades", grades);
        req.setAttribute("allGrade", grades);
        req.getRequestDispatcher("/view/grade/grade_list.jsp").forward(req, resp);
    }
}
