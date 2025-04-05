package com.rdp.printing.entry.dto;

import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.print.dto.PrintRequestDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PressEntryRequest {
    private PrintRequestDto printRequestDto;
    private FinishRequestDto finishRequestDto;
    @NotNull(message = "please enter a valid pressId")
    private Long pressId;
}
