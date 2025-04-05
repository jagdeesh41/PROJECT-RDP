package com.rdp.printing.finish.entity;


import com.rdp.printing.common.audit.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


