package com.company.IdeaProjects.FawryService.Controlers;
import com.company.IdeaProjects.FawryService.Bsl.AdminBSL;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.transaction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


import javafx.util.Pair;
@RestController
public class adminCTRL {
    databaseEntity entity =databaseEntity.getInstance();
    AdminBSL adminBSL =new AdminBSL();
    @PostMapping(value = "/AddOverallDiscount")
    String updateOverallDiscount(@RequestBody String amount){
        return adminBSL.UpdateOverAllDiscount(amount);
    }
    @GetMapping(value = "/TransactionsTypes")
    public HashMap<Integer, String> ShowWayOfPayment(){
        return entity.getIDTransactions();
    }

    @GetMapping(value = "/UsersData")
    public ArrayList<String> ShowAllUsersID(){
        return adminBSL.getAllUsersData();
    }

    @GetMapping(value = "/listAllUserTransactions/{UserID}/{TransactionID}")
    public  ArrayList<transaction>  listAllUserTransactions(@PathVariable("UserID")int userId , @PathVariable ("TransactionID") int TransactionID){
        return adminBSL.ShowUserTransaction(userId,TransactionID);
    }

    @GetMapping(value = "/listOfSpecificDiscountWithID")
    public  HashMap<Integer,Pair<String,Float>>listOfSpecificDiscount(){
        return entity.getIDSpecificDiscount();
    }

    @PostMapping(value = "/AddingSpecificDiscount")
    String updateSpecificDiscount(@RequestBody ArrayList<String>arr){
        return adminBSL.AddingSpecificDiscount(arr);
    }

    @GetMapping(value = "/listOfRequestTransactions")
    public   ArrayList<transaction> ShowRefundRequests(){
        return adminBSL.ShowRefundRequests();
    }
    @PostMapping(value = "/SetStatusOfRefund")
    String SetStatusOfRefund(@RequestBody ArrayList<String>arr){
        return adminBSL.SetRefundStatus(arr);

    }



}
