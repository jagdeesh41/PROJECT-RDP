package com.rdp.printing.finish.mapper;

import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.dto.FinishResponseDto;
import com.rdp.printing.finish.entity.PressFinish;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-05T22:23:58+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class PressFinishMapperImpl implements PressFinishMapper {

    @Override
    public PressFinish dtoToEntity(FinishRequestDto finishRequestDto) {
        if ( finishRequestDto == null ) {
            return null;
        }

        PressFinish.PressFinishBuilder pressFinish = PressFinish.builder();

        pressFinish.cutting( finishRequestDto.getCutting() );
        pressFinish.cuttingAmount( finishRequestDto.getCuttingAmount() );
        pressFinish.digitalDyeCutting( finishRequestDto.getDigitalDyeCutting() );
        pressFinish.dyeCuttingSheets( finishRequestDto.getDyeCuttingSheets() );
        pressFinish.dyeCuttingAmount( finishRequestDto.getDyeCuttingAmount() );
        pressFinish.laminationType( finishRequestDto.getLaminationType() );
        pressFinish.laminationSheets( finishRequestDto.getLaminationSheets() );
        pressFinish.laminationAmount( finishRequestDto.getLaminationAmount() );
        pressFinish.totalSheets( finishRequestDto.getTotalSheets() );
        pressFinish.totalAmount( finishRequestDto.getTotalAmount() );
        pressFinish.side( finishRequestDto.getSide() );

        return pressFinish.build();
    }

    @Override
    public FinishResponseDto entityToDto(PressFinish pressFinish) {
        if ( pressFinish == null ) {
            return null;
        }

        FinishResponseDto.FinishResponseDtoBuilder finishResponseDto = FinishResponseDto.builder();

        if ( pressFinish.getPressFinishId() != null ) {
            finishResponseDto.finishId( pressFinish.getPressFinishId() );
        }
        finishResponseDto.cutting( pressFinish.getCutting() );
        finishResponseDto.cuttingAmount( pressFinish.getCuttingAmount() );
        finishResponseDto.digitalDyeCutting( pressFinish.getDigitalDyeCutting() );
        finishResponseDto.dyeCuttingAmount( pressFinish.getDyeCuttingAmount() );
        finishResponseDto.laminationType( pressFinish.getLaminationType() );
        finishResponseDto.laminationAmount( pressFinish.getLaminationAmount() );

        return finishResponseDto.build();
    }
}
