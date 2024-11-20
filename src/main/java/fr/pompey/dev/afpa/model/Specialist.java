package fr.pompey.dev.afpa.model;

/**
 * The type Specialist.
 */
public class Specialist extends Person {

    private String speciality;

    /**
     * Constructor for the Specialist class.
     *
     * @param firstname   The first name of the specialist.
     * @param lastname    The last name of the specialist.
     * @param address     The address of the specialist .
     * @param postalCode  The postal code of the specialist's address.
     * @param city        The city where the specialist work.
     * @param phoneNumber The phone number of the specialist.
     * @param email       The email address of the specialist.
     * @param speciality  The speciality domain the specialist work in.
     */
    public Specialist(Integer id, String firstname, String lastname, String address, String postalCode,
                      String city, String phoneNumber, String email, String speciality) {

        super(id, firstname, lastname, address, postalCode, city, phoneNumber, email);

        setSpeciality(speciality);

    }

    /**
     * Gets speciality of the specialist.
     *
     * @return the speciality
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Sets speciality of the specialist.
     *
     * @param speciality the speciality
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}
