package com.rdp.printing.transaction.entity;


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
@Entity(name = "press_transaction")
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionId;
    private Long outstandingAmount;
    private Long currentAmount;
    @Column(name = "txn_timestamp")
    private Date currentTimestamp;
    private Long updatedOutstandingAmount;

    @ManyToOne
    @JoinColumn(name = "press_id")
    private Press press;
}
