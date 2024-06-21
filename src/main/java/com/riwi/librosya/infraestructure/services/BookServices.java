package com.riwi.librosya.infraestructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.librosya.api.dto.request.BookRequest;
import com.riwi.librosya.api.dto.response.BookResponse;
import com.riwi.librosya.domain.entities.BookEntity;

import com.riwi.librosya.domain.repositories.BookRepository;
import com.riwi.librosya.infraestructure.abstracts_services.IBookServices;
import com.riwi.librosya.infraestructure.helpers.Mappers.BookMapper;
import com.riwi.librosya.util.excepcions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServices implements IBookServices {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final BookMapper bookMapper;

    @Override
    public BookResponse create(BookRequest request) {
        BookEntity entity = this.bookMapper.requestBookEntity(request);
        entity.setLoans(new ArrayList<>());
        return this.bookMapper.entityToResponse(this.bookRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.delete(this.find(id));

    }

    @Override
    public BookResponse get(Long id) {
        return this.bookMapper.entityToResponse(this.find(id));
    }

    @Override
    public Page<BookResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        Page<BookEntity> bookPage = bookRepository.findAll(pagination);
        List<BookResponse> bookResponse = this.bookMapper.entityTBookResponses(bookPage.getContent());
        return new PageImpl<>(bookResponse, pagination,bookPage.getTotalElements());
    }

    @Override
    public BookResponse update(BookRequest request, Long id) {
        BookEntity book = this.find(id);
        book.setTitle(request.getTitle());
        book.setAutor(request.getAutor());
        book.setPublicationYear(request.getPublicationYear());
        book.setIsbn(request.getIsbn());
        book.setGenre(request.getGenre());
        book.setId(id);
        return this.bookMapper.entityToResponse(this.bookRepository.save(book));
    }

    // propios
    private BookEntity find(long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new BadRequestException("ID NOT FOUND"));
    }
}
