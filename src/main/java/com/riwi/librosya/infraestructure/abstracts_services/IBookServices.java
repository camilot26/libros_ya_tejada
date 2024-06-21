package com.riwi.librosya.infraestructure.abstracts_services;

import com.riwi.librosya.api.dto.request.BookRequest;
import com.riwi.librosya.api.dto.response.BookResponse;

public interface IBookServices extends CrudService<BookRequest,BookResponse,Long>{

}
