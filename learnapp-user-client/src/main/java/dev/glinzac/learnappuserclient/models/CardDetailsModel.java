package dev.glinzac.learnappuserclient.models;

public class CardDetailsModel {
    private String cardNo;
    private int mM;
    private int yY;
    private int cV;
    private String username;

    public CardDetailsModel() {

    }

   public CardDetailsModel(String cardNo, int mM, int yY, int cV, String username) {
        super();
        this.cardNo = cardNo;
        this.mM = mM;
        this.yY = yY;
        this.cV = cV;
        this.username = username;
    }


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getmM() {
        return mM;
    }

    public void setmM(int mM) {
        this.mM = mM;
    }

    public int getyY() {
        return yY;
    }

    public void setyY(int yY) {
        this.yY = yY;
    }

    public int getcV() {
        return cV;
    }

    public void setcV(int cV) {
        this.cV = cV;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}

