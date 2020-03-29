package com.example.demo.dao;

import com.example.demo.model.Protocol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProtocolRepository extends CrudRepository<Protocol, String> {

    @Query("select a from Protocol a where a.name = :name")
    Protocol findByName(@Param("name") String name);


}
