package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class QuarterLandlineHandler extends Ihandler
{
    @Override
    public String Handler(ArrayList<String> data) {
        for(int i = 0; i< data.get(0).length(); i++){
            if(data.get(0).length()!=10){
                return "YOUR NUMBER DIGIT MUST BE 10";
            }
            if(Character.isLetter(data.get(0).charAt(i))){
                return "YOUR NUMBER SHOULD NOT HAVE CHARACTERS !";
            }
            if(data.get(0).charAt(0)!='0'|| data.get(0).charAt(1)!='2') {
                return  "YOUR NUMBER SHOULD START WITH 02";
            }

        }
        int amount=Integer.parseInt(data.get(1));
        if(!(amount>=500&&amount<=1000)) {
            return "YOUR AMOUNT RANGE SHOULD BE FROM 500-1000";
        }
        return "YOUR DATA IS CORRECT,PLEASE PROCEED TO PAYMENT";
    }
}
