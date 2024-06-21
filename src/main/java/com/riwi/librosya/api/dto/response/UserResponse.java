package com.riwi.librosya.api.dto.response;

import java.util.List;

import com.riwi.librosya.domain.entities.Loan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private long id;
    private String username;
    private String email;
    private String fullName;
    private String role;
    private List<Loan>loans;
}
