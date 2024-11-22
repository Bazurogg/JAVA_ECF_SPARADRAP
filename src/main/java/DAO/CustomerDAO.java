package DAO;

import fr.pompey.dev.afpa.model.Customer;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Customer dao.
 */
public class CustomerDAO extends DAO<Customer> {

    @Override
    public int create(Customer obj) {


        int newId = 0;

        StringBuilder insertSQL = new StringBuilder();

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
    public boolean update(Customer obj) {

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

        }

        return customers;
    }

}
