package com.company.IdeaProjects.FawryService.Bsl;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;


import java.util.ArrayList;
import java.util.Objects;

public class ServicesBSL {
    databaseEntity entity =databaseEntity.getInstance();
    private boolean isMatching(String input,String Service){
        int firstChar=input.charAt(0);
        for(int i=0;i<Service.length();i++){
            if(Service.charAt(i)==firstChar){
                int z=i;
                int totalChar=0;
                for(int j=0;j<input.length()&&z<Service.length();j++){
                    if(input.charAt(j)==Service.charAt(z)){
                        totalChar++;
                    }else {
                        break;
                    }
                    z++;
                }
                if(totalChar==input.length()){
                    return true;
                }
            }

        }
        return false;
    }
    public ArrayList<String> Search(String serviceInput){
        String swap=serviceInput.toUpperCase();
        String result;
        ArrayList<String> listOfServices=new ArrayList<>();
        for(int i = entity.getServicesTypes().size() - 1; i >= 0; i--){
            if(isMatching(swap,entity.getServicesTypes().get(i).getName())){
                result="ID:"+entity.getServicesTypes().get(i).getId()+" & "+"NAME:"+entity.getServicesTypes().get(i).getName();
                listOfServices.add(result);
            }
        }
        return listOfServices;
    }
    public ArrayList<String> getForm(int id){
        ArrayList<String> message=new ArrayList<>();
        if(entity.getCurrentUser()==null){
            message.add("YOU SHOULD SIGNIN FIRST!");
            return message;
        }
        ArrayList<String> form=new ArrayList<>();
        for(int i=0;i<entity.getServicesTypes().size();i++){
            if(entity.getServicesTypes().get(i).getId()==id){
                return entity.getServicesTypes().get(i).getIform().createForm();
            }

        }

        return null;
    }
    public String CompleteForm(ArrayList<String> dataForm){
        int id=0;
        try {
            if(dataForm.size()<=0){
                return "PLEASE ENTER DATA!";
            }
            id=Integer.parseInt(dataForm.get(0));
            dataForm.remove(0);
        }catch (Exception e){
            return "PLEASE CHECK YOUR ID ";
        }
        if(entity.getCurrentUser()==null){
            return "YOU SHOULD SIGNIN FIRST!";
        }
        for(int i=0;i<entity.getServicesTypes().size();i++){
            if(entity.getServicesTypes().get(i).getId()==id){
                //add amount to use it in payment
                if(Objects.equals(entity.getServicesTypes().get(i).getIhandler().Handler(dataForm), "YOUR DATA IS CORRECT,PLEASE PROCEED TO PAYMENT")){
                    int size=dataForm.size()-1;
                    int amount=Integer.parseInt(dataForm.get(size));
                    entity.getCurrentUser().setLastOpenFormService(takeName(entity.getServicesTypes().get(i).getName()));
                    entity.getCurrentUser().setUserCurrentAmount(amount);
                }
                return  entity.getServicesTypes().get(i).getIhandler().Handler(dataForm);
            }
        }
        return "NO MATCHING ID FOUND!";
    }
    public String takeName(String name){
        String result = null;
        String serviceProvider = "";
        for (int i=0;i<name.length();i++){
            if(name.charAt(i)!=' '){
                serviceProvider+=name.charAt(i);
            }else{
                entity.getCurrentUser().setLastFormProvider(serviceProvider);
                break;
            }
        }
        for(int i=0;i<name.length();i++){
            if(name.charAt(i)==' '){
                result=name.substring(i+1);
                break;
            }
        }
        return result;
    }
}
