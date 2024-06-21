package com.riwi.librosya.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.librosya.domain.entities.UserEntity;

public interface UserRespository extends JpaRepository<UserEntity,Long> {

}
