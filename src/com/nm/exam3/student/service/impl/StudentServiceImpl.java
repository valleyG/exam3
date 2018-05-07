package com.nm.exam3.student.service.impl;

import com.nm.exam3.poji.Student;
import com.nm.exam3.student.dao.IStudentDao;
import com.nm.exam3.student.dao.impl.StudentDaoImpl;
import com.nm.exam3.student.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> queryStudent(Student student) {
        return studentDao.queryStudent(student);
    }

    @Override
    public boolean addStudent(Student student) {
        int rows = studentDao.addStudent(student);
        if (rows>0)
            return true;
        return false;
    }

    @Override
    public boolean deleteStudent(Integer sId) {
        int rows = studentDao.deleteStudent(sId);
        if (rows>0)
            return true;
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        int rows = studentDao.updateStudent(student);
        if (rows>0)
            return true;
        return false;
    }
}
