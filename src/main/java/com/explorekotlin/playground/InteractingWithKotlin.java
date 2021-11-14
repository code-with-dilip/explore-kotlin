package com.explorekotlin.playground;


import com.explorekotlin._10interoperability.CommonUtilities;
import com.explorekotlin._10interoperability.ReturningCustomer;
import com.explorekotlin._10interoperability.ReturningCustomerKt;
import com.explorekotlin.domain.CustomerJava;

public class InteractingWithKotlin {

    public static void main(String[] args) {

        //KotlinTopLevelFunctionsKt.prefix("abc", "def");
        var result = CommonUtilities.prefix("abc", "def");
        System.out.println("result :" + result);

        System.out.println(CommonUtilities.getName());
        System.out.println(CommonUtilities.NAME_CONSTANT);

        var returningCustomer = new ReturningCustomer(1, "dilip", "dilip@gmail.com");

        ReturningCustomerKt.extenstion(returningCustomer);

    }
}
