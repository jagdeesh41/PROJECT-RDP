package com.rdp.printing.common.exception;

public class OverCreditException extends RuntimeException{

    private Long outstanding;
    private Long currentAmount;




    public OverCreditException(String message, Long outstanding, Long currentAmount) {
        super(message+"with outstanding "+ outstanding + "current Paying amount "+ currentAmount);
        this.outstanding = outstanding;
        this.currentAmount = currentAmount;
    }
}
