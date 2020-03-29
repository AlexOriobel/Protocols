package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Addres {

    @Id
    @GeneratedValue(generator = "document-uuid2")
    @GenericGenerator(name = "document-uuid2", strategy = "uuid2")
    private String id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String house;

}
