package com.rdp.printing.entry.service;

import com.rdp.printing.entry.dto.EntryResponse;
import com.rdp.printing.entry.dto.UserEntryRequest;
import com.rdp.printing.finish.dto.FinishRequestDto;
import com.rdp.printing.finish.entity.UserFinish;
import com.rdp.printing.finish.mapper.UserFinishMapper;
import com.rdp.printing.finish.repo.UserFinishRepository;
import com.rdp.printing.print.dto.PrintRequestDto;
import com.rdp.printing.print.entity.PressPrint;
import com.rdp.printing.print.entity.UserPrint;
import com.rdp.printing.print.mapper.UserPrintMapper;
import com.rdp.printing.print.repo.UserPrintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserEntryServiceImpl implements IUserEntryService{

    @Autowired
    private UserPrintMapper userPrintMapper;

    @Autowired
    private UserFinishMapper userFinishMapper;

    @Autowired
    private UserPrintRepository userPrintRepository;

    @Autowired
    private UserFinishRepository userFinishRepository;
    @Override
    public String addUserEntry(UserEntryRequest userEntryRequest) {
        PrintRequestDto printRequestDto = userEntryRequest.getPrintRequestDto();
        FinishRequestDto finishRequestDto = userEntryRequest.getFinishRequestDto();
        UserPrint userPrint = userPrintMapper.dtoToEntity(printRequestDto);



        //there is a chance we might not receive finishRequestDto in request
        if(null!=finishRequestDto)
        {
            UserFinish userFinish = userFinishMapper.dtoToEntity(finishRequestDto);
            userFinishRepository.save(userFinish);
            userPrint.setUserFinish(userFinish);
        }
        userPrintRepository.save(userPrint);

        return "UserEntry created successfully";

    }

    @Override
    public List<EntryResponse> getAllUserEntry() {

        List<UserPrint> printsByUser = userPrintRepository.findAll();
        List<EntryResponse> responses = new ArrayList<>();
        printsByUser.stream()
                .forEach(userPrint->
                {
                    EntryResponse entryResponse =
                            EntryResponse
                                    .builder()
                                    .printResponseDto(userPrintMapper.entityToDto(userPrint))
                                    .finishResponseDto(userFinishMapper.entityToDto(userPrint.getUserFinish()))
                                    .build();
                    responses.add(entryResponse);
                });
        return responses;

    }
}
