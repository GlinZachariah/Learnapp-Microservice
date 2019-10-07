package dev.glinzac.learnappuserclient.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="user_completed")
//@NamedQuery(name = "findCoursesByUser",query = "select * from user_completed where user_name = :username")
public class UserCompleted {

    @Id
    @GeneratedValue
    private int completedId;
//    @ManyToOne
    @JoinColumn(name="course_id")
    private String courseDetails;

    @ManyToOne
    @JoinColumn(name="user_name")
    private UserDetails userDetails;

    private int rating;
    private int timeslot;
    private Date startDate;
    private Date endDate;
    private int withdrawCount;

    public String getCourseDetails() {
        return courseDetails;
    }
    public void setCourseDetails(String courseDetails) {
        this.courseDetails = courseDetails;
    }
    public UserDetails getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getTimeslot() {
        return timeslot;
    }
    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
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
    public int getWithdrawCount() {
        return withdrawCount;
    }
    public void setWithdrawCount(int withdrawCount) {
        this.withdrawCount = withdrawCount;
    }


}
