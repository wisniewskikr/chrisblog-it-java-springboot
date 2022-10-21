package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.UserEntity;
import com.example.enums.UserTypeEnum;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	public UserEntity findByUserNameAndUserType(String userName, UserTypeEnum userType);

}
