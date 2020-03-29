package com.example.demo;

import com.example.demo.dao.AddressRepository;
import com.example.demo.dao.OrganizationRepository;
import com.example.demo.dao.PersonRepository;
import com.example.demo.enums.Condition;
import com.example.demo.enums.DocumentActivity;
import com.example.demo.enums.DocumentCategory;
import com.example.demo.model.Addres;
import com.example.demo.model.Organization;
import com.example.demo.model.Person;
import com.example.demo.model.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private Add a;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        add();
    }

    private void add() {

        Addres addres = new Addres();
        addres.setCity("Rage");
        addres.setCountry("Hell");
        addres.setStreet("PainStreet");
        addres.setHouse("HouseOfSafer");
        a.add(addres);

        Organization organization = new Organization();
        organization.setName("HellInCorporated");
        organization.setPhone("666");
        List<Addres> addresList = new ArrayList<>();
        addresList.add(addres);
        organization.setAddress(addresList);
        a.addO(organization);

        Person person = new Person();
        person.setName("Doom");
        person.setSurname("Gay");
        person.setPatroymic("Ripandtear");
        person.setPosition("DaemonSlayer");
        a.addP(person);

		Protocol protocol = new Protocol();
		protocol.setName("Daemons Dead");
		protocol.setRegistrationData("06.06.06");
		protocol.setCheckData("Enternaty");
		protocol.setCondition(Condition.Accept);
		protocol.setDocumentAction(DocumentActivity.ManagementDepartment);
		protocol.setDocumentCategory(DocumentCategory.INNER);
		protocol.setOrganization(organization);
		List<Person>personList = new ArrayList<>();
		personList.add(person);
		protocol.setPerson(personList);
		a.addPp(protocol);

    }

}
