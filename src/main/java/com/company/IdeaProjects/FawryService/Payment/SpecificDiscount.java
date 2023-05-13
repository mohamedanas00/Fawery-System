package com.company.IdeaProjects.FawryService.Payment;

import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.transaction;
import com.company.IdeaProjects.FawryService.Payment.Decorator;
import com.company.IdeaProjects.FawryService.Payment.iPayment;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SpecificDiscount extends Decorator {
    iPayment iPayment;


    public SpecificDiscount(com.company.IdeaProjects.FawryService.Payment.iPayment iPayment) {
        this.iPayment = iPayment;
    }
    @Override
    public float pay(transaction transaction) {
        databaseEntity entity =databaseEntity.getInstance();
        float dis=0F;
        for (Map.Entry<Integer, Pair<String,Float>> entry : entity.getIDSpecificDiscount().entrySet()) {
            if (Objects.equals(entry.getValue().getKey(), transaction.getTransactionServiceType())){
                dis= entry.getValue().getValue();
                break;
            }
        }
        float totalPay;
        totalPay=dis;
        totalPay=totalPay/100;
        float totalPayment= transaction.getAmountOfTrans() *totalPay;
        return iPayment.pay(transaction)-totalPayment;
    }
}
