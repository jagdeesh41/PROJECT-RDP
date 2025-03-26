package com.rdp.printing.print.entity;


import com.rdp.printing.finish.entity.Finish;
import com.rdp.printing.press.entity.Press;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "print_details")
public class Print extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long printId;
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
    @JoinColumn(name = "finish_id")  // Foreign key in print_details table
    private Finish finish;

    // many prints can have 1 ledger id
    @ManyToOne
    @JoinColumn(name = "press_id")  // Join column references
    private Press press;

}



