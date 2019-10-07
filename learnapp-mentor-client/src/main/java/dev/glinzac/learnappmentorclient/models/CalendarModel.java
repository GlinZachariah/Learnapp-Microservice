package dev.glinzac.learnappmentorclient.models;

import java.sql.Date;

public class CalendarModel {
    private Date fromDate;
    private Date tillDate;
    private int timeSlot;
    private String status;
    private String mentorName;

    public CalendarModel() {

    }

    public CalendarModel(Date fromDate, Date tillDate, int timeSlot, String status,
                         String mentorName) {
        super();
        this.fromDate = fromDate;
        this.tillDate = tillDate;
        this.timeSlot = timeSlot;
        this.status = status;
        this.mentorName = mentorName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public int getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTillDate() {
        return tillDate;
    }

    public void setTillDate(Date tillDate) {
        this.tillDate = tillDate;
    }


}
