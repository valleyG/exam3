package com.nm.exam3.grade.service.impl;

import com.nm.exam3.grade.dao.IGradeDao;
import com.nm.exam3.grade.dao.impl.GradeDaoImpl;
import com.nm.exam3.grade.service.IGradeService;
import com.nm.exam3.poji.Grade;

import java.util.List;

public class GradeServiceImpl implements IGradeService {
    private IGradeDao gradeDao = new GradeDaoImpl();
    @Override
    public List<Grade> queryGrades(Grade grade) {
        return gradeDao.queryGrades(grade);
    }

    @Override
    public boolean addGrade(Grade grade) {
        int rows = gradeDao.addGrade(grade);
        if (rows>0)
            return true;
        return false;
    }

    @Override
    public boolean deleteGrade(Integer cId) {
       int rows = gradeDao.deleteGrade(cId);
       if (rows>0)
           return true;
       return false;
    }

    @Override
    public boolean updateGrade(Grade grade) {
        int rows = gradeDao.updateGrade(grade);
        if (rows>0)
            return true;
        return false;
    }
}
