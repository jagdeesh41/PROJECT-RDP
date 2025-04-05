package com.rdp.printing.entry.dto;

import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.print.dto.PrintRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntryRequest {
    private PrintRequestDto printRequestDto;
    private FinishRequestDto finishRequestDto;
}
