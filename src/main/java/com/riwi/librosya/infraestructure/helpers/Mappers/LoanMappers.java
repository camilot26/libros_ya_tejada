package com.riwi.librosya.infraestructure.helpers.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.librosya.api.dto.request.LoanRequest;
import com.riwi.librosya.api.dto.response.LoanResponse;
import com.riwi.librosya.domain.entities.Loan;

import org.mapstruct.Mapping;
@Mapper (componentModel = MappingConstants.ComponentModel.SPRING, uses={BookMapper.class, UserMapper.class})
public interface LoanMappers {
    @Mappings({
        @Mapping(target="id",ignore = true),
        @Mapping(source="user",target= "user.id"),
        @Mapping(source="book",target= "book.id")
    })
    Loan requesttoEntity(LoanRequest loanRequest);

    LoanResponse entitytoResponse (Loan entity);
    Loan responseEntity(LoanResponse loanResponse);
    List<LoanResponse> entitytoResponse(List<Loan>entity);

}
