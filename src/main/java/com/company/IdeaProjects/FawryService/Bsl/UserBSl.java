package com.company.IdeaProjects.FawryService.Bsl;
import com.company.IdeaProjects.FawryService.Models.databaseEntity;
import com.company.IdeaProjects.FawryService.Models.transaction;
import com.company.IdeaProjects.FawryService.Models.user;
import com.company.IdeaProjects.FawryService.Payment.*;
import javafx.util.Pair;


import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Objects;

public class UserBSl {
    databaseEntity entity =databaseEntity.getInstance();
    public String SignUP(user user){
        for(int i=0;i<entity.getUserVector().size();i++){
            if(Objects.equals(entity.getUserVector().get(i).getEmail(), user.getEmail())){
                return "THIS USER ALREADY EXIST!";
            }
        }
        entity.getUserVector().add(user);
        return "SIGNUP SUCCESSFULLY !";
    }
    public String signIn(user user){
        for (int i=0;i<entity.getUserVector().size();i++) {
            if (Objects.equals(entity.getUserVector().get(i).getEmail(), user.getEmail()) && Objects.equals(entity.getUserVector().get(i).getPassword(), user.getPassword())) {
                entity.setCurrentUser(entity.getUserVector().get(i));
                return "WELCOME BACK!"+entity.getCurrentUser().getUserName();
            }
        }
        return "PLEASE SIGN UP FIRST!";
    }
    public String addWallet(String amount){
        float AMOUNT=0;
        try {
            if(amount.length()<=0){
                return "PLEASE ENTER AMOUNT!";
            }
            AMOUNT=Float.parseFloat(amount);
        }catch (Exception e){
            return "CHECK YOUR AMOUNT";
        }
        if(entity.getCurrentUser()==null){
            return "YOU SHOULD SIGNIN FIRST!";
        }else {
            entity.saveToWallet(AMOUNT);
            transaction t=new transaction();
            t.setTransactionType("Add to wallet transaction");
            t.setAmountOfTrans(AMOUNT);
            entity.getCurrentUser().getTransactionsVector().add(t);
        }
        return "ADDING amount:"+amount+" SUCCESSFUL YOUR WALLET BALANCE:"+entity.getCurrentUser().getWalletBalance();
    }
    public user ShowCurrentUserData(){
        if(entity.getCurrentUser()!=null){
            return entity.getCurrentUser();
        }
        return null;
    }
    public ArrayList<String> getAllDiscounts(){
        ArrayList<String> Discounts=new ArrayList<>();
        Discounts.add("Overall Discounts:"+entity.getOverallDiscount());
        for (Entry<Integer, Pair<String,Float>> entry : entity.getIDSpecificDiscount().entrySet()) {
              Discounts.add("Specific Discount for "+entry.getValue().getKey()+":"+entry.getValue().getValue());
        }

        return Discounts;
    }
    public ArrayList<String> PaymentMethod(String ID){
        int id;
        iPayment iPay;
        float TotalPayment;
        String PaymentWay;
        ArrayList<String> message=new ArrayList<>();
        if(entity.getCurrentUser()==null){
            message.add("YOU SHOULD SIGNIN FIRST!");
            return message;
        }else{
            try {
                if(ID.length()<=0){
                    message.add("PLEASE ENTER ID!");
                    return message;
                }
                id=Integer.parseInt(ID);
            }catch (Exception e){
                message.add("CHECK YOUR ID");
                return message;
            }
            if(id==2){
                iPay=new CashPayment();
                iPay=new OverallDiscounts(iPay);
                iPay=new SpecificDiscount(iPay);
                TotalPayment=iPay.pay(getTransactions());
                PaymentWay="CashPayment";
            }else if(id==3){
                if(entity.getCurrentUser().getWalletBalance()==0){
                    message.add("YOUR WALLET BALANCE IS EMPTY");
                    return message;
                }
                iPay=new WalletPayment();
                iPay=new OverallDiscounts(iPay);
                iPay=new SpecificDiscount(iPay);
                TotalPayment=iPay.pay(getTransactions());
                PaymentWay=" WalletPayment";
                if(entity.getCurrentUser().getWalletBalance()<TotalPayment){
                    message.add("YOUR WALLET BALANCE IS NOT ENOUGH");
                    return message;
                }
                float sub=entity.getCurrentUser().getWalletBalance()-TotalPayment;
                entity.getCurrentUser().setWalletBalance(sub);
            }else{
                iPay=new creditCard();
                iPay=new OverallDiscounts(iPay);
                iPay=new SpecificDiscount(iPay);
                TotalPayment=iPay.pay(getTransactions());
                PaymentWay="Via creditCard";
            }
        }
        if(TotalPayment==0){
            message.add("YOU SHOULD COMPLETE FORM AND ADD AMOUNT TO PAY");
            return message;
        }
        transaction t=getTransactions();
        t.setWayOfPayment(PaymentWay);
        t.setAmountOfTrans(TotalPayment);
        t.setTransactionServiceType(entity.getCurrentUser().getLastFormProvider()+" "+entity.getCurrentUser().getLastOpenFormService());
        entity.getCurrentUser().getTransactionsVector().add(t);

        if(entity.getOverallDiscount()!=0){
            String discount="AFTER ADDING OVER ALL DISCOUNT:"+entity.getOverallDiscount()+"%";
            message.add(discount);
        }
        float SPdis= GETSpecialDiscountAmount(entity.getCurrentUser().getLastOpenFormService());
        if(SPdis!=0){
            String discount="SPECIFIC DISCOUNT FOR:"+entity.getCurrentUser().getLastOpenFormService()+":"+SPdis+"%";
            message.add(discount);
        }
        entity.getCurrentUser().setUserCurrentAmount(0F);
        message.add("YOUR ALL TOTAL PAYMENT:"+TotalPayment);
        return message;
    }
    public ArrayList<transaction> ShowPaymentTransactions(){
        ArrayList<transaction> PaymentTransaction=new ArrayList<>();
        for(int i=0;i<entity.getCurrentUser().getTransactionsVector().size();i++){
            if(Objects.equals(entity.getCurrentUser().getTransactionsVector().get(i).getTransactionType(), "Payment transaction")){
                PaymentTransaction.add(entity.getCurrentUser().getTransactionsVector().get(i));
            }
        }
        return  PaymentTransaction;

    }
    public String MakeRefund(String transactionId){
        if(entity.getCurrentUser()==null){
            return "YOU SHOULD SIGNIN FIRST!";
        }
        float TransactionId=0;
        try {
            if(transactionId.length()<=0){
                return "PLEASE ENTER AMOUNT!";
            }
            TransactionId=Float.parseFloat(transactionId);
        }catch (Exception e){
            return "CHECK YOUR TRANSACTION ID";
        }
        for(int i=0;i<entity.getCurrentUser().getTransactionsVector().size();i++){
            if(entity.getCurrentUser().getTransactionsVector().get(i).getId()==TransactionId&&entity.getCurrentUser().getTransactionsVector().get(i).getTransactionType()=="Payment transaction"){
                entity.getCurrentUser().getTransactionsVector().get(i).setTransactionType("Refund transaction");
                entity.getCurrentUser().getTransactionsVector().get(i).setTransactionStatus("Waiting Response");
                Pair<Integer,transaction> Prefund=new Pair<>(entity.getCurrentUser().getId(),entity.getCurrentUser().getTransactionsVector().get(i));
                entity.getRefundTransaction().add(Prefund);
                return "YOUR REFUND REQUEST SEND SUCCESSFULLY";
            }
        }
        return "DO NOT FOUND YOUR TRANSACTION PLEASE CHECK YOUR ID";
    }

    private transaction getTransactions(){
        transaction t=new transaction();
        t.setTransactionType("Payment transaction");
        t.setTransactionServiceType(entity.getCurrentUser().getLastOpenFormService());
        t.setAmountOfTrans(entity.getCurrentUser().getUserCurrentAmount());
        return t;
    }
    private float GETSpecialDiscountAmount(String SpecialDiscount){
        for (Entry<Integer, Pair<String,Float>> entry : entity.getIDSpecificDiscount().entrySet()) {
            if (Objects.equals(entry.getValue().getKey(), SpecialDiscount)){
                return entry.getValue().getValue();
            }
        }
        return 0.0F;
    }

}
