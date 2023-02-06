package com.zrs.demo.ssm.domain;

/**
 * @author zrs
 */
public enum PaymentState {
    NEW,
    PRE_AUTH,
    PRE_AUTH_ERROR,
    AUTH,
    AUTH_ERROR
}
