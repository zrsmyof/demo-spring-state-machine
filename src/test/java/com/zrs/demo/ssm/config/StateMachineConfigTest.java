package com.zrs.demo.ssm.config;

import com.zrs.demo.ssm.domain.PaymentEvent;
import com.zrs.demo.ssm.domain.PaymentState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zrs
 */
@SpringBootTest
class StateMachineConfigTest {

    @Autowired
    StateMachineFactory<PaymentState, PaymentEvent> factory;

    @Test
    void newStateMachineTest() {
        StateMachine<PaymentState, PaymentEvent> sm = factory.getStateMachine(UUID.randomUUID());
        sm.start();
        assertEquals(PaymentState.NEW, sm.getState().getId());

        sm.sendEvent(PaymentEvent.PRE_AUTHORIZE);
        assertEquals(PaymentState.NEW, sm.getState().getId());

        sm.sendEvent(PaymentEvent.PRE_AUTH_APPROVED);
        assertEquals(PaymentState.PRE_AUTH, sm.getState().getId());
    }
}