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
    public boolean enrollStudent(Enrollment enrollment) {
        return enrollmentRepository.enrollStudent(enrollment);
    }

    @Override
    public List<Enrollment> getEnrollmentsForStudent(int studentId) {
        return enrollmentRepository.getEnrollmentsForStudent(studentId);
    }

    @Override
    public boolean updateEnrollmentStatus(int enrollmentId, String status) {
        return enrollmentRepository.updateEnrollmentStatus(enrollmentId, status);
    }
}
