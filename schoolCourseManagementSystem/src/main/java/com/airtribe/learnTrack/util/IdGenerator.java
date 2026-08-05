package com.airtribe.learnTrack.util;

public class IdGenerator {

    private static int studentIdCounter = 1000;
    private static int courseIdCounter = 500;
    private static int enrollmentIdCounter = 1;

    private IdGenerator() {
    }

    public static int getNextStudentId() {
        return ++studentIdCounter;
    }

    public static int getNextCourseId() {
        return ++courseIdCounter;
    }

    public static int getNextEnrollmentId() {
        return ++enrollmentIdCounter;
    }
}