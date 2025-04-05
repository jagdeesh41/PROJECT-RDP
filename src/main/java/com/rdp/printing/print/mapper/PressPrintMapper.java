package com.rdp.printing.print.mapper;

import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import com.rdp.printing.print.entity.PressPrint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PressPrintMapper {

    //dto -> entity

    PressPrint dtoToEntity(PrintRequestDto printRequestDto);


    //entity -> dto

    @Mapping(source = "pressPrintId", target = "printId")
    PrintResponseDto entityToDto(PressPrint pressPrint);



}
