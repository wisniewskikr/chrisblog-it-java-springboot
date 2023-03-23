package com.example.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.documents.HelloWorldDoc;

@Repository
public interface HelloWorldRepository extends ElasticsearchRepository<HelloWorldDoc, String> {}
