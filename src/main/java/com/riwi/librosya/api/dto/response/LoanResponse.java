package com.riwi.librosya.api.dto.response;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    private Long id;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private String status;
    private UserBasicResponse user;
    private BookBasicResponse book;


}
