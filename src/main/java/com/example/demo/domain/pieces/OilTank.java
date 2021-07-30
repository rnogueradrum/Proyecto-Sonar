package com.example.demo.domain.pieces;

public class OilTank {

    private Boolean gasTank;

    public void fullTank() {
        gasTank=true;
        System.out.println("Oil Tank is full");

    }

    public void emptyTank() {
        gasTank=false;
        System.out.println("Oil Tank is empty");
    }

    public Boolean getGasTank() {
        return gasTank;
    }

    public void setGasTank(Boolean oilTank) {
        this.gasTank = oilTank;
    }

}
