package com.rdp.printing.print.service;

import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;

import java.util.List;

public interface IPrintService {
    String addPrint(PrintRequestDto printRequestDto);

    List<PrintResponseDto> findAllPrints();

    String deletePrint(long id);

    PrintResponseDto updatePrint(long id, PrintRequestDto printRequestDto);
}
