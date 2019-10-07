package dev.glinzac.learnappuserclient.models;

import java.sql.Date;

public class UserProgressTrainingModel {
    private String courseId;
    private String courseName;
    private String trainerName;
    private String technology;
    private String userName;
    private int progress;
    private int rating;
    private String paymentStatus;
    private String courseStatus;
    private int timeSlot;
    private Date startDate;
    public UserProgressTrainingModel() {

    }



    public UserProgressTrainingModel(String courseId, String courseName, String trainerName, String technology,
                                     String userName, int progress, int rating, String paymentStatus, String courseStatus, int timeSlot,
                                     Date startDate) {
        super();
        this.courseId = courseId;
        this.courseName = courseName;
        this.trainerName = trainerName;
        this.technology = technology;
        this.userName = userName;
        this.progress = progress;
        this.rating = rating;
        this.paymentStatus = paymentStatus;
        this.courseStatus = courseStatus;
        this.timeSlot = timeSlot;
        this.startDate = startDate;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getProgress() {
        return progress;
    }
    public void setProgress(int progress) {
        this.progress = progress;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public int getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

}

