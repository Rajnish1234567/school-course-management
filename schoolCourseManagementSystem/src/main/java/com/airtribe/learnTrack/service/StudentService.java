package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Student;

import java.util.List;

public interface StudentService {
    String addStudent(Student student);

    List<Student> viewAllStudent() ;

    Student getStudentById(int id) ;

    String deleteStudent(int id) ;
}
