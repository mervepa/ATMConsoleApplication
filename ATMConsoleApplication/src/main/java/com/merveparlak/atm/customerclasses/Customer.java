package com.merveparlak.atm.customerclasses;

import java.util.Scanner;
import java.util.*;

public class Customer {

    private final String identificationNum;
    private String nameSurname ;
    private int balanceOfAccount;

    public Customer(String identificationNum, String nameSurname, int balanceOfAccount) {
        this.identificationNum = identificationNum;
        this.nameSurname = nameSurname;
        this.balanceOfAccount = balanceOfAccount;
    }

    /* Getter and Setter Methods */

    public String getIdentificationNum() {
        return identificationNum;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getBalanceOfAccount() {
        return balanceOfAccount;
    }

    public void setBalanceOfAccount(int balanceOfAccount) {
        this.balanceOfAccount = balanceOfAccount;
    }
}
