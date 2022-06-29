package com.trans.example.transactionExe.dto;


import com.trans.example.transactionExe.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {
    //We Need an Invoice After Successfull Transaction
//We will Get Response Here , After Successfull Transaction
    private String status;
    private double totalFare;
    private String pnrNo;

    private PassengerInfo passengerInfo;
}
