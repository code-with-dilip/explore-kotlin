package com.explorekotlin.playground;


import com.explorekotlin._10interoperability.CommonUtilities;
import com.explorekotlin._10interoperability.ReturningCustomer;
import com.explorekotlin._10interoperability.ReturningCustomerKt;
import com.explorekotlin._3classes.Customer;

import java.io.IOException;

public class InteractingWithKotlin {

    public static void main(String[] args) {

        Customer customer = new Customer(1, "dilip",
                "abc@dilip.com", 1987);

        customer.setName("dilp1");
        customer.property = "abc";

        customer.printString("abc");
        customer.printString();
        customer.changedName();
        readFile(customer);

        involeToplevelFunction();
        invokeTopLevelVariables();
        invokeExtensionFunction();

    }

    private static void readFile(Customer customer) {

        try{
            customer.readFile("");
        }catch (IOException ex){

        }
    }

    private static void invokeTopLevelVariables() {
        System.out.println(CommonUtilities.getName());
        System.out.println(CommonUtilities.NAME_CONSTANT);
    }

    private static void invokeExtensionFunction() {
        var returningCustomer = new ReturningCustomer(1, "dilip", "dilip@gmail.com");
        ReturningCustomerKt.extenstion(returningCustomer);
    }

    private static void involeToplevelFunction() {
        var result = CommonUtilities.prefix("abc", "def");
        System.out.println("result :" + result);
    }
}
