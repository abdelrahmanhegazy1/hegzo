package com.example.spj;

import java.io.Serializable;

class Car implements Serializable {
   private String CarName;
   private int iconID;
   private String SmallDetails;
   private String LotDetails;
   private  String CompanyName;

    public Car(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public Car(String carName, int iconID, String smallDetails, String lotDetails) {
        CarName = carName;
        this.iconID = iconID;
        SmallDetails = smallDetails;
        LotDetails = lotDetails;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getSmallDetails() {
        return SmallDetails;
    }

    public void setSmallDetails(String smallDetails) {
        SmallDetails = smallDetails;
    }

    public String getLotDetails() {
        return LotDetails;
    }

    public void setLotDetails(String lotDetails) {
        LotDetails = lotDetails;
    }
}
