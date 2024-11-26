package fr.pompey.dev.afpa.model;

/**
 * Represents a person with basic contact information.
 * This superclass provides common properties such as first name, last name,
 * and contact details that can be inherited by other classes.
 */
public class Person {

    /** The DB id for the person. */
    private Integer id;

    /** The first name of the person. */
    private String firstname;

    /** The last name of the person. */
    private String lastname;

    /** The address of the person. */
    private String address;

    /** The postal code of the person's address. */
    private String postalCode;

    /** The city where the person resides. */
    private String city;

    /** The phone number of the person. */
    private String phoneNumber;

    /** The email address of the person. */
    private String email;

    /**
     * Constructor for the Person class.
     *
     * @param id          The database id of the person.
     * @param firstname   The first name of the person.
     * @param lastname    The last name of the person.
     * @param address     The address of the person.
     * @param postalCode  The postal code of the person's address.
     * @param city        The city where the person lives.
     * @param phoneNumber The phone number of the person.
     * @param email       The email address of the person.
     * @throws IllegalArgumentException If any of the parameters fail validation.
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
     * Constructor for the Person class without an ID.
     *
     * @param firstname   The first name of the person.
     * @param lastname    The last name of the person.
     * @param address     The address of the person.
     * @param postalCode  The postal code of the person's address.
     * @param city        The city where the person lives.
     * @param phoneNumber The phone number of the person.
     * @param email       The email address of the person.
     * @throws IllegalArgumentException If any of the parameters fail validation.
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
     * Default constructor for the Person class.
     */
    public Person() {}

    /**
     * Gets the database id of the person.
     *
     * @return The DB ID of the person.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the database id  of the person.
     *
     * @param id The DB ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name of the person.
     *
     * @return The first name.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstname The first name to set.
     * @throws IllegalArgumentException If the first name is null or empty.
     */
    public void setFirstname(String firstname) {
        if (firstname == null || firstname.trim().isEmpty()) {
            throw new IllegalArgumentException("Firstname cannot be null or empty.");
        }
        this.firstname = firstname;
    }

    /**
     * Gets the last name of the person.
     *
     * @return The last name.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastname The last name to set. It will be stored in uppercase.
     * @throws IllegalArgumentException If the last name is null or empty.
     */
    public void setLastname(String lastname) {
        if (lastname == null || lastname.trim().isEmpty()) {
            throw new IllegalArgumentException("Lastname cannot be null or empty.");
        }
        this.lastname = lastname.toUpperCase();
    }

    /**
     * Gets the address of the person.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the person.
     *
     * @param address The address to set.
     * @throws IllegalArgumentException If the address is null or empty.
     */
    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        this.address = address;
    }

    /**
     * Gets the postal code of the person's address.
     *
     * @return The postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code of the person's address.
     *
     * @param postalCode The postal code to set. Must be a 5-digit number.
     * @throws IllegalArgumentException If the postal code is not a valid 5-digit number.
     */
    public void setPostalCode(String postalCode) {
        if (postalCode == null || !postalCode.matches("\\d{5}")) {
            throw new IllegalArgumentException("Postal code must be a 5-digit number.");
        }
        this.postalCode = postalCode;
    }

    /**
     * Gets the city where the person resides.
     *
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the person resides.
     *
     * @param city The city to set.
     * @throws IllegalArgumentException If the city is null or empty.
     */
    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty.");
        }
        this.city = city;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNumber The phone number to set. Must be a valid 10-digit number.
     * @throws IllegalArgumentException If the phone number is not valid.
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be a valid 10-digit number.");
        }
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email address of the person.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the person.
     *
     * @param email The email address to set. Must follow a valid email format.
     * @throws IllegalArgumentException If the email address is invalid.
     */
    public void setEmail(String email) {
        if (email == null || !email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.email = email;
    }
}
