package dev.glinzac.learnappuserclient.entities;

import javax.persistence.*;

@Entity
@Table(name="card_details")
public class CardDetails {
    @Id
    @GeneratedValue
    private int userId;
    private String cardNo;
    private int MM;
    private int YY;
    private int CV;


    @OneToOne
    @JoinColumn(name = "user_name")
    private UserDetails userDetails;

    public CardDetails(){

    }

    public CardDetails(String cardNo, int mM, int yY, int cV) {
        super();
        this.cardNo = cardNo;
        MM = mM;
        YY = yY;
        CV = cV;
    }
    public UserDetails getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    public int getUserId() {
        return userId;
    }

    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public int getMM() {
        return MM;
    }
    public void setMM(int mM) {
        MM = mM;
    }
    public int getYY() {
        return YY;
    }
    public void setYY(int yY) {
        YY = yY;
    }
    public int getCV() {
        return CV;
    }
    public void setCV(int cV) {
        CV = cV;
    }

}

