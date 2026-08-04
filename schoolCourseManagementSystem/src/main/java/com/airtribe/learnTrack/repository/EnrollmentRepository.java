package com.airtribe.learnTrack.repository;

import com.airtribe.learnTrack.entity.Enrollment;
import com.airtribe.learnTrack.exception.EntityNotFoundException;
import com.airtribe.learnTrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnrollmentRepository {

    private static final List<Enrollment> enrollmentList = new ArrayList<>();

    public boolean enrollStudent(Enrollment enrollment) {
        enrollment.setId(IdGenerator.getNextEnrollmentId());
        return enrollmentList.add(enrollment);
    }

    public List<Enrollment> getEnrollmentsForStudent(int studentId) {
        return enrollmentList.stream()
                .filter(enrollment -> enrollment.getStudentId() == studentId)
                .toList();
    }

    public boolean updateEnrollmentStatus(int enrollmentId, String status) {
         Optional<Enrollment> enroll = enrollmentList.stream()
                .filter(enrollment -> enrollment.getId() == enrollmentId)
                .findFirst();
         if(enroll.isPresent()) {
             enroll.get().setStatus(status);
             return true;
         }
        throw new EntityNotFoundException(String.format("No Enrollment found with id: %d", enrollmentId));
    }

}
