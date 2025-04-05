package com.rdp.printing.press.service;

import com.rdp.printing.common.exception.ResourceNotFoundException;
import com.rdp.printing.press.dto.PreFetchPressResponse;
import com.rdp.printing.press.dto.PressRequestDto;
import com.rdp.printing.press.dto.PressResponse;
import com.rdp.printing.press.dto.SearchPressResponse;
import com.rdp.printing.press.entity.Press;
import com.rdp.printing.press.mapper.PressMapper;
import com.rdp.printing.press.repo.PressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PressSerivceImpl implements IPressService {
    @Autowired
    private PressRepository pressRepository;
    @Autowired
    private PressMapper pressMapper;
    @Override
    public String addPress(PressRequestDto pressRequestDto)
    {
        Press press = pressMapper.pressRequestDtoToEntity(pressRequestDto);
        pressRepository.save(press);
        return "Press added to DB successfully";
    }

    @Override
    public SearchPressResponse findAllPress(Integer pageNumber,Integer pageSize,String sortBy, String sortOrder)
    {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        PageRequest pressPage = PageRequest.of(pageNumber,pageSize,sortByAndOrder);
        Page<Press> presses = pressRepository.findAll(pressPage);
        List<PressResponse> pressResponses = presses.stream()
                .map(press->pressMapper.pressEntityToResponseDto(press))
                .toList();
        SearchPressResponse searchPressResponse = SearchPressResponse.builder()
                .pressContent(pressResponses)
                .pageNumber(presses.getNumber())
                .pageSize(presses.getSize())
                .totalElements(presses.getTotalElements())
                .totalPages(presses.getTotalPages())
                .lastPage(presses.isLast())
                .build();
        return searchPressResponse;
    }
    @Override
    public String deletePress(long id)
    {
        Press press = pressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Press", id));
        pressRepository.delete(press);
        return "Press with pressId : "+id+ "deleted successfully";
    }

    @Override
    public PressResponse updatePress(long id, PressRequestDto pressRequestDto)
    {
        Press press = pressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Press", id));
        Press updatedLedger = pressMapper.pressRequestDtoToEntity(pressRequestDto);
        updatedLedger.setPressId(id);
        Press savedLedger = pressRepository.save(updatedLedger);
        return pressMapper.pressEntityToResponseDto(savedLedger);
    }

    @Override
    public List<PreFetchPressResponse> preFetch() {
        List<Press> pressList = pressRepository.findAll();
        List<PreFetchPressResponse> preFetchPressResponses = new ArrayList<>();
        pressList.stream().forEach(press -> preFetchPressResponses.add(pressMapper.pressEntityToPreFetch(press)));
        return preFetchPressResponses;
    }
}
