package com.airtribe.learnTrack.repository;

import com.airtribe.learnTrack.entity.Student;
import com.airtribe.learnTrack.enums.StudentStatus;
import com.airtribe.learnTrack.exception.EntityNotFoundException;
import com.airtribe.learnTrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    private static final List<Student> studentList = new ArrayList<>();

    public boolean addStudent(Student student) {
        student.setId(IdGenerator.getNextStudentId());
        return studentList.add(student);
    }

    public List<Student> viewAllStudent() {
        return studentList.stream().toList();
    }

    public Student getStudentById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                String.format("No student found with id: %d", id)
                        )
                );
    }

    public boolean deActivateStudent(int id) {
        Student student = getStudentById(id);
        student.setStatus(StudentStatus.DEACTIVE);
        return true;
    }
}
