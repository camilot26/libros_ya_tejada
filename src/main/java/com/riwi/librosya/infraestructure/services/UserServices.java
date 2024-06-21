package com.riwi.librosya.infraestructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.librosya.api.dto.request.UserRequest;
import com.riwi.librosya.api.dto.response.UserResponse;
import com.riwi.librosya.domain.entities.UserEntity;
import com.riwi.librosya.domain.repositories.UserRespository;
import com.riwi.librosya.infraestructure.abstracts_services.IUserServices;
import com.riwi.librosya.infraestructure.helpers.Mappers.UserMapper;
import com.riwi.librosya.util.excepcions.BadRequestException;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServices implements IUserServices {
    @Autowired
    private final UserRespository userRespository;
    private final UserMapper userMapper;
    @Override
    public UserResponse create(UserRequest request) {
        UserEntity entity = this.userMapper.requesttoEntity(request);
        entity.setLoans(new ArrayList<>());
        return this.userMapper.entityToResponse(this.userRespository.save(entity));
    }

    @Override
    public void delete(Long id) {
       this.userRespository.delete(this.find(id));
        
    }

    @Override
    public UserResponse get(Long id) {
        
        return this.userMapper.entityToResponse(this.find(id));
    }

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        Page<UserEntity> userPage=userRespository.findAll(pagination);
        List<UserResponse> userResponse= this.userMapper.entityToResponse(userPage.getContent());
        return new PageImpl<>(userResponse,pagination,userPage.getTotalElements());
        
    }

    @Override
    public UserResponse update(UserRequest request, Long id) {
        UserEntity user = this.find(id);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setRole(request.getRole());
        user.setId(id);
        return this.userMapper.entityToResponse(this.userRespository.save(user));
    }
    // propios

    private UserEntity find(Long id){

        return this.userRespository.findById(id).orElseThrow(()->new BadRequestException("ID NOT FOUND"));
    }



}
