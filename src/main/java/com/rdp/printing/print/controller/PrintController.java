package com.rdp.printing.print.controller;

import com.rdp.printing.common.model.ApiResponse;
import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import com.rdp.printing.print.service.IPrintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrintController {

    @Autowired
    private IPrintService printService;

    @GetMapping("/print")
    public ResponseEntity<List<PrintResponseDto>> getPrints()
    {
        return ResponseEntity.ok()
                .body(printService.findAllPrints());

    }
    @PostMapping("/print")
    public ResponseEntity<ApiResponse> addPrint(@RequestBody PrintRequestDto printRequestDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(printService.addPrint(printRequestDto),true));

    }
    @DeleteMapping("/print/{id}")
    public ResponseEntity<ApiResponse> addPrint(@PathVariable("id") long id)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(printService.deletePrint(id),true));

    }

    @PutMapping("/print/{id}")
    public ResponseEntity<PrintResponseDto> updatePrint(@RequestBody PrintRequestDto printRequestDto,
                                                        @PathVariable("id") long id)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(printService.updatePrint(id,printRequestDto));

    }




}
