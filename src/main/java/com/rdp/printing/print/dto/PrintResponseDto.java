package com.rdp.printing.print.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrintResponseDto {
    private long printId;
    private String customerName;
    private String printDetails;
    private String amount;
    private String paymentMode;
    private String paymentStatus;
}
