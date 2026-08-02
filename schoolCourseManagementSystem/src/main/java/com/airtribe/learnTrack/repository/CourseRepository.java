package com.airtribe.learnTrack.repository;

import com.airtribe.learnTrack.entity.Course;
import com.airtribe.learnTrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {

    private static final List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        course.setId(IdGenerator.getNextCourseId());
        return courses.add(course);
    }

    public List<Course> getAllCourse() {
        return courses.stream().toList();
    }

    private Optional<Course> getCourse(int id) {
        return courses.stream()
                .filter(course -> course.getId() == id && course.isActive())
                .findFirst();
    }

    public boolean activateCourse(int id) {
        Optional<Course> course = getCourse(id);
        if (course.isPresent()) {
            course.get().setActive(true);
            return true;
        }
        return false;
    }

    public boolean deactivateCourse(int id) {
        Optional<Course> course = getCourse(id);
        if (course.isPresent()) {
            course.get().setActive(false);
            return true;
        }
        return false;
    }
}
