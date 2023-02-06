package com.zrs.demo.ssm.services;

import com.zrs.demo.ssm.domain.Payment;
import com.zrs.demo.ssm.domain.PaymentEvent;
import com.zrs.demo.ssm.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

/**
 * @author zrs
 */
public interface PaymentService {

    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}
