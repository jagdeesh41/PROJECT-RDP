package com.rdp.printing.finish.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinishRequestDto {
    private String cutting;
    private BigDecimal cuttingAmount;
    private String digitalDyeCutting;
    private Integer dyeCuttingSheets;
    private BigDecimal dyeCuttingAmount;
    private String laminationType;
    private Integer laminationSheets;
    private BigDecimal laminationAmount;
    private Integer totalSheets;
    private BigDecimal totalAmount;
    private String side;
}
