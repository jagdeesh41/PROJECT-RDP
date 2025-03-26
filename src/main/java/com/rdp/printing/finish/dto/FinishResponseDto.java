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
public class FinishResponseDto {
    private long finishId;
    private String cutting;
    private BigDecimal cuttingAmount;
    private String digitalDyeCutting;
    private BigDecimal dyeCuttingAmount;
    private String laminationType;
    private BigDecimal laminationAmount;
}
