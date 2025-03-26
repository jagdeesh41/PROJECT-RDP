package com.rdp.printing.print.service;

import com.rdp.printing.common.exception.ResourceNotFoundException;
import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import com.rdp.printing.print.entity.Print;
import com.rdp.printing.print.mapper.PrintMapper;
import com.rdp.printing.print.repository.PrintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PrintSerivceImpl implements IPrintService{
    @Autowired
    private PrintRepository printRepository;
    @Autowired
    private PrintMapper printMapper;
    @Override
    public String addPrint(PrintRequestDto printRequestDto)
    {
        // dto -> entity
        Print print = printMapper.printRequestDtoToEntity(printRequestDto);
        printRepository.save(print);
        return "Print added to DB successfully";
    }

    @Override
    public List<PrintResponseDto> findAllPrints() {
        List<Print> prints = printRepository.findAll();
        // every print from prints to print dto
        List<PrintResponseDto> printResponseDtos = prints.stream()
                .map(print->printMapper.printEntityToResponseDto(print)).collect(Collectors.toList());
        return printResponseDtos;

    }
    @Override
    public String deletePrint(long id)
    {
        Print print = printRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Print", id));
        printRepository.delete(print);
        return "Print with printId : "+id+ "deleted successfully";


    }

    @Override
    public PrintResponseDto updatePrint(long id, PrintRequestDto printRequestDto)
    {
        Print print = printRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Print", id));
        Print updatedPrint = printMapper.printRequestDtoToEntity(printRequestDto);
        updatedPrint.setPrintId(id);
        Print savedPrint = printRepository.save(updatedPrint);
        return printMapper.printEntityToResponseDto(savedPrint);












    }
}
