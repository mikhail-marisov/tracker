package com.example.tracker.helper;

import com.example.tracker.domain.PostOffice;

public class PostOfficeHelper {

    public static PostOffice getPostOffice() {

        return new PostOffice("010203", "Name", "Address");
    }
}
