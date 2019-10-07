package dev.glinzac.learnappmentorclient.entities;

import javax.persistence.*;

@Entity
@Table(name="course_details")
public class CourseDetails {
    @Id
    @Column(name="course_id",length = 32)
    private String courseId;

    @Column(name="course_name")
    private String courseName;

    @Column(name="course_charges")
    private Double charges;

    @Column(name="commission")
    private Double commission;

    @Column(name="total_hours")
    private int totalTime;

    @ManyToOne
    @JoinColumn(name="mentor_id")
    private MentorDetails mentorDetails;

//    @OneToOne
    @JoinColumn(name="technology")
    private String technology;

    private int totalTraineeCount;
    private int traineeCompleted;
    private int traineeInProgress;
    private int averageRating;

    private Double mentorEarned;
    private Double totalRevenue;

    public CourseDetails(){

    }

    public CourseDetails(String courseId, String courseName, Double charges, Double commission, int totalTime,
                         MentorDetails mentorDetails, String technology, int totalTraineeCount, int traineeCompleted,
                         int traineeInProgress, int averageRating, Double mentorEarned, Double totalRevenue) {
        super();
        this.courseId = courseId;
        this.courseName = courseName;
        this.charges = charges;
        this.commission = commission;
        this.totalTime = totalTime;
        this.mentorDetails = mentorDetails;
        this.technology = technology;
        this.totalTraineeCount = totalTraineeCount;
        this.traineeCompleted = traineeCompleted;
        this.traineeInProgress = traineeInProgress;
        this.averageRating = averageRating;
        this.mentorEarned = mentorEarned;
        this.totalRevenue = totalRevenue;
    }

    public Double getMentorEarned() {
        return mentorEarned;
    }

    public void setMentorEarned(Double mentorEarned) {
        this.mentorEarned = mentorEarned;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public MentorDetails getMentorDetails() {
        return mentorDetails;
    }

    public void setMentorDetails(MentorDetails mentorDetails) {
        this.mentorDetails = mentorDetails;
    }

    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Double getCharges() {
        return charges;
    }
    public void setCharges(Double charges) {
        this.charges = charges;
    }
    public Double getCommission() {
        return commission;
    }
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getSkills() {
        return technology;
    }

    public void setSkills(String technology) {
        this.technology = technology;
    }

    public int getTotalTraineeCount() {
        return totalTraineeCount;
    }

    public void setTotalTraineeCount(int totalTraineeCount) {
        this.totalTraineeCount = totalTraineeCount;
    }

    public int getTraineeCompleted() {
        return traineeCompleted;
    }

    public void setTraineeCompleted(int traineeCompleted) {
        this.traineeCompleted = traineeCompleted;
    }

    public int getTraineeInProgress() {
        return traineeInProgress;
    }

    public void setTraineeInProgress(int traineeInProgress) {
        this.traineeInProgress = traineeInProgress;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

}


