package com.rdp.printing.press.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PressResponse {
    private Long pressId;
    private String contactPersonName;
    private String pressName;
    private String phoneNumber;
    private Integer totalPrints;
    private Long outstandingAmount;
    private Date lastPaymentDate;
    private Long lastPaidAmount;
}
