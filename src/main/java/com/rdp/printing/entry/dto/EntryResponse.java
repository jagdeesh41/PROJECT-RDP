package com.rdp.printing.entry.dto;

import com.rdp.printing.finish.dto.FinishResponseDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntryResponse {
    private PrintResponseDto printResponseDto;
    private FinishResponseDto finishResponseDto;
}
