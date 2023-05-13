package com.company.IdeaProjects.FawryService.Models;

import com.company.IdeaProjects.FawryService.Services.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

public class databaseEntity {
       Vector<user>userVector=new Vector<>();
       private static HashMap<Integer,String> PaymentType = new HashMap<Integer,String>();
       private static HashMap<Integer,String> IDTransactions = new HashMap<Integer,String>();
       private static HashMap<Integer, Pair<String,Float>> SpecificDiscount = new HashMap<Integer,Pair<String,Float>>();
       private ArrayList<Pair<Integer,transaction>> RefundTransaction=new ArrayList<>();
       private static databaseEntity entity =null;
       private  user currentUser=null;
       private float OverallDiscount=0;
       private static   Vector<servicesType> servicesTypes=new Vector<>();
       private static Pair<String,Float> P1=new Pair<>("MOBILE RECHARGE",0.0F);
       private static Pair<String,Float> P2=new Pair<>("INTERNET PAYMENT",0.0F);
       private static Pair<String,Float> P3=new Pair<>("LANDLINE SERVICES",0.0F);
       private static Pair<String,Float> P4=new Pair<>("DONATIONS",0.0F);


       public static databaseEntity getInstance(){
              if(entity==null){
                     entity=new databaseEntity();
                     SpecificDiscount.put(1,P1);
                     SpecificDiscount.put(2,P2);
                     SpecificDiscount.put(3,P3);
                     SpecificDiscount.put(4,P4);
                     PaymentType.put(1,"Via CreditCard");
                     PaymentType.put(2,"CashPayment");
                     PaymentType.put(3,"WalletPayment");
                     IDTransactions.put(1,"Payment transaction");
                     IDTransactions.put(2,"Add to wallet transaction");
                     IDTransactions.put(3,"Refund transaction");
                     servicesTypes.add(new servicesType("WE MOBILE RECHARGE",new WeMobileForm(),new WeMobileHandler()));
                     servicesTypes.add(new servicesType("VODAFONE MOBILE RECHARGE",new VodafoneMobileForm(),new VodafoneMobileHandler()));
                     servicesTypes.add(new servicesType("ORANGE MOBILE RECHARGE",new OrangeMobileForm(),new OrangeMobileHandler()));
                     servicesTypes.add(new servicesType("ETISALAT MOBILE RECHARGE",new EtisalatMobileForm(),new EtisalatMobileHandler()));
                     servicesTypes.add(new servicesType("ETISALAT INTERNET PAYMENT",new EtisalatInternetForm(),new EtisalatInternetHandler()));
                     servicesTypes.add(new servicesType("ORANGE INTERNET PAYMENT",new OrangeInternetForm(),new OrangeInternetHandler()));
                     servicesTypes.add(new servicesType("WE INTERNET PAYMENT",new WeInternetForm(),new WeInternetHandler()));
                     servicesTypes.add(new servicesType("VODAFONE INTERNET PAYMENT",new VodafoneInternetForm(),new VodafoneInternetHandler()));
                     servicesTypes.add(new servicesType("MONTHLY LANDLINE SERVICES",new MonthlyLandlineForm(),new MonthlyLandlineHandler()));
                     servicesTypes.add(new servicesType("QUARTER LANDLINE SERVICES",new QuarterLandlineForm(),new QuarterLandlineHandler()));
                     servicesTypes.add(new servicesType("HOSPITALS DONATIONS",new CancerHospitalDonationForm(),new CancerHospitalDonationHandler()));
                     servicesTypes.add(new servicesType("SCHOOLS DONATIONS",new SchoolDonationForm(),new SchoolDonationHandler()));
                     servicesTypes.add(new servicesType("NGOS DONATIONS",new NGOForm(),new NGOHandler()));

              }
              return entity;
       }
       public void setCurrentUser(user currentUser) {
              this.currentUser = currentUser;
       }

       public void setOverallDiscount(float overallDiscount) {


              OverallDiscount = overallDiscount;
       }

       public Vector<user> getUserVector() {
              return userVector;
       }

       public user getCurrentUser() {
              for (int i=0;i<entity.getUserVector().size();i++) {
                     if (Objects.equals(getUserVector().get(i).getEmail(), currentUser.getEmail()) && Objects.equals(getUserVector().get(i).getPassword(),currentUser.getPassword())) {
                            currentUser=getUserVector().get(i);
                     }
              }
              return currentUser;
       }


       public float getOverallDiscount() {
              return OverallDiscount;
       }



       public  Vector<servicesType> getServicesTypes() {
              return servicesTypes;
       }
       public void saveToWallet(float amount){
              float wallet=amount+ getCurrentUser().getWalletBalance();
              getCurrentUser().setWalletBalance(wallet);
       }

       public  HashMap<Integer, String> getPaymentType() {
              return PaymentType;
       }

       public  HashMap<Integer, String> getIDTransactions() {
              return IDTransactions;
       }

       public HashMap<Integer, Pair<String,Float>> getIDSpecificDiscount() {
              return SpecificDiscount;
       }

       public ArrayList<Pair<Integer, transaction>> getRefundTransaction() {
              return RefundTransaction;
       }

}
