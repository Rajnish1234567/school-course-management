package com.airtribe.learnTrack.repository;

import com.airtribe.learnTrack.entity.Student;
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

    public Optional<Student> getStudentById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id && student.isActive())
                .findFirst();
    }

    public boolean deleteStudent(int id) {
        Optional<Student> optionalStudent = getStudentById(id);
        if (optionalStudent.isPresent()) {
            optionalStudent.get().setActive(false);
            return true;
        }
        throw new EntityNotFoundException(String.format("No student found with id: %d", id));
    }
}
