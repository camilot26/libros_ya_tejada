package com.riwi.librosya.infraestructure.abstracts_services;

import java.util.List;

import com.riwi.librosya.api.dto.request.LoanRequest;
import com.riwi.librosya.api.dto.response.LoanResponse;
import com.riwi.librosya.domain.entities.Loan;

public interface ILoanServices extends CrudService<LoanRequest,LoanResponse,Long> {

    List<LoanResponse> getAllLoansByUserId(Long userId);

}
