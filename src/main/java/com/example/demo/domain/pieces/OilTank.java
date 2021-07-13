package com.example.demo.domain.pieces;

public class OilTank {

    private Boolean oilTank;

    public void fullTank() {
        oilTank=true;
        System.out.println("Oil Tank is full");

    }

    public void emptyTank() {
        oilTank=false;
        System.out.println("Oil Tank is empty");
    }

    public Boolean getOilTank() {
        return oilTank;
    }

    public void setOilTank(Boolean oilTank) {
        this.oilTank = oilTank;
    }

}
