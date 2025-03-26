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
public class PressRequestDto {
    private String contactPersonName;
    private String pressName;
    private String phoneNumber;
    private Integer totalPrints;
    private BigDecimal outstandingAmount;
    private Date lastPaymentDate;
    private BigDecimal lastPaidAmount;
}
