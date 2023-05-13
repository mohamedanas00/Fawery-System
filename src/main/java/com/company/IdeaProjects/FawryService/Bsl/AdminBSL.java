package com.company.IdeaProjects.FawryService.Bsl;

import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.transaction;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class AdminBSL {
    databaseEntity entity =databaseEntity.getInstance();
    public ArrayList<String> getAllUsersData(){
        String data;
        ArrayList<String> UsersData=new ArrayList<>();
        for(int i=0;i<entity.getUserVector().size();i++){
            data = "ID:"+entity.getUserVector().get(i).getId()+" ,UserName:"+entity.getUserVector().get(i).getUserName()+" ,Email:"+entity.getUserVector().get(i).getEmail();
            UsersData.add(data);
        }
        return UsersData;
    }
    public String UpdateOverAllDiscount(String amount){
        float AMOUNT=0;
        try {
            if(amount.length()<=0){
                return "PLEASE ENTER AMOUNT!";
            }
            AMOUNT=Float.parseFloat(amount);
        }catch (Exception e){
            return "CHECK YOUR AMOUNT";
        }
        entity.setOverallDiscount(AMOUNT);
        return "ADDING SUCESSEFULY";
    }
    public ArrayList<transaction> ShowUserTransaction(int UserID,int TransactionID){
        ArrayList<transaction>t=new ArrayList<>();
        for(int i=0;i<entity.getUserVector().size();i++){
            if(entity.getUserVector().get(i).getId()==UserID){
                for(int j=0;j<entity.getUserVector().get(i).getTransactionsVector().size();j++){
                    if(GetTransactionName(TransactionID)!=null){
                        String Tname= GetTransactionName(TransactionID);
                        if(Objects.equals(entity.getUserVector().get(i).getTransactionsVector().get(j).getTransactionType(), Tname)){
                            t.add(entity.getUserVector().get(i).getTransactionsVector().get(j));
                        }

                    }
                }
            }
        }
        return t;
    }
    public String AddingSpecificDiscount(ArrayList<String> arr){
        float amount=0F;
        int id=0;
        try {
            if(arr.size()<=0){
                return "PLEASE ENTER DATA!";
            }
            id=Integer.parseInt(arr.get(0));
            amount=Float.parseFloat(arr.get(1));
        }catch (Exception e){
            return "CHECK YOUR ID OR AMOUNT!";
        }

        for (Map.Entry<Integer, Pair<String,Float>> entry : entity.getIDSpecificDiscount().entrySet()) {
            if (Objects.equals(entry.getKey(), id)){
                String sp=entry.getValue().getKey();
                Pair<String,Float> P1=new Pair<>(sp,amount);
                entry.setValue(P1);
                return "ADDING SUCCESSFULLY";
            }
        }
        return "YOUR OPERATION ARE FAILED CHECK TOUR ID";
    }
    public ArrayList<transaction> ShowRefundRequests(){
        ArrayList<transaction> T=new ArrayList<>();
        for(int i=0;i<entity.getRefundTransaction().size();i++){
            T.add(entity.getRefundTransaction().get(i).getValue());
        }
        return T;
    }
    public String SetRefundStatus(ArrayList<String>arr) {
        int key = 0;
        boolean status;
        try {
            if(arr.size()<=0){
                return "PLEASE ENTER DATA!";
            }
            key=Integer.parseInt(arr.get(0));
            status=Boolean.parseBoolean(arr.get(1));
        }catch (Exception e){
            return "CHECK YOUR ID OR Status: true or false!";
        }

        int userID = 0;
        boolean check = false;
        boolean type = false;
        for (int i = 0; i < entity.getRefundTransaction().size(); i++) {
            if (entity.getRefundTransaction().get(i).getValue().getId() == key) {
                userID = entity.getRefundTransaction().get(i).getKey();
                if (status) {
                    entity.getRefundTransaction().get(i).getValue().setTransactionStatus("Accepted");
                    type = true;
                } else {
                    entity.getRefundTransaction().get(i).getValue().setTransactionStatus("Refused");
                    type = false;

                }
                entity.getRefundTransaction().remove(i);
                check = true;
                break;
            }
        }
        if (check) {
            for (int i = 0; i < entity.getUserVector().size(); i++) {
                if (entity.getUserVector().get(i).getId() == userID) {
                    for (int j = 0; j < entity.getUserVector().get(i).getTransactionsVector().size(); j++) {
                        if(entity.getUserVector().get(i).getTransactionsVector().get(j).getId()==key){
                            if(type){
                                entity.getUserVector().get(i).getTransactionsVector().get(j).setTransactionStatus("Accepted");
                                if(Objects.equals(entity.getUserVector().get(i).getTransactionsVector().get(j).getWayOfPayment(), " WalletPayment")){
                                    float wallet=entity.getUserVector().get(i).getWalletBalance()+entity.getUserVector().get(i).getTransactionsVector().get(j).getAmountOfTrans();
                                    entity.getUserVector().get(i).setWalletBalance(wallet);
                                    return "REFUND RESPONSE ACCEPTED AND AMOUNT BACK TO USER WALLET PAYMENT";
                                }else if(Objects.equals(entity.getUserVector().get(i).getTransactionsVector().get(j).getWayOfPayment(), " Via CreditCard")){
                                    return "REFUND RESPONSE ACCEPTED AND AMOUNT BACK TO USER via CreditCard";
                                }else{
                                    return "REFUND RESPONSE ACCEPTED AND USER SHOULD TAKE CASH FROM BRANCH";
                                }
                            }else{
                                entity.getUserVector().get(i).getTransactionsVector().get(j).setTransactionStatus("Refused");
                                return "REFUND RESPONSE REFUSED SEND TO USER";
                            }
                        }
                    }
                }
            }
        }
        return "CHECK TRANSACTION ID OR YOUR ACCPTED ENTER true REFUSED ENTER false";
    }


    private String GetTransactionName(int id){
        for (Map.Entry<Integer,String> entry : entity.getIDTransactions().entrySet()) {
            if (Objects.equals(id, entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }



}
