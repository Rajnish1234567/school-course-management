package com.airtribe.learnTrack;

import com.airtribe.learnTrack.constants.MenuOptions;
import com.airtribe.learnTrack.entity.Course;
import com.airtribe.learnTrack.entity.Enrollment;
import com.airtribe.learnTrack.entity.Student;
import com.airtribe.learnTrack.exception.EntityNotFoundException;
import com.airtribe.learnTrack.repository.CourseRepository;
import com.airtribe.learnTrack.repository.EnrollmentRepository;
import com.airtribe.learnTrack.repository.StudentRepository;
import com.airtribe.learnTrack.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentServiceImpl(new StudentRepository());
        CourseService courseService = new CourseServiceImpl(new CourseRepository());
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(new EnrollmentRepository());

        boolean running = true;

        while (running) {
            MenuOptions.showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println(studentService.addStudent(scanner));
                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                case 2:
                    studentService.viewAllStudent();
                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                case 3:
                    studentService.getStudentById(scanner);
                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                case 4:
                    studentService.deActiveStudent(scanner);
                    MenuOptions.pressEnterToContinue(scanner);
                    break;


                // ================= COURSE =================

                case 5:

                    System.out.println("\nAdd New Course");

                    System.out.print("Course Name : ");
                    String courseName = scanner.nextLine();

                    System.out.print("Description : ");
                    String description = scanner.nextLine();

                    System.out.print("Duration (Weeks) : ");
                    int duration = scanner.nextInt();

                    scanner.nextLine();
                    Course course =
                            new Course(courseName,
                                    description,
                                    duration);
                    System.out.println(courseService.addCourse(course));

                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                case 6:

                    List<Course> courses = courseService.getAllCourse();
                    if(courses.isEmpty()) {
                        System.out.println("No course Found.");
                    } else {
                        for (Course course1: courses) {
                            System.out.println(course1.toString());
                        }
                    }

                    MenuOptions.pressEnterToContinue(scanner);

                    break;

                case 7:

                    System.out.print("Enter Course ID : ");
                    int activeCourse = scanner.nextInt();

                    scanner.nextLine();
                    try{
                        System.out.println(courseService.activateCourse(activeCourse));
                    } catch (EntityNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }

                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                case 8:

                    System.out.print("Enter Course ID : ");
                    int deActiveCourse = scanner.nextInt();

                    scanner.nextLine();
                    try{
                        System.out.println(courseService.deactivateCourse(deActiveCourse));
                    } catch (EntityNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }

                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                // ================= ENROLLMENT =================

                case 9:

                    System.out.println("\nEnroll Student");

                    System.out.print("Student ID : ");
                    int sId = scanner.nextInt();

                    System.out.print("Course ID : ");
                    int cId = scanner.nextInt();

                    scanner.nextLine();
                    Enrollment enrollment =
                            new Enrollment(sId,
                                    cId,
                                    LocalDate.now());

                    System.out.println(enrollmentService.enrollStudent(enrollment));

                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                case 10:

                    System.out.print("Student ID : ");
                    int studentEnrollmentId = scanner.nextInt();

                    scanner.nextLine();
                    List<Enrollment> enrollmentList = enrollmentService.getEnrollmentsForStudent(studentEnrollmentId);
                    if (!enrollmentList.isEmpty()) {
                        for (Enrollment enrollment1: enrollmentList) {
                            System.out.println(enrollment1.toString());
                        }
                    } else {
                        System.out.println("No Enrollment Present");
                    }

                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                case 11:

                    System.out.print("Enrollment ID : ");
                    int completeId = scanner.nextInt();

                    scanner.nextLine();
                    try{
                        System.out.println(enrollmentService.updateEnrollmentStatus(
                                completeId,
                                "COMPLETED"
                        ));
                    } catch (EntityNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }

                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                case 12:

                    System.out.print("Enrollment ID : ");
                    int cancelId = scanner.nextInt();

                    scanner.nextLine();
                    try{
                        System.out.println(enrollmentService.updateEnrollmentStatus(
                                cancelId,
                                "CANCELLED"
                        ));
                    } catch (EntityNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }

                    MenuOptions.pressEnterToContinue(scanner);
                    break;

                // ================= EXIT =================

                case 0:

                    running = false;
                    System.out.println("\nThank you for using Student Course Management System.");
                    System.out.println("Application Closed.");

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

}