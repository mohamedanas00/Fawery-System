package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class VodafoneMobileForm extends Iform {


	@Override
	public ArrayList<String> createForm() {
		String Phone="Enter your Mobile number:";
		String Amount="Enter your Amount from 100 to 500:";
		data.add(Phone);
		data.add(Amount);
		return data;
	}

}
