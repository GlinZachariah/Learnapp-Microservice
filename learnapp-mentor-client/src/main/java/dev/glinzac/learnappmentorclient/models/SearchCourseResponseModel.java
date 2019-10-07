package dev.glinzac.learnappmentorclient.models;

import java.sql.Date;

public class SearchCourseResponseModel {
    private String courseId;
    private String courseName;
    private String trainerName;
    private int experience;
    private String technology;
    private boolean materialVideo;
    private boolean materialDemo;
    private boolean materialPPT;
    private boolean materialBlog;
    private int totalCount;
    private int activeCount;
    private int completedCount;
    private Double trainingCharges;
    private Double serviceCharges;
    private int totalTime;
    private int avgCourseRating;
    private int timeSlot;
    private Date startDate;

    public SearchCourseResponseModel() {

    }





    public SearchCourseResponseModel(String courseId, String courseName, String trainerName, int experience,
                                     String technology, boolean materialVideo, boolean materialDemo, boolean materialPPT, boolean materialBlog,
                                     int totalCount, int activeCount, int completedCount, Double trainingCharges, Double serviceCharges,
                                     int totalTime, int avgCourseRating, int timeSlot, Date startDate) {
        super();
        this.courseId = courseId;
        this.courseName = courseName;
        this.trainerName = trainerName;
        this.experience = experience;
        this.technology = technology;
        this.materialVideo = materialVideo;
        this.materialDemo = materialDemo;
        this.materialPPT = materialPPT;
        this.materialBlog = materialBlog;
        this.totalCount = totalCount;
        this.activeCount = activeCount;
        this.completedCount = completedCount;
        this.trainingCharges = trainingCharges;
        this.serviceCharges = serviceCharges;
        this.totalTime = totalTime;
        this.avgCourseRating = avgCourseRating;
        this.timeSlot = timeSlot;
        this.startDate = startDate;
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

    public int getAvgCourseRating() {
        return avgCourseRating;
    }

    public void setAvgCourseRating(int avgCourseRating) {
        this.avgCourseRating = avgCourseRating;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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
    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    public String getTechnology() {
        return technology;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
    }
    public boolean isMaterialVideo() {
        return materialVideo;
    }
    public void setMaterialVideo(boolean materialVideo) {
        this.materialVideo = materialVideo;
    }
    public boolean isMaterialDemo() {
        return materialDemo;
    }
    public void setMaterialDemo(boolean materialDemo) {
        this.materialDemo = materialDemo;
    }
    public boolean isMaterialPPT() {
        return materialPPT;
    }
    public void setMaterialPPT(boolean materialPPT) {
        this.materialPPT = materialPPT;
    }
    public boolean isMaterialBlog() {
        return materialBlog;
    }
    public void setMaterialBlog(boolean materialBlog) {
        this.materialBlog = materialBlog;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }

    public int getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(int completedCount) {
        this.completedCount = completedCount;
    }

    public Double getTrainingCharges() {
        return trainingCharges;
    }
    public void setTrainingCharges(Double trainingCharges) {
        this.trainingCharges = trainingCharges;
    }
    public Double getServiceCharges() {
        return serviceCharges;
    }
    public void setServiceCharges(Double serviceCharges) {
        this.serviceCharges = serviceCharges;
    }
    public int getTotalTime() {
        return totalTime;
    }
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

}

