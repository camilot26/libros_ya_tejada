package com.riwi.librosya.infraestructure.helpers.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.riwi.librosya.api.dto.request.BookRequest;
import com.riwi.librosya.api.dto.response.BookResponse;
import com.riwi.librosya.domain.entities.BookEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    
    @Mappings({
        @Mapping(target = "id",ignore = true),
        @Mapping(target ="loans",ignore = true)
    }
    )
    BookEntity requestBookEntity (BookRequest BookRequest);
    BookResponse entityToResponse (BookEntity entity);
    
    BookEntity responsEntity (BookResponse bookResponse);
    List<BookResponse> entityTBookResponses(List<BookEntity> entity);
}
