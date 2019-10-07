package dev.glinzac.learnappmentorclient.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class CalendarEntity {
    @Id
    @GeneratedValue
    private int calendarId;
    private Date fromDate;
    private Date tillDate;
    private int timeSlot;
    private String status;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private MentorDetails mentorDetails;

    public CalendarEntity() {

    }
    public CalendarEntity(Date fromDate, Date tillDate, int timeSlot, String status,
                          MentorDetails mentorDetails) {
        super();
        this.fromDate = fromDate;
        this.tillDate = tillDate;
        this.timeSlot = timeSlot;
        this.status = status;
        this.mentorDetails = mentorDetails;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getTillDate() {
        return tillDate;
    }

    public void setTillDate(Date tillDate) {
        this.tillDate = tillDate;
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

    public MentorDetails getMentorDetails() {
        return mentorDetails;
    }

    public void setMentorDetails(MentorDetails mentorDetails) {
        this.mentorDetails = mentorDetails;
    }

    public int getCalendarId() {
        return calendarId;
    }



}
