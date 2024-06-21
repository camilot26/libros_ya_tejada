package com.riwi.librosya.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.riwi.librosya.domain.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long>{
    List<Loan> findByUserId(Long userId);
}
