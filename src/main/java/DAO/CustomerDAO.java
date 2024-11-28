package DAO;

import fr.pompey.dev.afpa.controller.BDDConnectionManager;
import fr.pompey.dev.afpa.exceptions.InvalidEmailFormatException;
import fr.pompey.dev.afpa.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import fr.pompey.dev.afpa.exceptions.EmailAlreadyExistException;
import fr.pompey.dev.afpa.exceptions.EmptyFieldException;
import fr.pompey.dev.afpa.exceptions.InvalidPhoneNumberException;

/**
 * The type Customer dao.
 */
public class CustomerDAO extends DAO<Customer> {

    private static CustomerDAO instance;

    private Connection connection;

    /**
     * Instantiates a new Customer dao.
     */
    public CustomerDAO() {
        this.connection = BDDConnectionManager.getInstanceDB();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized CustomerDAO getInstance() {
        if (instance == null) {
            instance = new CustomerDAO();
        }
        return instance;
    }

    @Override
    public int create(Customer obj) throws EmailAlreadyExistException, InvalidPhoneNumberException, EmptyFieldException, InvalidEmailFormatException {

        int newId = 0;

        StringBuilder insertSQL = new StringBuilder();

        validateCustomer(obj);

        checkEmailExist(obj.getEmail());

        insertSQL.append("insert into Customer (cu_firstname, cu_lastname, cu_address, " +
                "cu_postalCode, cu_city, cu_phoneNumber, cu_email, cu_birthDate, cu_socialSecurityNumber) ");

        insertSQL.append("values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try {

            PreparedStatement pstmt = connection.prepareStatement(insertSQL.toString(),
                    PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getFirstname());
            pstmt.setString(2, obj.getLastname());
            pstmt.setString(3, obj.getAddress());
            pstmt.setString(4, obj.getPostalCode());
            pstmt.setString(5, obj.getCity());
            pstmt.setString(6, obj.getPhoneNumber());
            pstmt.setString(7, obj.getEmail());
            pstmt.setDate(8, Date.valueOf(obj.getBirthDate()));
            pstmt.setString(9, obj.getSocialSecurityNumber());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                newId = rs.getInt(1);
            }

            return newId;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public boolean delete(Customer obj) {

        // verify if the id is null
        if (obj.getId() == null) {

            throw new IllegalArgumentException("Cannot delete a customer without a valid ID");

        }

        StringBuilder deleteSQL = new StringBuilder("DELETE FROM Customer WHERE customer_id = ?");

        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL.toString())) {

            pstmt.setInt(1, obj.getId());

            int rowAffected = pstmt.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException e) {

            throw new RuntimeException("Error while deleting customer: " + e.getMessage(), e);

        }
    }

    @Override
    public boolean update(Customer obj) throws EmailAlreadyExistException, InvalidPhoneNumberException,
            EmptyFieldException, InvalidEmailFormatException {

        validateCustomer(obj);

//        checkEmailExist(obj.getEmail());

        // verify if the email already exist with excluding the actual customer email
        StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM customer WHERE cu_email = ? AND customer_id != ?");
        try (PreparedStatement ps = connection.prepareStatement(query.toString())) {
            ps.setString(1, obj.getEmail());
            ps.setInt(2, obj.getId());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next() && rs.getInt(1) > 0) {

                    throw new EmailAlreadyExistException("The email " + obj.getEmail() + " already exists.");

                }

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        StringBuilder updateSQL = new StringBuilder("UPDATE Customer SET cu_firstname = ?, cu_lastname = ?, cu_address = ?, " +
                "cu_postalCode = ?, cu_city = ?, cu_phoneNumber = ?, cu_email = ?, " +
                "cu_birthDate = ?, cu_socialSecurityNumber = ? WHERE customer_id = ?");

        try (PreparedStatement pstmt = connection.prepareStatement(String.valueOf(updateSQL))) {

            pstmt.setString(1, obj.getFirstname());
            pstmt.setString(2, obj.getLastname());
            pstmt.setString(3, obj.getAddress());
            pstmt.setString(4, obj.getPostalCode());
            pstmt.setString(5, obj.getCity());
            pstmt.setString(6, obj.getPhoneNumber());
            pstmt.setString(7, obj.getEmail());
            pstmt.setDate(8, Date.valueOf(obj.getBirthDate()));
            pstmt.setString(9, obj.getSocialSecurityNumber());
            pstmt.setInt(10, obj.getId());

            int rowAffected = pstmt.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException e) {

            throw new RuntimeException("Error while updating customer" + e.getMessage(), e);

        }

    }

