package com.trans.example.transactionExe.repository;

import com.trans.example.transactionExe.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}

