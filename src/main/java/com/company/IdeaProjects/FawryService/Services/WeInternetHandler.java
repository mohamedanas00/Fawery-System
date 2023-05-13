package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class WeInternetHandler extends Ihandler {
    @Override
    public String Handler(ArrayList<String> data) {
        for(int i = 0; i< data.get(0).length(); i++){
            if(data.get(0).length()!=11){
                return "YOUR NUMBER DIGIT MUST BE 11";
            }
            if(Character.isLetter(data.get(0).charAt(i))){
                return "YOUR NUMBER SHOULD NOT HAVE CHARACTERS !";
            }
            if(data.get(0).charAt(0)!='0'|| data.get(0).charAt(1)!='1'|| data.get(0).charAt(2)!='5') {
                return  "YOUR NUMBER SHOULD START WITH 015";
            }

        }
        int amount=Integer.parseInt(data.get(1));
        if(!(amount==40||amount==20||amount==10)) {
            return "PLEASE CHOOSE A PACKAGE AMOUNT!";
        }
        return "YOUR DATA IS CORRECT,PLEASE PROCEED TO PAYMENT";
    }
}
