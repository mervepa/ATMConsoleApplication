package com.merveparlak.atm.utilizations;

import com.merveparlak.atm.customerclasses.CorporateCustomer;
import com.merveparlak.atm.customerclasses.Customer;
import com.merveparlak.atm.customerclasses.IndividualCustomer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerInfos {

    public static Map<String, Customer> getCustomerInfo() throws IOException {

        Map<String, Customer> accountInfos = new HashMap<>();

        File customerData = new File("Customers.csv");
        try {
            FileReader fileReader = new FileReader(customerData);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (int i=0; i<5; i++){
                String[] line = bufferedReader.readLine().split(",", 6);

                if(line[0].equals("Individual")){
                    accountInfos.put(line[5],new IndividualCustomer(line[1],line[2], Integer.parseInt(line[3]),line[4]));
                }
                else{
                    accountInfos.put(line[5],new CorporateCustomer(line[1],line[2],Integer.parseInt(line[3]),line[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountInfos;
    }


}
