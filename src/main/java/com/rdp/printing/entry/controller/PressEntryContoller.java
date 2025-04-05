package com.rdp.printing.entry.controller;

import com.rdp.printing.common.model.ApiResponse;
import com.rdp.printing.entry.dto.PressEntryRequest;
import com.rdp.printing.entry.dto.EntryResponse;
import com.rdp.printing.entry.service.IPressEntryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PressEntryContoller {
    @Autowired
    IPressEntryService pressEntryService;
    @PostMapping("press/entry")
    public ResponseEntity<ApiResponse> addPressEntry(@RequestBody @Valid PressEntryRequest pressEntryRequest)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(pressEntryService.addPressEntry(pressEntryRequest),true));
    }
    @GetMapping("press/entry")
    public ResponseEntity<List<EntryResponse>> getAllPressEntries()
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pressEntryService.getAllPressEntry());
    }
}

