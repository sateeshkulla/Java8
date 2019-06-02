package com.inter;

public interface Vehicle {

    public void getModels();

    static String getDescription() {
        return "Vehicle Description";
    }

    default String getMake() {
        return "Acura";
    }

}
