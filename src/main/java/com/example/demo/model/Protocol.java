package com.example.demo.model;

import com.example.demo.enums.Condition;
import com.example.demo.enums.DocumentActivity;
import com.example.demo.enums.DocumentCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Protocol {

    @Id
    @GeneratedValue(generator = "document-uuid2")
    @GenericGenerator(name = "document-uuid2", strategy = "uuid2")
    private String id;

    @Column
    private String registrationData;

    @Column
    private String name;

    @Column
    private String checkData;

    @Column
    @Enumerated(EnumType.STRING)
    private DocumentActivity documentAction;

    @Column
    @Enumerated(EnumType.STRING)
    private DocumentCategory documentCategory;

    @Column
    @Enumerated(EnumType.STRING)
    private Condition condition;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Organization organization;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List<Person> person;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ChildDocuments childDocuments;

}
