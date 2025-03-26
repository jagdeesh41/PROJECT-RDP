package com.rdp.printing.finish.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "finish_details")
public class Finish extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finishId;
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

