package com.riwi.librosya.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.librosya.domain.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Long> {

}
