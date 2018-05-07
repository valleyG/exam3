package com.nm.exam3.student.dao.impl;

import com.nm.exam3.poji.Student;
import com.nm.exam3.student.dao.IStudentDao;
import com.nm.exam3.utils.c3p0utils;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public List<Student> queryStudent(Student student) {
        StringBuffer sql = new StringBuffer("select ts.*,cName from t_student ts left join t_class tc on(ts.cid=tc.cid) where 1=1");
        List<Object> params = new ArrayList<>();
        if (student.getsId()!=null&&student.getsId()!=0){
            sql.append(" and ts.sid = ?");
            params.add(student.getsId());
        }
        if (student.getcId()!=null&&student.getcId()!=0){
            sql.append(" and ts.cid = ?");
            params.add(student.getcId());
        }
        if (student.getsName()!=null&&!"".equals(student.getsName())){
            sql.append(" and ts.sName like ?");
            params.add("%"+student.getsName()+"%");
        }
       return c3p0utils.queryList(sql.toString(), Student.class, params.toArray());
    }

    @Override
    public int addStudent(Student student) {
        String sql = "insert into t_student values(seq_student.nextval,?,?,?,?)";
        return c3p0utils.update(sql, student.getcId(),student.getsName(),student.getsSex(),student.getsAge());
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update t_student set cId = ?,sName = ?,sSex = ? ,sAge = ? where sId = ?";
        return c3p0utils.update(sql,student.getcId(),student.getsName(),student.getsSex(),student.getsAge(),
                student.getsId());
    }

    @Override
    public int deleteStudent(Integer sId) {
        String sql ="delete t_student where sId = ?";
        return c3p0utils.update(sql, sId);
    }
}
