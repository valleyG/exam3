package com.nm.exam3.grade.service;

import com.nm.exam3.poji.Grade;

import java.util.List;

public interface IGradeService {
    List<Grade> queryGrades(Grade grade);
    boolean addGrade(Grade grade);
    boolean deleteGrade(Integer cId);
    boolean updateGrade(Grade grade);
}
