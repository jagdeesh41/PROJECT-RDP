package com.rdp.printing.finish.service;

import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.dto.FinishResponseDto;
import java.util.List;

public interface IFinishService {
    String addFinish(FinishRequestDto finishRequestDto);

    List<FinishResponseDto> findAllFinish();

    String deleteFinish(long id);

    FinishResponseDto updatePrint(long id, FinishRequestDto finishRequestDto);
}
