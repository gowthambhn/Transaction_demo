package com.trans.example.transactionExe.dto;


import com.trans.example.transactionExe.entity.PassengerInfo;
import com.trans.example.transactionExe.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;
}
