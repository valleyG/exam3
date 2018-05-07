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

@WebServlet("/grade/updateGrade")
public class UpdateGrade extends HttpServlet{
    private IGradeService gradeService = new GradeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Grade grade = RequestBeanUtils.requestToBean(req, Grade.class);
        List<Grade> grades = gradeService.queryGrades(grade);
        Grade updateGrade = grades.get(0);
        req.setAttribute("grade", updateGrade);
        req.getRequestDispatcher("/view/grade/grade_update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Grade grade = RequestBeanUtils.requestToBean(req, Grade.class);
        boolean b = gradeService.updateGrade(grade);
        List<Grade> grades = gradeService.queryGrades(new Grade());
        if (b){
            req.setAttribute("tip", "修改成功");
        }
        req.setAttribute("queryGrades", grades);
        req.getRequestDispatcher("/view/grade/grade_list.jsp").forward(req, resp);
    }
}
