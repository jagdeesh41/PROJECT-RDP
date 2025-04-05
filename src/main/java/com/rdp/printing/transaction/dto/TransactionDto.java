package com.rdp.printing.transaction.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    //we get press to which this tranasaction is made
    private Long pressId;
    private Long amount;
    private String paymentMode;
}
