package com.merveparlak.atm.utilizations;

import com.merveparlak.atm.customerclasses.CorporateCustomer;
import com.merveparlak.atm.customerclasses.Customer;
import com.merveparlak.atm.customerclasses.IndividualCustomer;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class MainOperations {

    public static void main(String[] args) throws IOException {

        System.out.println("---------------Welcome-------------\n");

        Map<String, Customer> accountInfos = CustomerInfos.getCustomerInfo();

        System.out.println("Please Enter Customer Number :");

        Scanner scanner = new Scanner(System.in);
        String customerNum = scanner.nextLine();

        Actions actions = new Actions(scanner, accountInfos);

        if(!accountInfos.containsKey(customerNum)){

            System.out.println("Customer Not Found!");
        }

        if(accountInfos.get(customerNum) instanceof IndividualCustomer){
            ((IndividualCustomer)accountInfos.get(customerNum)).showCustomerInfos();
        }
        else{
            ((CorporateCustomer)accountInfos.get(customerNum)).showCustomerInfos();
        }


        System.out.println("Choose Your Action:");
        System.out.println("Deposit Money :'1' \nWithdraw Money : '2'");
        String choice = scanner.nextLine();
        actions.setCustomerNum(customerNum);
        switch (choice){
            case "1":
                actions.depositAction();
                break;
            case "2":
                actions.withDrawAction();
                break;
            default:
                System.out.println("Please enter a valid choice (1 or 2)");
        }
    }

}

