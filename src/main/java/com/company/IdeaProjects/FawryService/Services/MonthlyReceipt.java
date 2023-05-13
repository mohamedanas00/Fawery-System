package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class MonthlyReceipt implements IservicesProvider
{
    @Override
    public Iform Createform(int type) {
        if(type==1) {
            return new MonthlyLandlineForm();
        }
        return null;
    }
    @Override
    public Ihandler CreateHandler(int type, ArrayList<String> Data) {
        if(type==1) {
            return new MonthlyLandlineHandler();
        }
        return null;
    }

}
