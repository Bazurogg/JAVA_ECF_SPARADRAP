package fr.pompey.dev.afpa.model;

/**
 * Represents a health insurance provider.
 * This class contains the details of the insurance company including the name, contact information,
 * and the coverage rate for health services or purchases.
 */
public class HealthInsurance {

    /** The name of the health insurance company */
    private String name;

    /** The address of the health insurance company */
    private String address;

    /** The postal code of the health insurance company's location */
    private String postalCode;

    /** The department number where the health insurance company is located */
    private String departmentNumber;

    /** The phone number to contact the health insurance company */
    private String phoneNumber;

    /** The email address of the health insurance company */
    private String email;

    /** The rate of coverage offered by the health insurance (in percentage, e.g., 75 for 75%) */
    private double coverageRate;

    /**
     * Constructor for the HealthInsurance class.
     *
     * @param name The name of the health insurance company
     * @param address The address of the health insurance company
     * @param postalCode The postal code of the health insurance company's location
     * @param departmentNumber The department number of the insurance provider
     * @param phoneNumber The phone number of the health insurance company
     * @param email The email address of the health insurance company
     * @param coverageRate The coverage rate (percentage) of the insurance
     */
    public HealthInsurance(String name, String address, String postalCode, String departmentNumber,
                           String phoneNumber, String email, double coverageRate) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.departmentNumber = departmentNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.coverageRate = coverageRate;
    }

    /**
     * Gets the name of the health insurance company.
     *
     * @return the name of the insurance company
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the health insurance company.
     *
     * @param name the name of the insurance company
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the health insurance company.
     *
     * @return the address of the insurance company
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the health insurance company.
     *
     * @param address the address of the insurance company
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the postal code of the health insurance company.
     *
     * @return the postal code of the insurance company
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code of the health insurance company.
     *
     * @param postalCode the postal code of the insurance company
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the department number where the insurance company is located.
     *
     * @return the department number of the insurance company
     */
    public String getDepartmentNumber() {
        return departmentNumber;
    }

    /**
     * Sets the department number where the insurance company is located.
     *
     * @param departmentNumber the department number of the insurance company
     */
    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    /**
     * Gets the phone number of the health insurance company.
     *
     * @return the phone number of the insurance company
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the health insurance company.
     *
     * @param phoneNumber the phone number of the insurance company
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email address of the health insurance company.
     *
     * @return the email address of the insurance company
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the health insurance company.
     *
     * @param email the email address of the insurance company
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the coverage rate offered by the health insurance.
     *
     * @return the coverage rate as a percentage
     */
    public double getCoverageRate() {
        return coverageRate;
    }

    /**
     * Sets the coverage rate offered by the health insurance.
     *
     * @param coverageRate the coverage rate to set (percentage)
     */
    public void setCoverageRate(double coverageRate) {
        this.coverageRate = coverageRate;
    }

    @Override
    public String toString() {
        return "HealthInsurance{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", departmentNumber='" + departmentNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", coverageRate=" + coverageRate +
                '}';
    }
}
