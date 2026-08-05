package com.airtribe.learnTrack.constants;

import java.util.Scanner;

public class MenuOptions {

    public static void showMenu() {
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
    }

    public static void pressEnterToContinue(Scanner scanner) {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Press ENTER to return to Main Menu...");
        System.out.println("----------------------------------------");
        scanner.nextLine();
    }
}
