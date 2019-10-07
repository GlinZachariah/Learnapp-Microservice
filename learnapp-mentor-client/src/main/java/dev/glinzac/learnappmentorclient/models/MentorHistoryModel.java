package dev.glinzac.learnappmentorclient.models;

public class MentorHistoryModel {
    private String courseId;
    private String technology;
    private int totalTraineeCount;
    private int courseCompleted;
    private int courseActive;
    private int courseRating;
    private Double mentorEarned;
    private Double revenueEarned;

    public MentorHistoryModel() {

    }

    public MentorHistoryModel(String courseId, String technology, int totalTraineeCount, int courseCompleted,
                              int courseActive, int courseRating, Double mentorEarned, Double revenueEarned) {
        super();
        this.courseId = courseId;
        this.technology = technology;
        this.totalTraineeCount = totalTraineeCount;
        this.courseCompleted = courseCompleted;
        this.courseActive = courseActive;
        this.courseRating = courseRating;
        this.mentorEarned = mentorEarned;
        this.revenueEarned = revenueEarned;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Double getMentorEarned() {
        return mentorEarned;
    }

    public void setMentorEarned(Double mentorEarned) {
        this.mentorEarned = mentorEarned;
    }

    public Double getRevenueEarned() {
        return revenueEarned;
    }

    public void setRevenueEarned(Double revenueEarned) {
        this.revenueEarned = revenueEarned;
    }

    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public int getTotalTraineeCount() {
        return totalTraineeCount;
    }
    public void setTotalTraineeCount(int totalTraineeCount) {
        this.totalTraineeCount = totalTraineeCount;
    }
    public int getCourseCompleted() {
        return courseCompleted;
    }
    public void setCourseCompleted(int courseCompleted) {
        this.courseCompleted = courseCompleted;
    }
    public int getCourseActive() {
        return courseActive;
    }
    public void setCourseActive(int courseActive) {
        this.courseActive = courseActive;
    }
    public int getCourseRating() {
        return courseRating;
    }
    public void setCourseRating(int courseRating) {
        this.courseRating = courseRating;
    }

}

