package com.nm.exam3.grade.servlet;

import com.my.web.servlet.RequestBeanUtils;
import com.nm.exam3.grade.service.IGradeService;
import com.nm.exam3.grade.service.impl.GradeServiceImpl;
import com.nm.exam3.poji.Grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/grade/addGrade")
public class AddGrade extends HttpServlet {
    private IGradeService gradeService = new GradeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Grade grade = RequestBeanUtils.requestToBean(req, Grade.class);
        boolean b = gradeService.addGrade(grade);
        List<Grade> grades = gradeService.queryGrades(new Grade());
        if (b){
            req.setAttribute("tip", "添加班级成功");
        }else{
            req.setAttribute("tip", "添加班级失败");
        }
        req.setAttribute("queryGrades", grades);
        req.getRequestDispatcher("/view/grade/grade_list.jsp").forward(req, resp);
    }
}
