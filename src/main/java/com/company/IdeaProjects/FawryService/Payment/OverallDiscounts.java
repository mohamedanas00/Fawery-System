package com.company.IdeaProjects.FawryService.Payment;

import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.transaction;
import com.company.IdeaProjects.FawryService.Payment.Decorator;
import com.company.IdeaProjects.FawryService.Payment.iPayment;

public class OverallDiscounts extends Decorator {
    iPayment iPayment;
    private float totalPayment;
    databaseEntity entity =databaseEntity.getInstance();

    public OverallDiscounts(com.company.IdeaProjects.FawryService.Payment.iPayment iPayment) {
        this.iPayment = iPayment;
    }

    @Override
    public float pay(transaction transaction) {
        float dis=entity.getOverallDiscount()/100;
        totalPayment=iPayment.pay(transaction)*dis;
        return iPayment.pay(transaction)-totalPayment;
    }
}
