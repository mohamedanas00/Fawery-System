package com.company.IdeaProjects.FawryService.Services;

import com.company.IdeaProjects.FawryService.Services.Iform;

import java.util.ArrayList;

public class EtisalatInternetForm extends Iform {
    @Override
    public ArrayList<String> createForm() {
        String Phone="Enter your Mobile number:";
        String Amount="CHOOSE YOUR PACKAGE AMOUNT:"
        +"SUPER MEGA5: 5EGP "+
                ","
                +"SUPER MEGA10: 10EGP " +
                ","
                +"SUPER MEGA20: 20EGP";
        data.add(Phone);
        data.add(Amount);
        return data;
    }
}
