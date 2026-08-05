package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Course;
import com.airtribe.learnTrack.repository.CourseRepository;

import java.util.List;

public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public String addCourse(Course course) {
        boolean isAdded = courseRepository.addCourse(course);
        if (isAdded) {
            return "Course Added.";
        } else {
            return "Course not added";
        }
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public String activateCourse(int id) {
        boolean isActivated = courseRepository.activateCourse(id);
        if (isActivated)
            return "Course Activated";
        else
            return "Course can not be activated";
    }

    @Override
    public String deactivateCourse(int id) {
        boolean isDeactivated =  courseRepository.deactivateCourse(id);
        if (isDeactivated)
            return "Course Activated";
        else
            return "Course can not be activated";
    }
}
