package com.rdp.printing.finish.mapper;

import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.dto.FinishResponseDto;
import com.rdp.printing.finish.entity.PressFinish;
import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import com.rdp.printing.print.entity.PressPrint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PressFinishMapper {

    //dto -> entity

    PressFinish dtoToEntity(FinishRequestDto finishRequestDto);


    //entity -> dto

    @Mapping(source = "pressFinishId" , target = "finishId")
    FinishResponseDto entityToDto(PressFinish pressFinish);



}
