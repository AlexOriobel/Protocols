package com.example.demo.dao;

import com.example.demo.model.Organization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
    /**
     * Создание запроса на отчество сотрудника
     * @param name имя организации
     * @return сущности Person с совпадающими отчество
     */
    @Query("select v from Organization v where v.name = :name")
    Organization findByName(@Param("name") String name);
}
