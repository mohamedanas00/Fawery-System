package com.company.IdeaProjects.FawryService.Payment;

import com.company.IdeaProjects.FawryService.Models.transaction;
import com.company.IdeaProjects.FawryService.Payment.iPayment;

public class CashPayment implements iPayment {
    private float totalPayment;
    @Override
    public float pay(transaction transaction) {
        totalPayment= transaction.getAmountOfTrans();
        return totalPayment;
    }
}
