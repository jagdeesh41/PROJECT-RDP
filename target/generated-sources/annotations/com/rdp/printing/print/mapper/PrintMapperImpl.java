package com.rdp.printing.print.mapper;

import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import com.rdp.printing.print.entity.Print;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-26T23:15:20+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class PrintMapperImpl implements PrintMapper {

    @Override
    public Print printRequestDtoToEntity(PrintRequestDto printRequestDto) {
        if ( printRequestDto == null ) {
            return null;
        }

        Print.PrintBuilder print = Print.builder();

        print.customerName( printRequestDto.getCustomerName() );
        print.printDetails( printRequestDto.getPrintDetails() );
        print.mediaType( printRequestDto.getMediaType() );
        print.size( printRequestDto.getSize() );
        print.quantity( printRequestDto.getQuantity() );
        print.sides( printRequestDto.getSides() );
        print.numberOfPrints( printRequestDto.getNumberOfPrints() );
        print.color( printRequestDto.getColor() );
        print.amount( printRequestDto.getAmount() );
        print.paymentMode( printRequestDto.getPaymentMode() );
        print.advance( printRequestDto.getAdvance() );
        print.wastagePrint( printRequestDto.getWastagePrint() );
        print.paymentStatus( printRequestDto.getPaymentStatus() );

        return print.build();
    }

    @Override
    public PrintResponseDto printEntityToResponseDto(Print print) {
        if ( print == null ) {
            return null;
        }

        PrintResponseDto.PrintResponseDtoBuilder printResponseDto = PrintResponseDto.builder();

        printResponseDto.printId( print.getPrintId() );
        printResponseDto.customerName( print.getCustomerName() );
        printResponseDto.printDetails( print.getPrintDetails() );
        printResponseDto.amount( print.getAmount() );
        printResponseDto.paymentMode( print.getPaymentMode() );
        printResponseDto.paymentStatus( print.getPaymentStatus() );

        return printResponseDto.build();
    }
}
