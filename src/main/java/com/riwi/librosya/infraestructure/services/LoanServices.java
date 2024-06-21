package com.riwi.librosya.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.librosya.api.dto.request.LoanRequest;
import com.riwi.librosya.api.dto.response.BookResponse;
import com.riwi.librosya.api.dto.response.LoanResponse;
import com.riwi.librosya.domain.entities.BookEntity;
import com.riwi.librosya.domain.entities.Loan;
import com.riwi.librosya.domain.repositories.LoanRepository;
import com.riwi.librosya.infraestructure.abstracts_services.ILoanServices;
import com.riwi.librosya.infraestructure.helpers.Mappers.LoanMappers;
import com.riwi.librosya.util.excepcions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanServices implements ILoanServices {

    @Autowired
    private final LoanRepository loanRepository;
    @Autowired
    private final LoanMappers loanMappers;

    @Override
    public LoanResponse create(LoanRequest request) {
        Loan entity = this.loanMappers.requesttoEntity(request);

        return this.loanMappers.entitytoResponse(this.loanRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        this.loanRepository.delete(this.find(id));

    }

    @Override
    public LoanResponse get(Long id) {
        // TODO Auto-generated method stub
        return this.loanMappers.entitytoResponse(this.find(id));

    }

    @Override
    public Page<LoanResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        Page<Loan> loanPage = loanRepository.findAll(pagination);
        List<LoanResponse> loanResponse = this.loanMappers.entitytoResponse(loanPage.getContent());
        return new PageImpl<>(loanResponse, pagination, loanPage.getTotalElements());
    }

    @Override
    public LoanResponse update(LoanRequest request, Long id) {
        return null;
    }

    // propios
    public List<LoanResponse> getAllLoansByUserId(Long userId) {
        return this.loanMappers.entitytoResponse(loanRepository.findByUserId(userId));
    }

    private Loan find(Long id) {
        return this.loanRepository.findById(id).orElseThrow(() -> new BadRequestException("ID NOT FOUND"));

    }

}
