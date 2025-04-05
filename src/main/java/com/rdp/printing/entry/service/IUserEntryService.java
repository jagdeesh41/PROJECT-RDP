package com.rdp.printing.entry.service;

import com.rdp.printing.entry.dto.EntryResponse;
import com.rdp.printing.entry.dto.UserEntryRequest;

import java.util.List;

public interface IUserEntryService {

    String addUserEntry(UserEntryRequest entryRequest);

    List<EntryResponse> getAllUserEntry();
}
