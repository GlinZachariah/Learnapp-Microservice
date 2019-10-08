package dev.glinzac.learnappuserclient.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PaymentLog {

    @Id
    @GeneratedValue
    private int paymentId;
    private Date date;

    @OneToOne
    @JoinColumn(name="user_name")
    private UserDetails userDetails;

//    @OneToOne
    @JoinColumn(name="course_id")
    private String courseDetails;

//    @OneToOne
    @JoinColumn(name="mentor_id")
    private int mentorDetails;

    @Column(name="payment_amount")
    private Double paymentAmount;

    @Column(name="commission")
    private Double commission;

    public PaymentLog(){

    }

    public PaymentLog(Date date, UserDetails userDetails, String courseDetails, int mentorDetails,
                      Double paymentAmount, Double commission) {
        super();
        this.date = date;
        this.userDetails = userDetails;
        this.courseDetails = courseDetails;
        this.mentorDetails = mentorDetails;
        this.paymentAmount = paymentAmount;
        this.commission = commission;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(String courseDetails) {
        this.courseDetails = courseDetails;
    }

    public int getMentorDetails() {
        return mentorDetails;
    }

    public void setMentorDetails(int mentorDetails) {
        this.mentorDetails = mentorDetails;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }




}
