package com.rdp.printing.transaction.controller;

import com.rdp.printing.common.model.ApiResponse;
import com.rdp.printing.entry.dto.PressEntryRequest;
import com.rdp.printing.transaction.dto.TransactionDto;
import com.rdp.printing.transaction.service.ITransactionService;
import com.rdp.printing.transaction.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/press/transaction")
    public ResponseEntity<ApiResponse> addPressEntry(@RequestBody TransactionDto transactionDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(transactionService.addTransactionToPress(transactionDto),true));
    }

}
