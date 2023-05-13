package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class SchoolDonationForm extends Iform
{
    @Override
    public ArrayList<String> createForm() {
        String Phone="Enter your Phone Number:";
        String Name="Enter School Name:";
        String Code="Enter School Zip Code:";
        String Amount="Enter your Amount FROM 1-10000:";
        data.add(Phone);
        data.add(Name);
        data.add(Code);
        data.add(Amount);
        return data;
    }
}
