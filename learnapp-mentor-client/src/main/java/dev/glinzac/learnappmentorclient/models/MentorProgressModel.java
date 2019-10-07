package dev.glinzac.learnappmentorclient.models;

import java.sql.Date;

public class MentorProgressModel {
    private Date timestamp;
    private String username;
    private String courseId;
    private String courseStatus;
    private String paymentStatus;
    private int timeSlot;
    private int progress;
    private int withdrawCount;
    private int totalCount;

    public MentorProgressModel() {

    }

    public MentorProgressModel(Date timestamp, String username, String courseId, String courseStatus,
                               String paymentStatus, int timeSlot, int progress, int withdrawCount, int totalCount) {
        super();
        this.timestamp = timestamp;
        this.username = username;
        this.courseId = courseId;
        this.courseStatus = courseStatus;
        this.paymentStatus = paymentStatus;
        this.timeSlot = timeSlot;
        this.progress = progress;
        this.withdrawCount = withdrawCount;
        this.totalCount = totalCount;
    }




    public int getTotalCount() {
        return totalCount;
    }




    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }




    public String getPaymentStatus() {
        return paymentStatus;
    }


    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    public String getUsername() {
        return username;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public int getProgress() {
        return progress;
    }

    public int getWithdrawCount() {
        return withdrawCount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setWithdrawCount(int withdrawCount) {
        this.withdrawCount = withdrawCount;
    }


}

