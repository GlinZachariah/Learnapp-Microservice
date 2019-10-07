package dev.glinzac.learnappuserclient.models;

public class CourseModel {
    private String courseid;
    private String courseName;
    private String trainerName;
    private Skills technology;
    private double charges;
    private double commission;
    private int totalTime;

    public CourseModel() {

    }
    public CourseModel(String courseid, String courseName, String trainerName, Skills technology, double charges,
                       double commission,int totalTime) {
        super();
        this.courseid = courseid;
        this.courseName = courseName;
        this.trainerName = trainerName;
        this.technology = technology;
        this.charges = charges;
        this.commission = commission;
        this.totalTime = totalTime;
    }
    public String getCourseid() {
        return courseid;
    }
    public void setCourseid(String courseid) {
        this.courseid = courseid;
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
    public Skills getTechnology() {
        return technology;
    }
    public void setTechnology(Skills technology) {
        this.technology = technology;
    }
    public double getCharges() {
        return charges;
    }
    public void setCharges(double charges) {
        this.charges = charges;
    }
    public double getCommission() {
        return commission;
    }
    public void setCommission(double commission) {
        this.commission = commission;
    }
    public int getTotalTime() {
        return totalTime;
    }
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }




}
