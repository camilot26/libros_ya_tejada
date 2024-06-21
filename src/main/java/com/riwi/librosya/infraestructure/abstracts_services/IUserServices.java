package com.riwi.librosya.infraestructure.abstracts_services;

import com.riwi.librosya.api.dto.request.UserRequest;
import com.riwi.librosya.api.dto.response.UserResponse;

public interface IUserServices extends CrudService<UserRequest,UserResponse,Long> {

}
