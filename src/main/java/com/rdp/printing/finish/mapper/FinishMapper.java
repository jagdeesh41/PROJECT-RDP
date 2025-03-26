package com.rdp.printing.finish.mapper;


import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.dto.FinishResponseDto;
import com.rdp.printing.finish.entity.Finish;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FinishMapper {


    Finish finishRequestDtoToEntity(FinishRequestDto finishRequestDto);

    FinishResponseDto finishEntityToResponseDto (Finish finish);


}
