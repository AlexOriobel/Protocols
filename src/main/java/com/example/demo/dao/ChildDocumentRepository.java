package com.example.demo.dao;

import com.example.demo.model.ChildDocuments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildDocumentRepository extends CrudRepository<ChildDocuments, String> {
}
