package com.rdp.printing.entry.service;

import com.rdp.printing.entry.dto.EntryRequest;
import com.rdp.printing.entry.dto.EntryResponse;

import java.util.List;

public interface IEntryService {

    String addEntry(EntryRequest entryRequest);

    List<EntryResponse> getAllEntry();
}
