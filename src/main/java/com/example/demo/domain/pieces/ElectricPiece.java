
package com.example.demo.domain.pieces;

public class ElectricPiece {

    private Boolean electricPieceCheck; //Subsitema particular de los coches eléctricos

    public void ok() {
        electricPieceCheck=true;
        System.out.println("Electric piece is OK");

    }

    public void off() {
        electricPieceCheck=false;
        System.out.println("Electric piece is OFF");
    }

    public Boolean getElectricPieceCheck() {
        return electricPieceCheck;
    }

    public void setElectricPieceCheck(Boolean electricPieceCheck) {
        this.electricPieceCheck = electricPieceCheck;
    }

}
