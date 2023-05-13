package com.company.IdeaProjects.FawryService.Payment;

import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.transaction;
import com.company.IdeaProjects.FawryService.Payment.iPayment;

public class WalletPayment implements iPayment {
    private float totalPayment;
    databaseEntity entity =databaseEntity.getInstance();
    @Override
    public float pay(transaction transaction) {
        totalPayment= transaction.getAmountOfTrans();
        return totalPayment;
    }

}
