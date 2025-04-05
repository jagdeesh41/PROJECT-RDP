package com.rdp.printing.finish.entity;


import com.rdp.printing.common.audit.BaseEntity;
import com.rdp.printing.print.entity.PressPrint;
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
@Entity(name = "press_finish")
public class PressFinish extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pressFinishId;
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


