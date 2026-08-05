package com.airtribe.learnTrack;

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

            System.out.println("\n==============================================");
            System.out.println("     STUDENT COURSE MANAGEMENT SYSTEM");
            System.out.println("================================================");

            System.out.println("\n------ Student Management ------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Deactivate Student");

            System.out.println("\n------ Course Management ------");
            System.out.println("5. Add Course");
            System.out.println("6. View All Courses");
            System.out.println("7. Activate Course");
            System.out.println("8. Deactivate Course");

            System.out.println("\n------ Enrollment Management ------");
            System.out.println("9. Enroll Student");
            System.out.println("10. View Student Enrollments");
            System.out.println("11. Complete Enrollment");
            System.out.println("12. Cancel Enrollment");

            System.out.println("\n0. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nAdd New Student");

                    System.out.print("First Name : ");
                    String firstName = scanner.nextLine();

                    System.out.print("Last Name  : ");
                    String lastName = scanner.nextLine();

                    System.out.print("Email      : ");
                    String email = scanner.nextLine();

                    System.out.print("Batch      : ");
                    String batch = scanner.nextLine();

                    Student student = new Student(firstName, lastName, email, batch);

                    System.out.println(studentService.addStudent(student));

                    pressEnterToContinue(scanner);

                    break;

                case 2:

                    List<Student> studentList = studentService.viewAllStudent();
                    if(!studentList.isEmpty()) {
                        for (Student student1 : studentList) {
                            student1.displayDetails();
                        }
                    } else {
                        System.out.println(" No Student Found");
                    }
                    pressEnterToContinue(scanner);
                    break;

                case 3:

                    System.out.print("Enter Student ID : ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        Student student1 = studentService.getStudentById(studentId);
                        student1.displayDetails();
                    } catch (EntityNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }

                    pressEnterToContinue(scanner);
                    break;

                case 4:

                    System.out.print("Enter Student ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println(studentService.deActiveStudent(id));
                    pressEnterToContinue(scanner);
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

                    pressEnterToContinue(scanner);
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

                    pressEnterToContinue(scanner);

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

                    pressEnterToContinue(scanner);
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

                    pressEnterToContinue(scanner);
                    break;

                // ================= ENROLLMENT =================

                case 9:

                    System.out.println("\nEnroll Student");

                    System.out.print("Student ID : ");
                    int sId = scanner.nextInt();

                    System.out.print("Course ID : ");
                    int cId = scanner.nextInt();

                    Enrollment enrollment =
                            new Enrollment(sId,
                                    cId,
                                    LocalDate.now());

                    enrollmentService.enrollStudent(enrollment);

                    pressEnterToContinue(scanner);
                    break;

                case 10:

                    System.out.print("Student ID : ");
                    int studentEnrollmentId = scanner.nextInt();
                    List<Enrollment> enrollmentList = enrollmentService.getEnrollmentsForStudent(studentEnrollmentId);
                    for (Enrollment enrollment1: enrollmentList) {
                        System.out.println(enrollment1.toString());
                    }

                    pressEnterToContinue(scanner);
                    break;

                case 11:

                    System.out.print("Enrollment ID : ");
                    int completeId = scanner.nextInt();

                    enrollmentService.updateEnrollmentStatus(
                            completeId,
                            "COMPLETED"
                    );

                    pressEnterToContinue(scanner);
                    break;

                case 12:

                    System.out.print("Enrollment ID : ");
                    int cancelId = scanner.nextInt();

                    enrollmentService.updateEnrollmentStatus(
                            cancelId,
                            "CANCELLED"
                    );

                    pressEnterToContinue(scanner);
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

    private static void pressEnterToContinue(Scanner scanner) {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Press ENTER to return to Main Menu...");
        System.out.println("----------------------------------------");
        scanner.nextLine();
    }
}