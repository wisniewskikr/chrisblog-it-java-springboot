package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.TokenEntity;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, Long> {
	
	public TokenEntity findByValue(String value);
	
}
