package com.zrs.demo.ssm.services;

import com.zrs.demo.ssm.domain.Payment;
import com.zrs.demo.ssm.domain.PaymentEvent;
import com.zrs.demo.ssm.domain.PaymentState;
import com.zrs.demo.ssm.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author zrs
 */
@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @RepeatedTest(10)
    void authTest() {
        Payment savedPayment = paymentService.newPayment(payment);
        StateMachine<PaymentState, PaymentEvent> preAuthSm = paymentService.preAuth(savedPayment.getId());
        if (preAuthSm.getState().getId() == PaymentState.PRE_AUTH) {
            System.out.println("Payment is Pre Authorized");
            StateMachine<PaymentState, PaymentEvent> authSm = paymentService.preAuth(savedPayment.getId());
            System.out.println("Result of Auth: " + authSm.getState().getId());
        } else {
            System.out.println("Payment failed pre-auth...");
        }
    }
}