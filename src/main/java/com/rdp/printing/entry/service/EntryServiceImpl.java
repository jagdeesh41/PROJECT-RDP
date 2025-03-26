package com.rdp.printing.entry.service;

import com.rdp.printing.common.exception.ResourceNotFoundException;
import com.rdp.printing.entry.dto.EntryRequest;
import com.rdp.printing.entry.dto.EntryResponse;
import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.entity.Finish;
import com.rdp.printing.finish.mapper.FinishMapper;
import com.rdp.printing.finish.repository.FinishRepository;
import com.rdp.printing.press.entity.Press;
import com.rdp.printing.press.repository.PressRepository;
import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.entity.Print;
import com.rdp.printing.print.mapper.PrintMapper;
import com.rdp.printing.print.repository.PrintRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class EntryServiceImpl implements IEntryService{

    @Autowired
    private PrintRepository printRepository;
    @Autowired
    private FinishRepository finishRepository;
    @Autowired
    private PressRepository pressRepository;
    @Autowired
    private PrintMapper printMapper;
    @Autowired
    private FinishMapper finishMapper;
    @Override
    @Transactional
    public String addEntry(EntryRequest entryRequest) {
        PrintRequestDto printRequestDto = entryRequest.getPrintRequestDto();
        FinishRequestDto finishRequestDto = entryRequest.getFinishRequestDto();
        Print print = printMapper.printRequestDtoToEntity(printRequestDto);
        if(!Objects.isNull(entryRequest.getPressId()))
        {
            // press_ledger_ref exist
            Press press = pressRepository.findById(entryRequest.getPressId())
                    .orElseThrow(()-> new ResourceNotFoundException("Press",entryRequest.getPressId()));
            print.setPress(press);
        }
        // if there is no finish request
        if(!Objects.isNull(finishRequestDto))
        {
            Finish finish = finishMapper.finishRequestDtoToEntity(finishRequestDto);
            Finish savedFinish = finishRepository.save(finish);
            printRepository.save(print);
            print.setFinish(savedFinish);
        }
        else {
            printRepository.save(print);
        }

        return "Entry Added successfully";
    }

    @Override
    public List<EntryResponse> getAllEntry() {
        List<Print> prints = printRepository.findAll();
        List<EntryResponse> responses = new ArrayList<>();
        prints.stream().forEach(print-> {EntryResponse entryResponse = EntryResponse.builder()
                            .printResponseDto(printMapper.printEntityToResponseDto(print))
                            .finishResponseDto(finishMapper.finishEntityToResponseDto(print.getFinish()))
                            .build();
            responses.add(entryResponse);});
        return responses;
    }


}
