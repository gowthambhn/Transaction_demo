package com.trans.example.transactionExe.service;

import com.trans.example.transactionExe.dto.FlightBookingAcknowledgement;
import com.trans.example.transactionExe.dto.FlightBookingRequest;
import com.trans.example.transactionExe.entity.PassengerInfo;
import com.trans.example.transactionExe.entity.PaymentInfo;
import com.trans.example.transactionExe.exception.InsufficientAmountException;
import com.trans.example.transactionExe.repository.PassengerInfoRepository;
import com.trans.example.transactionExe.repository.PaymentInfoRepository;
import com.trans.example.transactionExe.utils.PassengerUtils;
import com.trans.example.transactionExe.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    //Injecting Both Repositories to Database
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

@Transactional(readOnly = false ,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED ,noRollbackFor = NullPointerException.class)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
 //getting passegerInfo and saving Into DB
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);
 //Payment Info
        PaymentInfo paymentInfo = request.getPaymentInfo();
//        throw new NullPointerException();
//Validating the Amount
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
        PassengerUtils.ValidatePassengerInfo(passengerInfo.getName());
        PassengerUtils.validateEmail(passengerInfo.getEmail());
//        PassengerUtils.ChangeEmail(passengerInfo.getPId(),passengerInfo.getEmail());
//If Transaction successfull
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }

}

