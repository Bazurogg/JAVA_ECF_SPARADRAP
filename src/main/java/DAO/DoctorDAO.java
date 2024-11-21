package DAO;

import fr.pompey.dev.afpa.model.Doctor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDAO extends DAO<Doctor> {

    @Override
    public int create(Doctor obj) {
        int newId = 0;

        StringBuilder insertSQL = new StringBuilder();

        insertSQL.append("INSERT INTO Doctor (doc_firstname, doc_lastname, doc_address, " +
                "doc_postalCode, doc_city, doc_phoneNumber, doc_email, doc_agreementId) ");
        insertSQL.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

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
            pstmt.setString(8, obj.getAgreementId());

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
    public boolean delete(Doctor obj) {
        // Vérifiez si l'ID est null
        if (obj.getId() == null) {
            throw new IllegalArgumentException("Cannot delete a doctor without a valid ID");
        }

        StringBuilder deleteSQL = new StringBuilder("DELETE FROM Doctor WHERE doctor_id = ?");

        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL.toString())) {
            pstmt.setInt(1, obj.getId());

            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting doctor: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Doctor obj) {
        StringBuilder updateSQL = new StringBuilder("UPDATE Doctor SET doc_firstname = ?, doc_lastname = ?, doc_address = ?, " +
                "doc_postalCode = ?, doc_city = ?, doc_phoneNumber = ?, doc_email = ?, doc_agreementId = ? WHERE doctor_id = ?");

        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL.toString())) {
            pstmt.setString(1, obj.getFirstname());
            pstmt.setString(2, obj.getLastname());
            pstmt.setString(3, obj.getAddress());
            pstmt.setString(4, obj.getPostalCode());
            pstmt.setString(5, obj.getCity());
            pstmt.setString(6, obj.getPhoneNumber());
            pstmt.setString(7, obj.getEmail());
            pstmt.setString(8, obj.getAgreementId());
            pstmt.setInt(9, obj.getId());

            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error while updating doctor: " + e.getMessage(), e);
        }
    }

    @Override
    public Doctor find(int id) {
        Doctor doctor = null;

        StringBuilder selectById = new StringBuilder("SELECT * FROM Doctor WHERE doctor_id = ?");

        try (PreparedStatement pstmt = connection.prepareStatement(selectById.toString())) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    doctor = new Doctor();
                    doctor.setId(rs.getInt("doctor_id"));
                    doctor.setFirstname(rs.getString("doc_firstname"));
                    doctor.setLastname(rs.getString("doc_lastname"));
                    doctor.setAddress(rs.getString("doc_address"));
                    doctor.setPostalCode(rs.getString("doc_postalCode"));
                    doctor.setCity(rs.getString("doc_city"));
                    doctor.setPhoneNumber(rs.getString("doc_phoneNumber"));
                    doctor.setEmail(rs.getString("doc_email"));
                    doctor.setAgreementId(rs.getString("doc_agreementId"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error during find operation: " + e.getMessage(), e);
        }

        return doctor;
    }

    @Override
    public ArrayList<Doctor> findAll() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM Doctor";

        try (PreparedStatement pstmt = connection.prepareStatement(selectAllQuery);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("doctor_id"));
                doctor.setFirstname(rs.getString("doc_firstname"));
                doctor.setLastname(rs.getString("doc_lastname"));
                doctor.setAddress(rs.getString("doc_address"));
                doctor.setPostalCode(rs.getString("doc_postalCode"));
                doctor.setCity(rs.getString("doc_city"));
                doctor.setPhoneNumber(rs.getString("doc_phoneNumber"));
                doctor.setEmail(rs.getString("doc_email"));
                doctor.setAgreementId(rs.getString("doc_agreementId"));

                doctors.add(doctor);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error during findAll operation: " + e.getMessage(), e);
        }

        return doctors;
    }
}
