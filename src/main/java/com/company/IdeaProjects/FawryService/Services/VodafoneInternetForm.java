package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class VodafoneInternetForm extends Iform {
    @Override
    public ArrayList<String> createForm() {
        String Phone="Enter your Mobile number:";
        String Amount="CHOOSE YOUR PACKAGE AMOUNT:" + "2000 SUPER MEGA: 15EGP"+ "," + "3500 SUPER MEGA: 25EGP" + "," +"6000 SUPER MEGA: 35EGP"+ "," +"8000 SUPER MEGA: 45EGP";
        data.add(Phone);
        data.add(Amount);
        return data;
    }
}
