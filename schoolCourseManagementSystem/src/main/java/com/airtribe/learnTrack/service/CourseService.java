package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Course;

import java.util.List;

public interface CourseService {
    String addCourse(Course course);
    List<Course> getAllCourse();
    String activateCourse(int id);
    String deactivateCourse(int id);
}
