package com.rdp.printing.press.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreFetchPressResponse {
    private Long pressId;
    private String contactPersonName;
    private String pressName;
}
