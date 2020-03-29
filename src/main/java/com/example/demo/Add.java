package com.example.demo;

import com.example.demo.dao.AddressRepository;
import com.example.demo.dao.OrganizationRepository;
import com.example.demo.dao.PersonRepository;
import com.example.demo.dao.ProtocolRepository;
import com.example.demo.model.Addres;
import com.example.demo.model.Organization;
import com.example.demo.model.Person;
import com.example.demo.model.Protocol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class Add {

    public AddressRepository addressRepository;
    public OrganizationRepository organizationRepository;
    public PersonRepository personRepository;
    public ProtocolRepository protocolRepository;

    public void add(Addres addres) {
        addressRepository.save(addres);
    }

    public void addO(Organization organization) {
        organizationRepository.save(organization);
    }

    public void addP(Person person) {
        personRepository.save(person);
    }

    public void addPp(Protocol protocol) {
        protocolRepository.save(protocol);
    }

}
