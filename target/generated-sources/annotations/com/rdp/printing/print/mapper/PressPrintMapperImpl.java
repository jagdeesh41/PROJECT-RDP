package com.rdp.printing.print.mapper;

import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import com.rdp.printing.print.entity.PressPrint;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-05T22:23:58+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class PressPrintMapperImpl implements PressPrintMapper {

    @Override
    public PressPrint dtoToEntity(PrintRequestDto printRequestDto) {
        if ( printRequestDto == null ) {
            return null;
        }

        PressPrint.PressPrintBuilder pressPrint = PressPrint.builder();

        pressPrint.customerName( printRequestDto.getCustomerName() );
        pressPrint.printDetails( printRequestDto.getPrintDetails() );
        pressPrint.mediaType( printRequestDto.getMediaType() );
        pressPrint.size( printRequestDto.getSize() );
        pressPrint.quantity( printRequestDto.getQuantity() );
        pressPrint.sides( printRequestDto.getSides() );
        pressPrint.numberOfPrints( printRequestDto.getNumberOfPrints() );
        pressPrint.color( printRequestDto.getColor() );
        pressPrint.amount( printRequestDto.getAmount() );
        pressPrint.paymentMode( printRequestDto.getPaymentMode() );
        pressPrint.advance( printRequestDto.getAdvance() );
        pressPrint.wastagePrint( printRequestDto.getWastagePrint() );
        pressPrint.paymentStatus( printRequestDto.getPaymentStatus() );

        return pressPrint.build();
    }

    @Override
    public PrintResponseDto entityToDto(PressPrint pressPrint) {
        if ( pressPrint == null ) {
            return null;
        }

        PrintResponseDto.PrintResponseDtoBuilder printResponseDto = PrintResponseDto.builder();

        if ( pressPrint.getPressPrintId() != null ) {
            printResponseDto.printId( pressPrint.getPressPrintId() );
        }
        printResponseDto.customerName( pressPrint.getCustomerName() );
        printResponseDto.printDetails( pressPrint.getPrintDetails() );
        printResponseDto.amount( pressPrint.getAmount() );
        printResponseDto.paymentMode( pressPrint.getPaymentMode() );
        printResponseDto.paymentStatus( pressPrint.getPaymentStatus() );

        return printResponseDto.build();
    }
}
