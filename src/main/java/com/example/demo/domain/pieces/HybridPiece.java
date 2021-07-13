package com.example.demo.domain.pieces;

public class HybridPiece {

    private Boolean hybridPieceCheck; //Subsitema particular de los coches híbridos

    public void ok() {
        hybridPieceCheck=true;
        System.out.println("Hybrid piece is OK");

    }

    public void off(){
        hybridPieceCheck=false;
        System.out.println("Hybrid piece is OFF");

    }
    //Getters and Setters
    public Boolean getHybridPieceCheck() {
        return hybridPieceCheck;
    }

    public void setHybridPieceCheck(Boolean hybridPieceCheck) {
        this.hybridPieceCheck = hybridPieceCheck;
    }

    @Override
    public String toString() {
        return "HybridPiece{" +
                "hybridPieceCheck=" + hybridPieceCheck +
                '}';
    }
}
