package com.trans.example.transactionExe.utils;

import com.trans.example.transactionExe.exception.NullPointerException;

import java.util.Arrays;
import java.util.List;

public class PassengerUtils {

    public static boolean ValidatePassengerInfo(String pasName){
        if(pasName.isBlank()){
            throw new java.lang.NullPointerException("Enter the data properly");
        }else {
            return true;
        }
    }
    public static void validateEmail(String passEmail){
        if (!isDomainValid(passEmail)){
            throw new NullPointerException(" Null Pointer Exception Occured...!!");
        }
    }
    private static boolean isDomainValid(String passEmail){
        List<String> validDomains = Arrays.asList("gmail.com","yahoo.com","outlook.com");
        if (validDomains.contains(passEmail.substring(passEmail.indexOf("@")+1))){
            return true;
        }
        throw new NullPointerException("Enter Valid email...!!!");
    }
//    public String ChangeEmail(int passId, String passEmail){
//    Result<passEmail>emailResult =passEmail.Create(passEmail);
//    if (emailResult.IsFailure)
//        return "emila";
//
//        }
}
