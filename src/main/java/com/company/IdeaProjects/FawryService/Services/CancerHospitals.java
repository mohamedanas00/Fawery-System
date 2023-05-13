package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class CancerHospitals implements IservicesProvider
{
    @Override
    public Iform Createform(int type) {
        if(type==1) {
            return new CancerHospitalDonationForm();
        }
        return null;
    }
    @Override
    public Ihandler CreateHandler(int type, ArrayList<String> Data) {
        if(type==1) {
            return new CancerHospitalDonationHandler();
        }
        return null;
    }

}
