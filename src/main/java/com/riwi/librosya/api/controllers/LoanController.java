package com.riwi.librosya.api.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.librosya.api.dto.request.BookRequest;
import com.riwi.librosya.api.dto.request.LoanRequest;
import com.riwi.librosya.api.dto.response.BookResponse;
import com.riwi.librosya.api.dto.response.LoanResponse;
import com.riwi.librosya.domain.entities.Loan;
import com.riwi.librosya.infraestructure.abstracts_services.ILoanServices;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/controller")
@AllArgsConstructor
@Tag(name = "Loan Controller")
public class LoanController {
    private final ILoanServices loanservices;


  @GetMapping
    public ResponseEntity<Page<LoanResponse>> getAll(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(this.loanservices.getAll(page - 1, size));
    }
     @GetMapping("/{id})")
    public ResponseEntity<LoanResponse> getUser(@PathVariable Long id) {

        return ResponseEntity.ok(this.loanservices.get(id));
    }
    @PostMapping
    public ResponseEntity<LoanResponse> createClass(@Validated LoanRequest request) {

        return ResponseEntity.ok(this.loanservices.create(request));
    }
    @GetMapping(path="users/{user_id}/loans")
    public ResponseEntity<List<LoanResponse>> getAllLoansByUserId(@PathVariable Long userId) {
        List<LoanResponse> loans = loanservices.getAllLoansByUserId(userId);
        return ResponseEntity.ok(loans);
    }
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.loanservices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
