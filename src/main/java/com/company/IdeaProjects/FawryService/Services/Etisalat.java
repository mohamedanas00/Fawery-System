package com.company.IdeaProjects.FawryService.Services;
import java.util.ArrayList;

public class Etisalat implements IservicesProvider {
    @Override
    public Iform Createform(int type) {
        if(type==1) {
            return new EtisalatMobileForm();
        }else if(type==2){
            return new EtisalatInternetForm();
        }
        return null;
    }

    @Override
    public Ihandler CreateHandler(int type, ArrayList<String> Data) {
        if(type==1) {
            return new EtisalatMobileHandler();
        }else if(type==2){
            return new EtisalatInternetHandler();
        }
        return null;
    }
}
