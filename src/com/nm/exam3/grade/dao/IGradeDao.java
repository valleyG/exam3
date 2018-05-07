package com.nm.exam3.grade.dao;

import com.nm.exam3.poji.Grade;

import java.util.List;

public interface IGradeDao {
    List<Grade> queryGrades(Grade grade);
    int addGrade(Grade grade);
    int updateGrade(Grade grade);
    int deleteGrade(Integer cid);
}
