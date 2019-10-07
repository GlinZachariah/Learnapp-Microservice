package dev.glinzac.learnappmentorclient.models;

import java.sql.Date;

public class SearchCourseRequestModel {
    private String technology;
    private Date startDate;
    private int timeSlot;
    public SearchCourseRequestModel() {

    }
    public SearchCourseRequestModel(String technology, Date startDate, int timeSlot) {
        super();
        this.technology = technology;
        this.startDate = startDate;
        this.timeSlot = timeSlot;
    }
    public String getTechnology() {
        return technology;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public int getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }



}

