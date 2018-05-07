package com.nm.exam3.grade.dao.impl;

import com.nm.exam3.grade.dao.IGradeDao;
import com.nm.exam3.poji.Grade;
import com.nm.exam3.utils.c3p0utils;

import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl implements IGradeDao {

    @Override
    public List<Grade> queryGrades(Grade grade) {
        StringBuffer sql = new StringBuffer("select * from t_class where 1=1");
        List<Object> params = new ArrayList<>();
        if (grade.getcId()!=null&&grade.getcId()!=0){
            sql.append(" and cId=?");
            params.add(grade.getcId());
        }
        if (grade.getcName()!=null&&!"".equals(grade.getcName())){
            sql.append(" and cName like ?");
            params.add("%"+grade.getcName()+"%");
        }
        return c3p0utils.queryList(sql.toString(), Grade.class, params.toArray());
    }

    @Override
    public int addGrade(Grade grade) {
        String sql = "insert into t_class values(seq_name.nextval,?)";
        return c3p0utils.update(sql, grade.getcName());
    }

//
    @Override
    public int updateGrade(Grade grade) {
        String sql = "update t_class set cName = ? where cId = ?";
        return c3p0utils.update(sql, grade.getcName(),grade.getcId());
    }

    @Override
    public int deleteGrade(Integer cId) {
        String  sql = "delete t_class where cId = ?";
        return c3p0utils.update(sql, cId);
    }
}
