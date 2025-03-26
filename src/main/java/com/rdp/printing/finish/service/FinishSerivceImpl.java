package com.rdp.printing.finish.service;

import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.dto.FinishResponseDto;
import com.rdp.printing.finish.entity.Finish;
import com.rdp.printing.common.exception.ResourceNotFoundException;
import com.rdp.printing.finish.mapper.FinishMapper;
import com.rdp.printing.finish.repository.FinishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class FinishSerivceImpl implements IFinishService {
    @Autowired
    private FinishRepository finishRepository;
    @Autowired
    private FinishMapper finishMapper;
    @Override
    public String addFinish(FinishRequestDto finishRequestDto)
    {
        Finish finish = finishMapper.finishRequestDtoToEntity(finishRequestDto);
        finishRepository.save(finish);
        return "Print added to DB successfully";
    }

    @Override
    public List<FinishResponseDto> findAllFinish() {
        List<Finish> finishes = finishRepository.findAll();
        List<FinishResponseDto> finishResponseDtos = finishes.stream()
                .map(finish->finishMapper.finishEntityToResponseDto(finish))
                .collect(Collectors.toList());
        return finishResponseDtos;

    }
    @Override
    public String deleteFinish(long id)
    {
        Finish finish = finishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Finish", id));
        finishRepository.delete(finish);
        return "Finish with finishId : "+id+ "deleted successfully";


    }

    @Override
    public FinishResponseDto updatePrint(long id, FinishRequestDto finishRequestDto)
    {
        Finish finish = finishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Finish", id));
        Finish updatedFinish = finishMapper.finishRequestDtoToEntity(finishRequestDto);
        updatedFinish.setFinishId(id);
        Finish savedPrint = finishRepository.save(updatedFinish);
        return finishMapper.finishEntityToResponseDto(savedPrint);
    }
}
