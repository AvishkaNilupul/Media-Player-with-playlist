package com.example.demo;

import java.util.HashMap;

public class ID {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    ID(){
        logininfo.put("Avishka","123456");


    }

    public HashMap<String, String> getLogininfo() {
        return logininfo;
    }
}
