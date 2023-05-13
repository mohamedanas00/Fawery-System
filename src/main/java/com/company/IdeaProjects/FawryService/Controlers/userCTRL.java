package com.company.IdeaProjects.FawryService.Controlers;
import com.company.IdeaProjects.FawryService.Bsl.UserBSl;
import com.company.IdeaProjects.FawryService.Bsl.ServicesBSL;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.transaction;
import com.company.IdeaProjects.FawryService.Models.user;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
@RestController
public class userCTRL {
    databaseEntity entity =databaseEntity.getInstance();
    UserBSl userBSl =new UserBSl();
    ServicesBSL servicesBsl =new ServicesBSL();

    @PostMapping(value = "/signupuser")
    public String SignUPCTRL(@RequestBody user user){
        return userBSl.SignUP(user);
    }

    @PostMapping(value = "/signinuser")
    public String SignInCTRL(@RequestBody user user){
        return userBSl.signIn(user);
    }

    @GetMapping(value = "/searchForServices/{serviceInput}")
    public ArrayList<String> searchMatchingServices(@PathVariable ("serviceInput") String serviceInput){
        return servicesBsl.Search(serviceInput);
    }

    @GetMapping(value = "/choiceForm/{id}")
    public ArrayList<String> choiceService(@PathVariable ("id")int id){
        return servicesBsl.getForm(id);
    }

    @PostMapping(value = "/formInput")
    public String EnterFormData(@RequestBody ArrayList<String> dataForm){
        return servicesBsl.CompleteForm(dataForm);
    }


    @PostMapping(value = "/AddToWallet")
    String AddToWallet(@RequestBody String amount){
        return   userBSl.addWallet(amount);

    }

    @GetMapping(value = "/DiscountWithID")
    public  ArrayList<String>listDiscounts(){
        return userBSl.getAllDiscounts();
    }

    @GetMapping(value = "/showYourData")
    public user ShowYourData(){
        return userBSl.ShowCurrentUserData();
    }

    @GetMapping(value = "/WayOfPaymentMethod")
    public HashMap<Integer, String> ShowWayOfPayment(){
        return entity.getPaymentType();
    }


    @PostMapping(value = "/PaymentMethod")
    public ArrayList<String>  PayForServices(@RequestBody String ID){
        return   userBSl.PaymentMethod(ID);

    }

    @GetMapping(value = "/ViewCurrentUserPaymentTransactions")
    public ArrayList<transaction> ShowPaymentTransactions(){
        return userBSl.ShowPaymentTransactions();
    }

    @PostMapping(value = "/MakeRefundRequest")
    String MakeRefundRequest(@RequestBody String amount){
        return   userBSl.MakeRefund(amount);

    }
}
