package models;

public class User {

    private int id;
    private boolean userAgreement;
    private Person person;

    User(int id, String firstName, String lastName) {
        this.id = id;
        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUserAgreement() {
        return userAgreement;
    }

    public void setUserAgreement(boolean userAgreement) {
        this.userAgreement = userAgreement;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}