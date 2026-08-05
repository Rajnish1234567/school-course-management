package com.airtribe.learnTrack.entity;

import com.airtribe.learnTrack.enums.StudentStatus;

public class Student extends Person{

    private String batch;
    private StudentStatus status;

    public Student() {
        super();
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public Student(String firstName, String lastName, String email, String batch) {
        super(firstName,lastName,email);
        this.batch = batch;
    }

    public Student( String firstName, String lastName, String batch) {
        super(firstName,lastName);
        this.batch = batch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student{" +
                "batch='" + batch + '\'' +
                ", status=" + this.status +
                '}');
    }
}
