package com.merveparlak.atm.utilizations;

import com.merveparlak.atm.customerclasses.CorporateCustomer;
import com.merveparlak.atm.customerclasses.Customer;
import com.merveparlak.atm.customerclasses.IndividualCustomer;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Actions {
    private static String customerNum;
    private static Map<String, Customer> accountInfos;
    private final Scanner scanner;

    public void setCustomerNum(String customerNum) {
        Actions.customerNum = customerNum;
    }

    public  void depositAction() {

        System.out.print("Enter amount of money:");
        int amountOfMoney = scanner.nextInt();
        accountInfos.get(customerNum).setBalanceOfAccount(accountInfos.get(customerNum).getBalanceOfAccount() + amountOfMoney);
        System.out.println(amountOfMoney + " Amount of Money is Deposited");
        System.out.println("New Balance: "+ accountInfos.get(customerNum).getBalanceOfAccount());
        registerIntoFile();

    }

    public Actions(Scanner scanner,Map<String, Customer> accountInfos) {
        this.scanner = scanner;
        Actions.accountInfos = accountInfos;
    }

    public void withDrawAction() {

        System.out.print("Enter amount of money:");
        int amountOfMoney = scanner.nextInt();
        accountInfos.get(customerNum).setBalanceOfAccount(accountInfos.get(customerNum).getBalanceOfAccount() - amountOfMoney);
        System.out.println(amountOfMoney + " Amount of Money is Withdrew");
        System.out.println("New Balance: "+ accountInfos.get(customerNum).getBalanceOfAccount());
        registerIntoFile();
    }

  private void registerIntoFile(){
      File customerData = new File("Customers.csv");
      try {
          FileWriter fileWriter = new FileWriter(customerData, false);
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
          StringBuilder stringBuilder = new StringBuilder();
          for(Map.Entry<String, Customer> entry : accountInfos.entrySet()){

              if(entry.getValue() instanceof IndividualCustomer){
                  stringBuilder.append("Individual,");
              }
              else{
                  stringBuilder.append("Corporate,");
              }

              stringBuilder.append(entry.getValue().getIdentificationNum()).append(",");
              stringBuilder.append(entry.getValue().getNameSurname()).append(",");
              stringBuilder.append(entry.getValue().getBalanceOfAccount()).append(",");

              if(entry.getValue() instanceof IndividualCustomer){
                 stringBuilder.append(((IndividualCustomer) entry.getValue()).getAdressOfHome()).append(",");
              }
              else{
                 stringBuilder.append(((CorporateCustomer) entry.getValue()).getNameOfCorporation()).append(",");
              }
              stringBuilder.append(entry.getKey()).append("\n");
          }
          bufferedWriter.write(stringBuilder.toString());
          bufferedWriter.flush();
          bufferedWriter.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }


}
