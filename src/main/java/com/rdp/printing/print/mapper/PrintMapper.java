package com.rdp.printing.print.mapper;

import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import com.rdp.printing.print.entity.Print;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrintMapper {


    Print printRequestDtoToEntity(PrintRequestDto printRequestDto);

    PrintResponseDto printEntityToResponseDto (Print print);


}
