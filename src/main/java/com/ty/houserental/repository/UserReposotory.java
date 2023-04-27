package com.ty.houserental.repository;


import org.springframework.data.repository.CrudRepository;

import com.ty.houserental.dto.Users;

public interface UserReposotory extends CrudRepository<Users, Integer>{

}
