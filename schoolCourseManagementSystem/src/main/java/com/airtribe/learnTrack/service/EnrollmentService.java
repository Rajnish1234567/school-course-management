package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {

    String enrollStudent(Enrollment enrollment);
    List<Enrollment> getEnrollmentsForStudent(int studentId);
    String updateEnrollmentStatus(int enrollmentId, String status);
}
