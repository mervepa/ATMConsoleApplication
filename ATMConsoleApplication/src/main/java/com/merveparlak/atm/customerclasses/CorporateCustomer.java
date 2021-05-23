package com.merveparlak.atm.customerclasses;

public class CorporateCustomer extends Customer {

    private String nameOfCorporation;

    public CorporateCustomer(String identificationNum, String nameSurname, int balanceOfAccount, String nameOfCorporation) {
        super(identificationNum, nameSurname, balanceOfAccount);
        this.nameOfCorporation = nameOfCorporation;
    }
    public void showCustomerInfos(){

        System.out.println("---------------Customer Infos--------------\n");
        System.out.println("Identification Number : " + this.getIdentificationNum());
        System.out.println("Name Surname :  " + this.getNameSurname());
        System.out.println("Balance of Account : " + this.getBalanceOfAccount());
        System.out.println("Address of Customer :" + this.getNameOfCorporation());
        System.out.println("Type of Customer is Corporate");
    }

    public String getNameOfCorporation() {
        return nameOfCorporation;
    }

    public void setNameOfCorporation(String nameOfCorporation) {
        this.nameOfCorporation = nameOfCorporation;
    }
}
