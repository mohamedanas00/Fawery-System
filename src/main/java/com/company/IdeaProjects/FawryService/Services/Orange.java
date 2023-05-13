package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class Orange implements IservicesProvider {
    @Override
    public Iform Createform(int type) {
        if(type==1) {
            return new OrangeMobileForm();
        }else if(type==2){
            return new OrangeInternetForm();
        }
        return null;
    }

    @Override
    public Ihandler CreateHandler(int type, ArrayList<String> Data) {
        if(type==1) {
            return new OrangeMobileHandler();
        }else if(type==2){
            return new OrangeInternetHandler();
        }
        return null;
    }
}