    @Override
    public Customer find(int id) {

        Customer customer = null; // customer object init

        StringBuilder selectById = new StringBuilder("SELECT * FROM Customer WHERE customer_id = ?");

        try (PreparedStatement pstmt = connection.prepareStatement(selectById.toString())) {

            pstmt.setInt(1, id); // biding id to request

            try (ResultSet rs = pstmt.executeQuery()) { // query execution

                if (rs.next()) { // if a entry was found

                    customer = new Customer();

                    // hydrate customer object
                    customer.setId(rs.getInt("customer_id"));
                    customer.setFirstname(rs.getString("cu_firstname"));
                    customer.setLastname(rs.getString("cu_lastname"));
                    customer.setAddress(rs.getString("cu_address"));
                    customer.setPostalCode(rs.getString("cu_postalCode"));
                    customer.setCity(rs.getString("cu_city"));
                    customer.setPhoneNumber(rs.getString("cu_phoneNumber"));
                    customer.setEmail(rs.getString("cu_email"));
                    customer.setBirthDate(rs.getDate("cu_birthDate").toLocalDate());
                    customer.setSocialSecurityNumber(rs.getString("cu_socialSecurityNumber"));

                }

            } catch (InvalidPhoneNumberException | InvalidEmailFormatException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {

            throw new RuntimeException("Error during find operation: " + e.getMessage(), e);

        }

        return customer; // Return a customer is found or not

    }

    @Override
    public ArrayList<Customer> findAll() {

        ArrayList<Customer> customers = new ArrayList<>();

        String selectAllQuery = "SELECT * FROM Customer";

        try (PreparedStatement pstmt = connection.prepareStatement(selectAllQuery);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstname(rs.getString("cu_firstname"));
                customer.setLastname(rs.getString("cu_lastname"));
                customer.setAddress(rs.getString("cu_address"));
                customer.setPostalCode(rs.getString("cu_postalCode"));
                customer.setCity(rs.getString("cu_city"));

                customer.setPhoneNumber(rs.getString("cu_phoneNumber"));

                customer.setEmail(rs.getString("cu_email"));
                customer.setBirthDate(rs.getDate("cu_birthDate").toLocalDate());
                customer.setSocialSecurityNumber(rs.getString("cu_socialSecurityNumber"));

                customers.add(customer);
            }

        } catch (SQLException e) {

            throw new RuntimeException("Error during findAll operation: " + e.getMessage(), e);

        } catch (InvalidPhoneNumberException | InvalidEmailFormatException e) {
            throw new RuntimeException(e);
        }

        return customers;
    }

    /**
     * Validate customer.
     *
     * @param obj the obj
     * @throws EmptyFieldException         the empty field exception
     * @throws InvalidPhoneNumberException the invalid phone number exception
     * @throws InvalidEmailFormatException the invalid email format exception
     */
    public void validateCustomer(Customer obj) throws EmptyFieldException, InvalidPhoneNumberException, InvalidEmailFormatException {

        if (obj.getFirstname() == null || obj.getFirstname().trim().isEmpty()) {
            throw new EmptyFieldException("First name is required.");
        }

        if (obj.getLastname() == null || obj.getLastname().trim().isEmpty()) {
            throw new EmptyFieldException("Last name is required.");
        }

        if (obj.getEmail() == null || obj.getEmail().trim().isEmpty()) {
            throw new EmptyFieldException("Email is required.");
        }

        if (obj.getPhoneNumber() == null || obj.getPhoneNumber().trim().isEmpty()) {
            throw new EmptyFieldException("Phone number is required.");
        }

        if (!obj.getPhoneNumber().matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits.");
        }

        // Vérifier le format de l'email (regex simplifiée)
        if (!   obj.getEmail().matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidEmailFormatException("Invalid email format: " + obj.getEmail());
        }

    }

    /**
     * Checks if an email already exists in the customer database.
     *
     * <p>This method executes a SQL query to verify if the given email is already present in the database.
     * If the email exists, it throws an {@link fr.pompey.dev.afpa.exceptions.EmailAlreadyExistException}.
     * This prevents adding duplicate email entries.</p>
     *
     * @param email the email address to be checked.
     * @throws EmailAlreadyExistException if the email already exists in the database.
     */
    public void checkEmailExist(String email) throws EmailAlreadyExistException {

        String query = "SELECT COUNT(*) FROM customer WHERE cu_email = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next() && rs.getInt(1) > 0) {

                    throw new EmailAlreadyExistException("The email " + email + " already exists.");

                }

            }

        } catch (SQLException e) {

            throw new RuntimeException("Database error while checking email existence: " + e.getMessage(), e);

        }

    }

}
