package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Student;

import java.util.Scanner;

public interface StudentService {
    String addStudent(Scanner scanner);

    void viewAllStudent() ;

    void getStudentById(Scanner scanner) ;

    void deActiveStudent(Scanner scanner) ;
}
