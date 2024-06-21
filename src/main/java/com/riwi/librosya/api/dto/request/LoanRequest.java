package com.riwi.librosya.api.dto.request;
import java.time.LocalDate;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private LocalDate loanDate;
    private LocalDate returnDate;
    @NotBlank(message="status is required")
    private String status;
    private Long user;
    private Long book;

}
