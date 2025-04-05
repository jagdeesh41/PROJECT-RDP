package com.rdp.printing.transaction.service;

import com.rdp.printing.transaction.dto.TransactionDto;

public interface ITransactionService {

    String addTransactionToPress(TransactionDto transactionDto);
}
