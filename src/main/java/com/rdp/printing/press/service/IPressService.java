package com.rdp.printing.press.service;

import com.rdp.printing.press.dto.PreFetchPressResponse;
import com.rdp.printing.press.dto.PressRequestDto;
import com.rdp.printing.press.dto.PressResponse;
import com.rdp.printing.press.dto.SearchPressResponse;


import java.util.List;

public interface IPressService {

    String addPress(PressRequestDto pressRequestDto);
    SearchPressResponse findAllPress(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    String deletePress(long id);

    PressResponse updatePress(long id, PressRequestDto pressRequestDto);

    List<PreFetchPressResponse> preFetch();
}
