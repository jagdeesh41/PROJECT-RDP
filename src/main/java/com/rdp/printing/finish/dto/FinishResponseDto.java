package com.rdp.printing.finish.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinishResponseDto {
    private long finishId;
    private String cutting;
    private Long cuttingAmount;
    private String digitalDyeCutting;
    private Long dyeCuttingAmount;
    private String laminationType;
    private Long laminationAmount;
}
