package com.example.account.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR("서버 에러가 발생했습니다."),
    INVALID_REQUEST("잘못된 요청입니다."),
    USER_NOT_FOUND("사용자가 없습니다."),
    ACCOUNT_NOT_FOUND("계좌가 없습니다."),
    USER_ACCOUNT_UN_MATCH("사용자와 계좌가 일치하지 않습니다."),
    ACCOUNT_ALREADY_UNREGISTERED("이미 해지된 계좌입니다."),
    BALANCE_NOT_EMPTY("잔액이 있는 계좌는 해질할 수 없습니다."),
    AMOUNT_EXCEED_BALANCE("잔액이 부족합니다."),
    MAX_ACCOUNT_PER_USER_10("사용자의 최대 계좌 개수는 10개입니다."),
    TRANSACTION_NOT_FOUND("해당 거래가 없습니다."),
    TRANSACTION_ACCOUNT_UN_MATCH("사용자와 계좌가 일치하지 않습니다."),
    CANCEL_MUST_FULLY("일부 금액만 환불할 수 없습니다."),
    TOO_OLD_ORDER_TO_CANCEL("1년이 지난 거래는 취소가 불가능합니다."),
    ;
    private final String description;
}
