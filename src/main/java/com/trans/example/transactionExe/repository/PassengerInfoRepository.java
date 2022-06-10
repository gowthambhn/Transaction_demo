package com.trans.example.transactionExe.repository;

import com.trans.example.transactionExe.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
