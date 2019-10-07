package dev.glinzac.learnappmentorclient.models;

public class CommissionModel {
    private String courseId;
    private int mentorId;
    private String trainerName;
    private Double courseCharge;
    private Double commission;
    public CommissionModel() {

    }
    public CommissionModel(String courseId, int mentorId, String trainerName, Double courseCharge, Double commission) {
        super();
        this.courseId = courseId;
        this.mentorId = mentorId;
        this.trainerName = trainerName;
        this.courseCharge = courseCharge;
        this.commission = commission;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public int getMentorId() {
        return mentorId;
    }
    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }
    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    public Double getCourseCharge() {
        return courseCharge;
    }
    public void setCourseCharge(Double courseCharge) {
        this.courseCharge = courseCharge;
    }
    public Double getCommission() {
        return commission;
    }
    public void setCommission(Double commission) {
        this.commission = commission;
    }



}

