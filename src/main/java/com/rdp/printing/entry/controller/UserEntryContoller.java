package com.rdp.printing.entry.controller;

import com.rdp.printing.common.model.ApiResponse;
import com.rdp.printing.entry.dto.EntryResponse;
import com.rdp.printing.entry.dto.UserEntryRequest;
import com.rdp.printing.entry.service.IUserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserEntryContoller {
    @Autowired
    IUserEntryService entryService;
    @PostMapping("user/entry")
    public ResponseEntity<ApiResponse> addUserEntry(@RequestBody UserEntryRequest entryRequest)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(entryService.addUserEntry(entryRequest),true));
    }
    @GetMapping("user/entry")
    public ResponseEntity<List<EntryResponse>> getAllUserEntries()
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(entryService.getAllUserEntry());
    }
}

