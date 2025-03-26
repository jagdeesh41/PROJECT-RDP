package com.rdp.printing.press.mapper;


import com.rdp.printing.press.dto.PreFetchPressResponse;
import com.rdp.printing.press.dto.PressRequestDto;
import com.rdp.printing.press.dto.PressResponse;
import com.rdp.printing.press.entity.Press;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PressMapper {
    Press pressRequestDtoToEntity(PressRequestDto pressRequestDto);

    PressResponse pressEntityToResponseDto (Press press);

    PreFetchPressResponse pressEntityToPreFetch(Press press);


}
