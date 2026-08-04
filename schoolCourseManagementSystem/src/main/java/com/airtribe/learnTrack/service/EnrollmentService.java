package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {

    boolean enrollStudent(Enrollment enrollment);
    List<Enrollment> getEnrollmentsForStudent(int studentId);
    boolean updateEnrollmentStatus(int enrollmentId, String status);
}
