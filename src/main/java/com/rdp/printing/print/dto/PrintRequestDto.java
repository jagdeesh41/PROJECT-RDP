package com.rdp.printing.print.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrintRequestDto {
    private String customerName;
    private String printDetails;
    private String mediaType;
    private String size;
    private String quantity;
    private String sides;
    private String numberOfPrints;
    private String color;
    private String amount;
    private String paymentMode;
    private String advance;
    private String wastagePrint;
    private String paymentStatus;
}
