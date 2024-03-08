package com.example.application_dev.repository;

import com.example.application_dev.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

}
