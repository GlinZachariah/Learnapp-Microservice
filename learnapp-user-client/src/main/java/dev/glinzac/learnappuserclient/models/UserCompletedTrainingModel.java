package dev.glinzac.learnappuserclient.models;

import java.sql.Date;

public class UserCompletedTrainingModel{
    private String courseId;
    private String userName;
    private int timeSlot;
    private Date startDate;
    private Date endDate;
    private int rating;
    private String trainerName;
    private String technology;
    private Double charges;

    public UserCompletedTrainingModel() {

    }



    public UserCompletedTrainingModel(String courseId, String userName, int timeSlot, Date startDate, Date endDate,
                                      int rating, String trainerName, String technology, Double charges) {
        super();
        this.courseId = courseId;
        this.userName = userName;
        this.timeSlot = timeSlot;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.trainerName = trainerName;
        this.technology = technology;
        this.charges = charges;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
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
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

}

