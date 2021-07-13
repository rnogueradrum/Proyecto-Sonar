package com.example.demo.domain.pieces;

public class Engine {// Engine On or OFF

    private Boolean ignition;

        public void startedOn() {
            ignition=true;
            System.out.println("Motor started ON");
        }

        public void startedOff() {
            ignition=false;
            System.out.println("Motor started OFF");
        }

    public Boolean getIgnition() {
        return ignition;
    }

    public void setIgnition(Boolean ignition) {
        this.ignition = ignition;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "ignition=" + ignition +
                '}';
    }
}
