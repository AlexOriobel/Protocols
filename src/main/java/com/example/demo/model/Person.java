package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(generator = "document-uuid2")
    @GenericGenerator(name = "document-uuid2", strategy = "uuid2")
    private String id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patroymic;

    @Column
    private String position;
}
