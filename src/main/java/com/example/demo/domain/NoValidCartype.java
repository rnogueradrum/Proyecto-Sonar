package com.example.demo.domain;

public class NoValidCartype extends Exception {
    public NoValidCartype(String error) {
        super(error);
    }
}
