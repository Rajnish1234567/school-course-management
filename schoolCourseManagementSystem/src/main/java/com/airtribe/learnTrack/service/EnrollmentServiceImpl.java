package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Enrollment;
import com.airtribe.learnTrack.repository.EnrollmentRepository;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService{

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public String enrollStudent(Enrollment enrollment) {
        boolean isEnrolled = enrollmentRepository.enrollStudent(enrollment);
        if(isEnrolled)
            return "Student with id = "+ enrollment.getStudentId() + " Enrolled.";
        else
            return "Enrollment Failed for student with id = "+enrollment.getStudentId();
    }

    @Override
    public List<Enrollment> getEnrollmentsForStudent(int studentId) {
        return enrollmentRepository.getEnrollmentsForStudent(studentId);
    }

    @Override
    public String updateEnrollmentStatus(int enrollmentId, String status) {
        boolean isEnrolled  = enrollmentRepository.updateEnrollmentStatus(enrollmentId, status);
        if (isEnrolled) return "Enrollment Status updated";
        else return "";
    }
}
