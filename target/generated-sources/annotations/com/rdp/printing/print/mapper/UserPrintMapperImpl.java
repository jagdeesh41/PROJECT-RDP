package com.rdp.printing.print.mapper;

import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.dto.PrintResponseDto;
import com.rdp.printing.print.entity.UserPrint;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-05T22:23:57+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class UserPrintMapperImpl implements UserPrintMapper {

    @Override
    public UserPrint dtoToEntity(PrintRequestDto printRequestDto) {
        if ( printRequestDto == null ) {
            return null;
        }

        UserPrint.UserPrintBuilder userPrint = UserPrint.builder();

        userPrint.customerName( printRequestDto.getCustomerName() );
        userPrint.printDetails( printRequestDto.getPrintDetails() );
        userPrint.mediaType( printRequestDto.getMediaType() );
        userPrint.size( printRequestDto.getSize() );
        userPrint.quantity( printRequestDto.getQuantity() );
        userPrint.sides( printRequestDto.getSides() );
        userPrint.numberOfPrints( printRequestDto.getNumberOfPrints() );
        userPrint.color( printRequestDto.getColor() );
        userPrint.amount( printRequestDto.getAmount() );
        userPrint.paymentMode( printRequestDto.getPaymentMode() );
        userPrint.advance( printRequestDto.getAdvance() );
        userPrint.wastagePrint( printRequestDto.getWastagePrint() );
        userPrint.paymentStatus( printRequestDto.getPaymentStatus() );

        return userPrint.build();
    }

    @Override
    public PrintResponseDto entityToDto(UserPrint userPrint) {
        if ( userPrint == null ) {
            return null;
        }

        PrintResponseDto.PrintResponseDtoBuilder printResponseDto = PrintResponseDto.builder();

        if ( userPrint.getUserPrintId() != null ) {
            printResponseDto.printId( userPrint.getUserPrintId() );
        }
        printResponseDto.customerName( userPrint.getCustomerName() );
        printResponseDto.printDetails( userPrint.getPrintDetails() );
        printResponseDto.amount( userPrint.getAmount() );
        printResponseDto.paymentMode( userPrint.getPaymentMode() );
        printResponseDto.paymentStatus( userPrint.getPaymentStatus() );

        return printResponseDto.build();
    }
}
