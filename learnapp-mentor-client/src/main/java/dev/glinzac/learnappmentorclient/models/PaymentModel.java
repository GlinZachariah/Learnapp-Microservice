package dev.glinzac.learnappmentorclient.models;

import java.sql.Date;

public class PaymentModel {
    private Date paymentDate;
    private String userName;
    private String trainerName;
    private String courseId;
    private Double paymentAmount;
    private Double commissionAmount;
    public PaymentModel() {

    }
    public PaymentModel(Date paymentDate, String userName, String trainerName, String courseId, Double paymentAmount,
                        Double commissionAmount) {
        super();
        this.paymentDate = paymentDate;
        this.userName = userName;
        this.trainerName = trainerName;
        this.courseId = courseId;
        this.paymentAmount = paymentAmount;
        this.commissionAmount = commissionAmount;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public Double getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public Double getCommissionAmount() {
        return commissionAmount;
    }
    public void setCommissionAmount(Double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }


}

