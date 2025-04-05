package com.rdp.printing.print.entity;

import com.rdp.printing.common.audit.BaseEntity;
import com.rdp.printing.finish.entity.PressFinish;
import com.rdp.printing.finish.entity.UserFinish;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user_print")
public class UserPrint extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userPrintId;

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

    @OneToOne
    @JoinColumn(name = "user_finish_id")
    private UserFinish userFinish;
}
