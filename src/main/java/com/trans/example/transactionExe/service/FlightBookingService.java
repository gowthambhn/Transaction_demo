package com.trans.example.transactionExe.service;

import com.trans.example.transactionExe.dto.FlightBookingAcknowledgement;
import com.trans.example.transactionExe.dto.FlightBookingRequest;
import com.trans.example.transactionExe.entity.PassengerInfo;
import com.trans.example.transactionExe.entity.PaymentInfo;
import com.trans.example.transactionExe.repository.PassengerInfoRepository;
import com.trans.example.transactionExe.repository.PaymentInfoRepository;
import com.trans.example.transactionExe.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}

