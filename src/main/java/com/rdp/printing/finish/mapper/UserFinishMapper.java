package com.rdp.printing.finish.mapper;

import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.dto.FinishResponseDto;
import com.rdp.printing.finish.entity.PressFinish;
import com.rdp.printing.finish.entity.UserFinish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserFinishMapper {

    //dto -> entity

    UserFinish dtoToEntity(FinishRequestDto finishRequestDto);


    //entity -> dto

    @Mapping(target = "finishId", source = "userFinishId")
    FinishResponseDto entityToDto(UserFinish userFinish);



}
