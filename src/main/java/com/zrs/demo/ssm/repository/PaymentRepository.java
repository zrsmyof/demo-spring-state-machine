package com.zrs.demo.ssm.repository;

import com.zrs.demo.ssm.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zrs
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
