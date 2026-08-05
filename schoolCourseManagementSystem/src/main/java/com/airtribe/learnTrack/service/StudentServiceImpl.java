package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Student;
import com.airtribe.learnTrack.enums.StudentStatus;
import com.airtribe.learnTrack.exception.EntityNotFoundException;
import com.airtribe.learnTrack.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String addStudent(Scanner scanner) {

        System.out.println("\nAdd New Student");

        System.out.print("First Name : ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name  : ");
        String lastName = scanner.nextLine();

        System.out.print("Email      : ");
        String email = scanner.nextLine();

        System.out.print("Batch      : ");
        String batch = scanner.nextLine();

        Student student = new Student(firstName, lastName, email, batch);
        student.setStatus(StudentStatus.ACTIVE);

        boolean flag = studentRepository.addStudent(student);
        if (flag) {
            return "Student saved successfully";
        } else {
            return "Student not saved";
        }
    }

    @Override
    public void viewAllStudent() {
        List<Student> studentList = studentRepository.viewAllStudent();
        if(!studentList.isEmpty()) {
            for (Student student1 : studentList) {
                student1.displayDetails();
            }
        } else {
            System.out.println(" No Student Found");
        }
    }

    @Override
    public void getStudentById(Scanner scanner) {

        System.out.print("Enter Student ID : ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        try{
            Student student = studentRepository.getStudentById(studentId);
            student.displayDetails();
        } catch (EntityNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deActiveStudent(Scanner scanner) {
        System.out.print("Enter Student ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try{
            if(studentRepository.deActivateStudent(id)) {
                System.out.println("Student with id :"+ id + " Deactivated");
            }
        } catch (EntityNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
