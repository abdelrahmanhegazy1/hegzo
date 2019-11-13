package com.example.spj;

import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable {

    String name;

    private ArrayList<Car> cars=new ArrayList<>();
    int IconOfComapny;

    public Company(String name ,int IconOfCompny) {
        this.name = name;
        this.IconOfComapny=IconOfCompny;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public int getIconOfComapny() {
        return IconOfComapny;
    }

    public void setIconOfComapny(int iconOfComapny) {
        IconOfComapny = iconOfComapny;
    }
}
