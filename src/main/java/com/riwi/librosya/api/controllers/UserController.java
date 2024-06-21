package com.riwi.librosya.api.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.librosya.api.dto.request.UserRequest;
import com.riwi.librosya.api.dto.response.UserResponse;
import com.riwi.librosya.infraestructure.abstracts_services.IUserServices;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
@Tag(name="User Controller")
public class UserController {
    private final IUserServices userService;

//     @GetMapping
//     public ResponseEntity <Page<UserResponse>>getAll(@RequestParam(defaultValue = "1") int page,
//    @RequestParam(defaultValue = "5") int size ){

//     return ResponseEntity.ok(this.userService.getAll(page-1, size));
//    }
   @PostMapping
     public ResponseEntity<UserResponse> createClass(@Validated UserRequest request) {

        return ResponseEntity.ok(this.userService.create(request));
    }
    @GetMapping("/{id})")
      public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {

                return ResponseEntity.ok(this.userService.get(id));
        }
    @PutMapping(path="/{id}")
        public ResponseEntity<UserResponse> updateStudent(@Validated UserRequest request, @PathVariable Long id) {

                return ResponseEntity.ok(this.userService.update(request, id));
        }
    
}
