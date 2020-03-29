package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.model.Protocol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    /**
     * Создание запроса на имя сотрудника
     * @param name
     * @return сущности Person с совпадающими именами
     */
    @Query("select a from Person a where a.name = :name")
    Person findByName(@Param("name") String name);

    /**
     * Создание запроса на фамилию сотрудника
     * @param surname фамилию сотрудника
     * @return сущности Person с совпадающими фамилию
     */
    @Query("select b from Person b where b.surname = :surname")
    Person findBySurname(@Param("surname") String surname);

    /**
     * Создание запроса на отчество сотрудника
     * @param patroymic отчество сотрудника
     * @return сущности Person с совпадающими отчество
     */
    @Query("select c from Person c where c.patroymic = :patroymic")
    Person findByPatroymic(@Param("patroymic") String patroymic);

    /**
     * Создание запроса на должности сотрудника
     * @param position должности сотрудника
     * @return сущности Person с совпадающими должностями
     */
    @Query("select d from Person d where d.position = :position")
    Person findByPosition(@Param("position") String position);

    /**
     * Создает запрос на сущность по имени, фамилии, отчеству
     * @param name имя сотрудника
     * @param surname фамилия сотрудника
     * @param patroymic отчество сотрудника
     * @return сущность Person
     */
    @Query("select d from Person d where d.name = :name and d.surname = :surname and d.patroymic = :patroymic")
    Person findPersonByFullName(
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("patroymic") String patroymic

    );


}
