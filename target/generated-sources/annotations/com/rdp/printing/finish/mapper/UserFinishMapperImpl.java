package com.rdp.printing.finish.mapper;

import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.dto.FinishResponseDto;
import com.rdp.printing.finish.entity.UserFinish;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-05T22:23:58+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class UserFinishMapperImpl implements UserFinishMapper {

    @Override
    public UserFinish dtoToEntity(FinishRequestDto finishRequestDto) {
        if ( finishRequestDto == null ) {
            return null;
        }

        UserFinish.UserFinishBuilder userFinish = UserFinish.builder();

        userFinish.cutting( finishRequestDto.getCutting() );
        userFinish.cuttingAmount( finishRequestDto.getCuttingAmount() );
        userFinish.digitalDyeCutting( finishRequestDto.getDigitalDyeCutting() );
        userFinish.dyeCuttingSheets( finishRequestDto.getDyeCuttingSheets() );
        userFinish.dyeCuttingAmount( finishRequestDto.getDyeCuttingAmount() );
        userFinish.laminationType( finishRequestDto.getLaminationType() );
        userFinish.laminationSheets( finishRequestDto.getLaminationSheets() );
        userFinish.laminationAmount( finishRequestDto.getLaminationAmount() );
        userFinish.totalSheets( finishRequestDto.getTotalSheets() );
        userFinish.totalAmount( finishRequestDto.getTotalAmount() );
        userFinish.side( finishRequestDto.getSide() );

        return userFinish.build();
    }

    @Override
    public FinishResponseDto entityToDto(UserFinish userFinish) {
        if ( userFinish == null ) {
            return null;
        }

        FinishResponseDto.FinishResponseDtoBuilder finishResponseDto = FinishResponseDto.builder();

        if ( userFinish.getUserFinishId() != null ) {
            finishResponseDto.finishId( userFinish.getUserFinishId() );
        }
        finishResponseDto.cutting( userFinish.getCutting() );
        finishResponseDto.cuttingAmount( userFinish.getCuttingAmount() );
        finishResponseDto.digitalDyeCutting( userFinish.getDigitalDyeCutting() );
        finishResponseDto.dyeCuttingAmount( userFinish.getDyeCuttingAmount() );
        finishResponseDto.laminationType( userFinish.getLaminationType() );
        finishResponseDto.laminationAmount( userFinish.getLaminationAmount() );

        return finishResponseDto.build();
    }
}
