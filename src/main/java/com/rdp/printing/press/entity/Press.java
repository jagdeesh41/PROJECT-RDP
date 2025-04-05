package com.rdp.printing.press.entity;


import com.rdp.printing.common.audit.BaseEntity;
import com.rdp.printing.print.entity.PressPrint;
import com.rdp.printing.transaction.entity.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "press")
public class Press extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pressId;
    private String contactPersonName;
    private String pressName;
    private String phoneNumber;
    private Integer totalPrints;
    private Long outstandingAmount;
    private Date lastPaymentDate;
    private Long lastPaidAmount;

    @OneToMany(mappedBy = "press")
    private List<PressPrint> pressPrints;

    @OneToMany(mappedBy = "press")
    private List<Transaction> transactions;
}

