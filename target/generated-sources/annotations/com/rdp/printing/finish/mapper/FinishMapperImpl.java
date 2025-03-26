package com.rdp.printing.finish.mapper;

import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.dto.FinishResponseDto;
import com.rdp.printing.finish.entity.Finish;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-26T23:15:20+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class FinishMapperImpl implements FinishMapper {

    @Override
    public Finish finishRequestDtoToEntity(FinishRequestDto finishRequestDto) {
        if ( finishRequestDto == null ) {
            return null;
        }

        Finish.FinishBuilder finish = Finish.builder();

        finish.cutting( finishRequestDto.getCutting() );
        finish.cuttingAmount( finishRequestDto.getCuttingAmount() );
        finish.digitalDyeCutting( finishRequestDto.getDigitalDyeCutting() );
        finish.dyeCuttingSheets( finishRequestDto.getDyeCuttingSheets() );
        finish.dyeCuttingAmount( finishRequestDto.getDyeCuttingAmount() );
        finish.laminationType( finishRequestDto.getLaminationType() );
        finish.laminationSheets( finishRequestDto.getLaminationSheets() );
        finish.laminationAmount( finishRequestDto.getLaminationAmount() );
        finish.totalSheets( finishRequestDto.getTotalSheets() );
        finish.totalAmount( finishRequestDto.getTotalAmount() );
        finish.side( finishRequestDto.getSide() );

        return finish.build();
    }

    @Override
    public FinishResponseDto finishEntityToResponseDto(Finish finish) {
        if ( finish == null ) {
            return null;
        }

        FinishResponseDto.FinishResponseDtoBuilder finishResponseDto = FinishResponseDto.builder();

        if ( finish.getFinishId() != null ) {
            finishResponseDto.finishId( finish.getFinishId() );
        }
        finishResponseDto.cutting( finish.getCutting() );
        finishResponseDto.cuttingAmount( finish.getCuttingAmount() );
        finishResponseDto.digitalDyeCutting( finish.getDigitalDyeCutting() );
        finishResponseDto.dyeCuttingAmount( finish.getDyeCuttingAmount() );
        finishResponseDto.laminationType( finish.getLaminationType() );
        finishResponseDto.laminationAmount( finish.getLaminationAmount() );

        return finishResponseDto.build();
    }
}
