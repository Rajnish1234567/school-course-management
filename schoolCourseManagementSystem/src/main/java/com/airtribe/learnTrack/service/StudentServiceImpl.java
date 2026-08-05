package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Student;
import com.airtribe.learnTrack.enums.StudentStatus;
import com.airtribe.learnTrack.exception.EntityNotFoundException;
import com.airtribe.learnTrack.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String addStudent(Student student) {
        student.setStatus(StudentStatus.ACTIVE);
        boolean flag = studentRepository.addStudent(student);
        if (flag) {
            return "Student saved successfully";
        } else {
            return "Student not saved";
        }
    }

    @Override
    public List<Student> viewAllStudent() {
        return studentRepository.viewAllStudent();
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.getStudentById(id);
        if (student.isPresent()) return student.get();
        else throw new EntityNotFoundException(String.format("No student found with id: %d", id));
    }

    @Override
    public String deActiveStudent(int id) {
        try{
            studentRepository.deActivateStudent(id);
            return String.format("student deleted with id: %d", id);
        } catch (EntityNotFoundException ex) {
            return ex.getMessage();
        }
    }
}
