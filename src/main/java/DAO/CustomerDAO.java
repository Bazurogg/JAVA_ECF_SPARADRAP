package DAO;

import fr.pompey.dev.afpa.model.Customer;

import javax.swing.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomerDAO extends DAO<Customer> {

    @Override
    public int create(Customer obj) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int newId = 0;

        StringBuilder insertSQL = new StringBuilder();
        insertSQL.append("insert into Customer (customer_id, cu_firstname, cu_lastname, cu_address, " +
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

            String birthDate = sdf.format(obj.getBirthDate());
            pstmt.setDate(8, Date.valueOf(birthDate));

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
        return false;
    }

    @Override
    public boolean update(Customer obj) {
        return false;
    }

    @Override
    public Customer find(int id) {
        return null;
    }

    @Override
    public ArrayList<Customer> findAll() {
        return null;
    }

}
