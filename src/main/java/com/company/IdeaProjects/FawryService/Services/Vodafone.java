package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class Vodafone implements IservicesProvider {

	@Override
	public Iform Createform(int type) {
		if(type==1) {
			return new VodafoneMobileForm();
		}else if(type==2){
			return new VodafoneInternetForm();
		}
		return null;
	}

	@Override
	public Ihandler CreateHandler(int type, ArrayList<String> Data) {
		if(type==1) {
			return new VodafoneMobileHandler();
		}else if(type==2){
			return new VodafoneInternetHandler();
		}
		return null;
	}

}
