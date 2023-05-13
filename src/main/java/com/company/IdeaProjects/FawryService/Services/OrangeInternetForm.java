package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class OrangeInternetForm extends Iform {
    @Override
    public ArrayList<String> createForm() {
        String Phone="Enter your Mobile number:";
        String Amount="CHOOSE YOUR PACKAGE AMOUNT:" + "GO NET 7: 7EGP"+ "," + "GO NET 15: 15EGP" + "," +"GO NET 30: 30EGP" + "," + "GO NET 45: 45EGP";
        data.add(Phone);
        data.add(Amount);
        return data;
    }
}
