package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class NGOs implements IservicesProvider
{
    @Override
    public Iform Createform(int type) {
        if(type==1) {
            return new NGOForm();
        }
        return null;
    }
    @Override
    public Ihandler CreateHandler(int type, ArrayList<String> Data) {
        if(type==1) {
            return new NGOHandler();
        }
        return null;
    }
}
