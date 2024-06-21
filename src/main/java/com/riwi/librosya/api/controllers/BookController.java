package com.riwi.librosya.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.librosya.api.dto.request.BookRequest;
import com.riwi.librosya.api.dto.request.UserRequest;
import com.riwi.librosya.api.dto.response.BookResponse;
import com.riwi.librosya.api.dto.response.UserResponse;
import com.riwi.librosya.infraestructure.abstracts_services.IBookServices;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/controller")
@AllArgsConstructor
@Tag(name = "Book Controller")
public class BookController {
    private final IBookServices bookServices;

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(this.bookServices.getAll(page - 1, size));
    }

    @GetMapping("/{id})")
    public ResponseEntity<BookResponse> getUser(@PathVariable Long id) {

        return ResponseEntity.ok(this.bookServices.get(id));
    }

    @PostMapping
    public ResponseEntity<BookResponse> createClass(@Validated BookRequest request) {

        return ResponseEntity.ok(this.bookServices.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BookResponse> updateStudent(@Validated BookRequest request, @PathVariable Long id) {

        return ResponseEntity.ok(this.bookServices.update(request, id));
    }
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.bookServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
