package fr.pompey.dev.afpa.model;


/**
 * Represents a person with basic contact information.
 * This super class serves to build other child class
 * who have same personal details such as first name, last name, address, etc.
 */
public class Person {

    private Integer id;

    private String firstname;

    private String lastname;

    private String address;

    private String postalCode;

    private String city;

    private String phoneNumber;

    private String email;

    /**
     * Constructor for the Person class.
     *
     * @param id          The id of the person.
     * @param firstname   The first name of the person.
     * @param lastname    The last name of the person.
     * @param address     The address of the person.
     * @param postalCode  The postal code of the person's address.
     * @param city        The city where the person lives.
     * @param phoneNumber The phone number of the person.
     * @param email       The email address of the person.
     */
    public Person(Integer id, String firstname, String lastname, String address, String postalCode, String city,
                  String phoneNumber, String email) {

        setFirstname(firstname);

        setLastname(lastname);

        setAddress(address);

        setPostalCode(postalCode);

        setCity(city);

        setPhoneNumber(phoneNumber);

        setEmail(email);

    }

    /**
     * Instantiates a new Person.
     *
     * @param firstname   the firstname
     * @param lastname    the lastname
     * @param address     the address
     * @param postalCode  the postal code
     * @param city        the city
     * @param phoneNumber the phone number
     * @param email       the email
     */
    public Person(String firstname, String lastname, String address, String postalCode, String city,
                  String phoneNumber, String email) {

        setFirstname(firstname);

        setLastname(lastname);

        setAddress(address);

        setPostalCode(postalCode);

        setCity(city);

        setPhoneNumber(phoneNumber);

        setEmail(email);

    }

    /**
     * Constructor for the Person class.
     * with 0 parameter
     */
    public Person() {}


    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {

        return id;

    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets firstname.
     *
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets lastname.
     *
     * @param lastname the lastname to set. It will be stored in uppercase.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname != null ? lastname.toUpperCase() : null;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets postal code.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets postal code.
     *
     * @param postalCode the postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Sets id.
     *
     * @param id the
     */
    public void setId(int id) { this.id = id; }

}