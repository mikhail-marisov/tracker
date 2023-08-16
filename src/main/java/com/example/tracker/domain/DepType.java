package com.example.tracker.domain;

public enum DepType {

    LETTER("письмо"),
    PARCEL("посылка"),
    SMALLPARCEL("бандероль"),
    POSTCARD("открытка");

    private String depTypeName;

    DepType (String depTypeName) {
        this.depTypeName = depTypeName;
    }
}
