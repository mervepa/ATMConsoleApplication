package com.merveparlak.atm.customerclasses;

public class IndividualCustomer extends Customer {
    private String adressOfHome;

    public IndividualCustomer(String identificationNum, String nameSurname, int balanceOfAccount, String adressOfHome) {
        super(identificationNum, nameSurname, balanceOfAccount);
        this.adressOfHome = adressOfHome;
    }
    public void showCustomerInfos(){

        System.out.println("---------------Customer Infos--------------\n");
        System.out.println("Identification Number : " + this.getIdentificationNum());
        System.out.println("Name Surname :  " + this.getNameSurname());
        System.out.println("Balance of Account : " + this.getBalanceOfAccount());
        System.out.println("Address of Customer :" + this.getAdressOfHome());
        System.out.println("Type of Customer is Individual");
    }

    public String getAdressOfHome() {
        return adressOfHome;
    }

    public void setAdressOfHome(String adressOfHome) {
        this.adressOfHome = adressOfHome;
    }
}
