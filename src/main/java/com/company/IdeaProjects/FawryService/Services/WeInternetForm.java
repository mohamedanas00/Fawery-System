package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class WeInternetForm extends Iform {
    @Override
    public ArrayList<String> createForm() {
        String Phone="Enter your Mobile number:";
        String Amount="CHOOSE YOUR PACKAGE AMOUNT:" + "40 NITRO PRIME: 40EGP"+ "," + "2O NITRO PRIME: 20EGP" + "," +"10 NITRO PRIME: 10EGP";
        data.add(Phone);
        data.add(Amount);
        return data;
    }
}
