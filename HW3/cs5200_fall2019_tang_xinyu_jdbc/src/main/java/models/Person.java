package models;
import java.sql.Date;
import java.util.List;

public class Person {
	private int id;
    private String firstName = "peng"; // default values
    private String lastName = "tong";
    private String username = "tp";
    private String password = "1234";
    private String email = "ptong@gmail.com";
    private Date dob;
    private List<Phone> phones;
    private List<Address> addresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Phone phone) {
        this.phones = phone;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Address address) {
        this.addresses = address;
    }
}
