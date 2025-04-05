package com.rdp.printing.press.mapper;

import com.rdp.printing.press.dto.PreFetchPressResponse;
import com.rdp.printing.press.dto.PressRequestDto;
import com.rdp.printing.press.dto.PressResponse;
import com.rdp.printing.press.entity.Press;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-05T22:23:58+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class PressMapperImpl implements PressMapper {

    @Override
    public Press pressRequestDtoToEntity(PressRequestDto pressRequestDto) {
        if ( pressRequestDto == null ) {
            return null;
        }

        Press.PressBuilder press = Press.builder();

        press.contactPersonName( pressRequestDto.getContactPersonName() );
        press.pressName( pressRequestDto.getPressName() );
        press.phoneNumber( pressRequestDto.getPhoneNumber() );
        press.totalPrints( pressRequestDto.getTotalPrints() );
        press.outstandingAmount( pressRequestDto.getOutstandingAmount() );
        press.lastPaymentDate( pressRequestDto.getLastPaymentDate() );
        press.lastPaidAmount( pressRequestDto.getLastPaidAmount() );

        return press.build();
    }

    @Override
    public PressResponse pressEntityToResponseDto(Press press) {
        if ( press == null ) {
            return null;
        }

        PressResponse.PressResponseBuilder pressResponse = PressResponse.builder();

        pressResponse.pressId( press.getPressId() );
        pressResponse.contactPersonName( press.getContactPersonName() );
        pressResponse.pressName( press.getPressName() );
        pressResponse.phoneNumber( press.getPhoneNumber() );
        pressResponse.totalPrints( press.getTotalPrints() );
        pressResponse.outstandingAmount( press.getOutstandingAmount() );
        pressResponse.lastPaymentDate( press.getLastPaymentDate() );
        pressResponse.lastPaidAmount( press.getLastPaidAmount() );

        return pressResponse.build();
    }

    @Override
    public PreFetchPressResponse pressEntityToPreFetch(Press press) {
        if ( press == null ) {
            return null;
        }

        PreFetchPressResponse.PreFetchPressResponseBuilder preFetchPressResponse = PreFetchPressResponse.builder();

        preFetchPressResponse.pressId( press.getPressId() );
        preFetchPressResponse.contactPersonName( press.getContactPersonName() );
        preFetchPressResponse.pressName( press.getPressName() );

        return preFetchPressResponse.build();
    }
}
