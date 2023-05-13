package com.company.IdeaProjects.FawryService.Services;

import com.company.IdeaProjects.FawryService.Services.Iform;

import java.util.ArrayList;

public class CancerHospitalDonationForm extends Iform
{
    @Override
    public ArrayList<String> createForm() {
        String Phone = "Enter your Phone Number:";
        String Name="Enter Cancer Hospital Name:";
        String Code="Enter Cancer Hospital Zip Code:";
        String Amount = "Enter your Amount FROM 1-10000:";
        data.add(Phone);
        data.add(Name);
        data.add(Code);
        data.add(Amount);
        return data;
    }
}
