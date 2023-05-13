package com.company.IdeaProjects.FawryService.Payment;

import com.company.IdeaProjects.FawryService.Models.transaction;
import com.company.IdeaProjects.FawryService.Payment.iPayment;

abstract public class Decorator implements iPayment {
     abstract public float pay(transaction transaction);
}
