package com.rdp.printing.entry.service;

import com.rdp.printing.common.exception.ResourceNotFoundException;
import com.rdp.printing.entry.dto.EntryResponse;
import com.rdp.printing.entry.dto.PressEntryRequest;
import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.entity.PressFinish;
import com.rdp.printing.finish.mapper.PressFinishMapper;
import com.rdp.printing.finish.repo.PressFinishRepository;
import com.rdp.printing.press.entity.Press;
import com.rdp.printing.press.repo.PressRepository;
import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.entity.PressPrint;
import com.rdp.printing.print.mapper.PressPrintMapper;
import com.rdp.printing.print.repo.PressPrintRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PressEntryServiceImpl implements IPressEntryService{

    @Autowired
    private PressRepository pressRepository;

    @Autowired
    private PressPrintMapper pressPrintMapper;

    @Autowired
    private PressPrintRepository pressPrintRepository;

    @Autowired
    private PressFinishRepository pressFinishRepository;

    @Autowired
    private PressFinishMapper pressFinishMapper;

    @Override
    @Transactional
    public String addPressEntry(PressEntryRequest pressEntryRequest) {
        Long pressId = pressEntryRequest.getPressId();
        PrintRequestDto printRequestDto = pressEntryRequest.getPrintRequestDto();
        FinishRequestDto finishRequestDto = pressEntryRequest.getFinishRequestDto();
        Press press = pressRepository.findById(pressId)
                .orElseThrow(() -> new ResourceNotFoundException("Press", pressId));
        PressPrint pressPrint = pressPrintMapper.dtoToEntity(printRequestDto);
        pressPrint.setPress(press);
        if(null!=finishRequestDto)
        {
            PressFinish pressFinish = pressFinishMapper.dtoToEntity(finishRequestDto);
            PressFinish savedPressFinish = pressFinishRepository.save(pressFinish);
            pressPrint.setPressFinish(savedPressFinish);
        }

        PressPrint savedPressPrint = pressPrintRepository.save(pressPrint);


        return "PressEntry created successfully";
    }
    @Override
    public List<EntryResponse> getAllPressEntry() {

        List<PressPrint> printsByPress = pressPrintRepository.findAll();
        List<EntryResponse> responses = new ArrayList<>();
        printsByPress.stream()
                .forEach(print->
                {
                    EntryResponse entryResponse =
                            EntryResponse
                            .builder()
                            .printResponseDto(pressPrintMapper.entityToDto(print))
                            .finishResponseDto(pressFinishMapper.entityToDto(print.getPressFinish()))
                            .build();
                    responses.add(entryResponse);
                });
        return responses;
    }
}
