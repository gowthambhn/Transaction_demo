package com.trans.example.transactionExe.utils;

import com.trans.example.transactionExe.exception.InsufficientAmountException;


import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    public static Map<String, Double> paymentMap = new HashMap<>();
// FourUsers with Four Accounts
    static {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 9000.0);
        paymentMap.put("acc4", 8000.0);
    }



    public static boolean validateCreditLimit(String accNo, double paidAmount) {
        if (paidAmount > paymentMap.get(accNo)) {
            throw new InsufficientAmountException("Insufficient fund..!");
        } else {
            return true;
        }
    }


}

