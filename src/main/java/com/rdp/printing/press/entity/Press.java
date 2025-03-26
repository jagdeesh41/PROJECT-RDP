package com.rdp.printing.press.entity;


import com.rdp.printing.finish.entity.BaseEntity;
import com.rdp.printing.print.entity.Print;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "press_ledger")
public class Press extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pressId;
    private String contactPersonName;
    private String pressName;
    private String phoneNumber;
    private Integer totalPrints;
    private BigDecimal outstandingAmount;
    private Date lastPaymentDate;
    private BigDecimal lastPaidAmount;
    @OneToMany(mappedBy = "press")
    private List<Print> prints;
}

