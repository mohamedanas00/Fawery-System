package com.company.IdeaProjects.FawryService.Models;

public class transaction {
    private static int ID=1;
    private int id;
    String transactionType;
    String transactionServiceType;
    String wayOfPayment;
    String TransactionStatus="none";
    float amountOfTrans;
    public transaction(){
        id=ID;
        ID++;
    }

    public int getId() {
        return id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public float getAmountOfTrans() {
        return amountOfTrans;
    }

    public void setAmountOfTrans(float amountOfTrans) {
        this.amountOfTrans = amountOfTrans;
    }

    public String getTransactionServiceType() {
        return transactionServiceType;
    }

    public void setTransactionServiceType(String transactionServiceType) {
        this.transactionServiceType = transactionServiceType;
    }
    public String getWayOfPayment() {
        return wayOfPayment;
    }
    public void setWayOfPayment(String wayOfPayment) {
        this.wayOfPayment = wayOfPayment;
    }

    public void setTransactionStatus(String transactionStatus) {
        TransactionStatus = transactionStatus;
    }

    public String getTransactionStatus() {
        return TransactionStatus;
    }
}
