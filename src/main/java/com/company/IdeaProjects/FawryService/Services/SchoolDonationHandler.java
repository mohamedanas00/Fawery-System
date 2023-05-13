package com.company.IdeaProjects.FawryService.Services;

import java.util.ArrayList;

public class SchoolDonationHandler extends Ihandler
{
    @Override
    public String Handler(ArrayList<String> data) {
        for(int i = 0; i< data.get(0).length(); i++){
            if(data.get(0).length()!=11){
                return "YOUR NUMBER DIGIT MUST BE 11";
            }
            if(Character.isLetter(data.get(0).charAt(i))){
                return "YOUR NUMBER SHOULD NOT HAVE CHARACTERS";
            }

        }
        for(int i = 0; i< data.get(2).length(); i++){
            if(data.get(2).length()!=5){
                return "THE ZIP CODE SHOULD BE 5 DIGITS !";
            }
            if(Character.isLetter(data.get(2).charAt(i))){
                return "THE ZIP CODE SHOULD NOT HAVE CHARACTERS";
            }

        }
        int amount=Integer.parseInt(data.get(3));
        if(!(amount>=1&&amount<=10000)) {
            return "YOUR AMOUNT RANGE SHOULD BE FROM 1-10000";
        }
        return "YOUR DATA IS CORRECT,PLEASE PROCEED TO PAYMENT";
    }
}
