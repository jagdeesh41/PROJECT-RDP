package com.rdp.printing.finish.entity;

import com.rdp.printing.common.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user_finish")
public class UserFinish extends BaseEntity {
    @Id
    @Column(name = "finish_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userFinishId;
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
