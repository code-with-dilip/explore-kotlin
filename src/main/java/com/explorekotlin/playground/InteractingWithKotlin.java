package com.explorekotlin.playground;


import com.explorekotlin._10interoperability.CommonUtilities;

public class InteractingWithKotlin {

    public static void main(String[] args) {

        //KotlinTopLevelFunctionsKt.prefix("abc", "def");
        var result = CommonUtilities.prefix("abc", "def");
        System.out.println("result :" + result);

        System.out.println(CommonUtilities.getName());
        System.out.println(CommonUtilities.NAME_CONSTANT);


    }
}
