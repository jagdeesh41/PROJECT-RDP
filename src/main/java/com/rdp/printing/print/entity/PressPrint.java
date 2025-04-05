package com.rdp.printing.print.entity;

import com.rdp.printing.common.audit.BaseEntity;
import com.rdp.printing.finish.entity.PressFinish;
import com.rdp.printing.press.entity.Press;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "press_print")
public class PressPrint  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pressPrintId;
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
    @JoinColumn(name = "press_finish_id")
    private PressFinish pressFinish;

    @ManyToOne
    @JoinColumn(name = "press_id")
    private Press press;
}