package com.nm.exam3.student.dao;

import com.nm.exam3.poji.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> queryStudent(Student student);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(Integer sId);
}
