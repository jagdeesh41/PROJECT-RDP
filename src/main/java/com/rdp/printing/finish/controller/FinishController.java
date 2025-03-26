package com.rdp.printing.finish.controller;

import com.rdp.printing.common.model.ApiResponse;
import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.dto.FinishResponseDto;
import com.rdp.printing.finish.service.IFinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FinishController {

    @Autowired
    private IFinishService finishService;

    @GetMapping("/finish")
    public ResponseEntity<List<FinishResponseDto>> getFinishes()
    {
        return ResponseEntity.ok()
                .body(finishService.findAllFinish());

    }
    @PostMapping("/finish")
    public ResponseEntity<ApiResponse> addFinish(@RequestBody FinishRequestDto finishRequestDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(finishService.addFinish(finishRequestDto),true));

    }
    @DeleteMapping("/finish/{id}")
    public ResponseEntity<ApiResponse> deleteFinsh(@PathVariable("id") long id)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(finishService.deleteFinish(id),true));

    }

    @PutMapping("/finish/{id}")
    public ResponseEntity<FinishResponseDto> updateFinish(@RequestBody FinishRequestDto finishRequestDto,
                                                         @PathVariable("id") long id)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(finishService.updatePrint(id,finishRequestDto));

    }
}
