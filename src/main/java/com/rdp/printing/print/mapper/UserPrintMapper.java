package com.rdp.printing.print.mapper;

import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import com.rdp.printing.print.entity.PressPrint;
import com.rdp.printing.print.entity.UserPrint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserPrintMapper {

    //dto -> entity

    UserPrint dtoToEntity(PrintRequestDto printRequestDto);


    //entity -> dto

    @Mapping(source = "userPrintId" , target = "printId")
    PrintResponseDto entityToDto(UserPrint userPrint);



}
