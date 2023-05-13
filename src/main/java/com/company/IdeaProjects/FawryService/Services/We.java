package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class We implements IservicesProvider {

	@Override
	public Iform Createform(int type) {
		if(type==1) {
			return new WeMobileForm();
		}else if(type==2){
			return new WeInternetForm();
		}
		return null;
	}

	@Override
	public Ihandler CreateHandler(int type, ArrayList<String> Data) {
		if(type==1) {
			return new WeMobileHandler();
		}else if(type==2){
			return new WeInternetHandler();
		}
		return null;
	}

}
