package com.airtribe.learnTrack.entity;

public class Student extends Person{

    private String batch;
    private boolean active;

    public Student() {
        super();
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student{" +
                "batch='" + batch + '\'' +
                ", active=" + active +
                '}');
    }
}
