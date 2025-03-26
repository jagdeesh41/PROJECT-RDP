package com.rdp.printing.entry.controller;

import com.rdp.printing.common.model.ApiResponse;
import com.rdp.printing.entry.dto.EntryRequest;
import com.rdp.printing.entry.dto.EntryResponse;
import com.rdp.printing.entry.service.IEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rdp")
public class EntryContoller {
    @Autowired
    IEntryService entryService;
    @PostMapping("/entry")
    public ResponseEntity<ApiResponse> addEntry(@RequestBody EntryRequest entryRequest)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(entryService.addEntry(entryRequest),true));
    }
    @GetMapping("/entry")
    public ResponseEntity<List<EntryResponse>> getAllEntries()
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(entryService.getAllEntry());
    }
}

