
package com.example.demo.domain.pieces;

public class AirConditioner {//Air Conditioner ON or OFF

    private Boolean airSwitch;

    public void airOn() {
        airSwitch = true;
        System.out.println("Air Conditioner ON");

    }

    public void airOff() {
        airSwitch = false;
        System.out.println("Air Conditioner OFF");
    }


    //Setters and Getters
    public Boolean getAirSwitch() {
        return airSwitch;
    }

    public void setAirSwitch(Boolean airSwitch) {
        this.airSwitch = airSwitch;
    }

    @Override
    public String toString() {
        return "AirConditioner{" +
                "airSwitch=" + airSwitch +
                '}';
    }
}
