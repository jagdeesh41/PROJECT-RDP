package com.rdp.printing.press.controller;

import com.rdp.printing.common.model.ApiResponse;
import com.rdp.printing.press.dto.PreFetchPressResponse;
import com.rdp.printing.press.dto.PressRequestDto;
import com.rdp.printing.press.dto.PressResponse;
import com.rdp.printing.press.dto.SearchPressResponse;
import com.rdp.printing.press.service.IPressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rdp.printing.common.constant.Constant.*;

@RestController
@RequestMapping("/api")
public class PressController {

    @Autowired
    private IPressService pressService;

    @GetMapping("/press")
    public ResponseEntity<SearchPressResponse> getPress(
            @RequestParam(value = "pageSize",required = false,defaultValue = DEFAULT_SIZE) Integer pageSize,
            @RequestParam(value = "pageNumber",required = false,defaultValue = DEFAULT_PAGE) Integer pageNumber,
            @RequestParam(value = "sortBy", required = false, defaultValue = SORT_PRESS_BY) String sortBy,
            @RequestParam(value = "sortOrder", required = false, defaultValue = SORT_DIR) String sortOrder)
    {
        return ResponseEntity.ok()
                .body(pressService.findAllPress(pageNumber,pageSize,sortBy,sortOrder));
    }
    @PostMapping("/press")
    public ResponseEntity<ApiResponse> addPress(@RequestBody PressRequestDto pressRequestDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(pressService.addPress(pressRequestDto),true));

    }
    @DeleteMapping("/press/{id}")
    public ResponseEntity<ApiResponse> deletePress(@PathVariable("id") long id)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(pressService.deletePress(id),true));
    }

    @PutMapping("/press/{id}")
    public ResponseEntity<PressResponse> updatePress(@RequestBody PressRequestDto pressRequestDto,
                                                         @PathVariable("id") long id)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(pressService.updatePress(id,pressRequestDto));
    }
    @GetMapping("/press/fetch")
    public ResponseEntity<List<PreFetchPressResponse>> preFetch()
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pressService.preFetch());
    }
}
