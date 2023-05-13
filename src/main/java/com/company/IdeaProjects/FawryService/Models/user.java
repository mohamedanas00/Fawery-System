package com.company.IdeaProjects.FawryService.Models;

import java.util.Vector;

public class user {
    private static int ID=1;
    private int id;
    String userName;
    String email;
    String Password;
    float walletBalance=0;
    float userCurrentAmount=0;
    String lastOpenFormService =null;
    String lastFormProvider=null;
    Vector<transaction>transactionsVector=new Vector<>();

    public user(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        Password = password;
        id=ID;
        ID++;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return Password;
    }


    public float getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(float walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getLastOpenFormService() {
        return lastOpenFormService;
    }

    public void setLastOpenFormService(String lastOpenFormService) {
        this.lastOpenFormService = lastOpenFormService;
    }

    public float getUserCurrentAmount() {
        return userCurrentAmount;
    }

    public void setUserCurrentAmount(float userCurrentAmount) {
        this.userCurrentAmount = userCurrentAmount;
    }

    public Vector<transaction> getTransactionsVector() {
        return transactionsVector;
    }

    public String getLastFormProvider() {
        return lastFormProvider;
    }

    public void setLastFormProvider(String lastFormProvider) {
        this.lastFormProvider = lastFormProvider;
    }



}
