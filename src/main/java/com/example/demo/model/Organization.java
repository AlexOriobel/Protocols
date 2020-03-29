package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Organization {
    @Id
    @GeneratedValue(generator = "document-uuid2")
    @GenericGenerator(name = "document-uuid2", strategy = "uuid2")
    private String id;

    @Column
    private String name;

    @Column
    private String phone;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List <Addres> address;
}
