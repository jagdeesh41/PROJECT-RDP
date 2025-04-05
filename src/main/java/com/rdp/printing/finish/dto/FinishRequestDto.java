package com.rdp.printing.finish.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinishRequestDto {
    private String cutting;
    private Long cuttingAmount;
    private String digitalDyeCutting;
    private Integer dyeCuttingSheets;
    private Long dyeCuttingAmount;
    private String laminationType;
    private Integer laminationSheets;
    private Long laminationAmount;
    private Integer totalSheets;
    private Long totalAmount;
    private String side;
}
