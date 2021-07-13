
package com.example.demo.domain.pieces;

public class Battery {// Battery charged check passed OK or OFF (disconnected)

    private Boolean charged;

    public void batteryOk() {
        this.charged=true;
        System.out.println("Battery charged OK");//Mensaje para consola
    }

    public void batteryOff() {
        this.charged=false;
        System.out.println("Battery OFF");
    }

    //Setters y Getters
    public Boolean getCharged() {
        return charged;
    }

    public void setCharged(Boolean charged) {
        this.charged = charged;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "charged=" + charged +
                '}';
    }
}
