package com.nm.exam3.student.service;

import com.nm.exam3.poji.Student;

import java.util.List;

public interface IStudentService {
    List<Student> queryStudent(Student student);
    boolean addStudent(Student student);
    boolean deleteStudent(Integer sId);
    boolean updateStudent(Student student);
}
