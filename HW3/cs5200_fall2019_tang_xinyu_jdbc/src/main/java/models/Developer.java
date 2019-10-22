package models;
import java.sql.Date;
import java.util.Collection;

import daos.DeveloperDaolmpl;

public class Developer{
	private int id;
    private String developerKey;
    private Person person;

    public Developer(int id, String key, String firstName, String lastName) {
        this.id = id;
        this.developerKey = key;

        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }

    public Developer(int id,
              String key,
              String firstName,
              String lastName,
              String username,
              String password,
              String email) {

        this.id = id;
        this.developerKey = key;

        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setUsername(username);
        person.setPassword(password);
        person.setEmail(email);
    }

    public Developer(int id,
              String key,
              String firstName,
              String lastName,
              String username,
              String password,
              String email,
              Date dob) {

        this.id = id;
        this.developerKey = key;

        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setUsername(username);
        person.setPassword(password);
        person.setEmail(email);
        person.setDob(dob);
    }

    public Developer(int id,
              String key,
              String firstName,
              String lastName,
              String username,
              String password,
              String email,
              Date dob,
              Address address,
              Phone phone
              ) {

        this.id = id;
        this.developerKey = key;

        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setUsername(username);
        person.setPassword(password);
        person.setEmail(email);
        person.setDob(dob);
        person.setAddresses(address);
        person.setPhones(phone);
    }

    public Developer(int id, String key, Person person) {
        this.id = id;
        this.developerKey = key;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDeveloperKey() {
        return developerKey;
    }

    public void setDeveloperKey(String developerKey) {
        this.developerKey = developerKey;
    }
		

}
	
	
