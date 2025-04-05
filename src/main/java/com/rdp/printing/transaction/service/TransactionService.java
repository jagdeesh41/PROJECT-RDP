package com.rdp.printing.transaction.service;


import com.rdp.printing.common.exception.OverCreditException;
import com.rdp.printing.common.exception.ResourceNotFoundException;
import com.rdp.printing.press.entity.Press;
import com.rdp.printing.press.repo.PressRepository;
import com.rdp.printing.transaction.dto.TransactionDto;
import com.rdp.printing.transaction.entity.Transaction;
import com.rdp.printing.transaction.repo.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
@Service
@Slf4j
public class TransactionService implements  ITransactionService{

    @Autowired
    private PressRepository pressRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public String addTransactionToPress(TransactionDto transactionDto) {
        Long pressId = transactionDto.getPressId();
        Long currentAmount = transactionDto.getAmount();
        Press press = pressRepository.findById(pressId)
                .orElseThrow(()-> new ResourceNotFoundException("Press",pressId));
        String pressName = press.getPressName();
        //current press outstanding amount

        Long outstandingAmount = press.getOutstandingAmount();
        log.info("outstanding before : {}",outstandingAmount);
        Long store = outstandingAmount;
        if(currentAmount>outstandingAmount)
        {
            throw new OverCreditException("Amount over credited",outstandingAmount,currentAmount);

        }
        outstandingAmount-=currentAmount;
        log.info("outstanding after : {}",outstandingAmount);
        press.setOutstandingAmount(outstandingAmount);
        Press savedPress = pressRepository.save(press);

        // save a current transaction

        Transaction transaction = Transaction.builder()
                .transactionId("TXN" + System.currentTimeMillis())
                .currentAmount(currentAmount)
                .press(savedPress)
                .updatedOutstandingAmount(outstandingAmount)
                .outstandingAmount(store)
                .currentTimestamp(new Date())
                .build();


        transactionRepository.save(transaction);










        return "Transaction done successfully";
    }
}
