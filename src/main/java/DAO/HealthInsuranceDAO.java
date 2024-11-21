package DAO;

import fr.pompey.dev.afpa.model.HealthInsurance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HealthInsuranceDAO extends DAO<HealthInsurance> {

    @Override
    public int create(HealthInsurance obj) {
        int newId = 0;

        StringBuilder insertSQL = new StringBuilder();

        insertSQL.append("INSERT INTO HealthInsurance (hi_name, hi_address, hi_postalCode, " +
                "hi_department, hi_phoneNumber, hi_email, hi_coverageRate) ");
        insertSQL.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

        try {
            PreparedStatement pstmt = connection.prepareStatement(insertSQL.toString(),
                    PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getAddress());
            pstmt.setString(3, obj.getPostalCode());
            pstmt.setString(4, obj.getDepartmentNumber());
            pstmt.setString(5, obj.getPhoneNumber());
            pstmt.setString(6, obj.getEmail());
            pstmt.setDouble(7, obj.getCoverageRate());

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
    public boolean delete(HealthInsurance obj) {
        // Vérifiez si l'ID est null
        if (obj.getId() == null) {
            throw new IllegalArgumentException("Cannot delete a health insurance record without a valid ID");
        }

        StringBuilder deleteSQL = new StringBuilder("DELETE FROM HealthInsurance WHERE healthInsurance_id = ?");

        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL.toString())) {
            pstmt.setInt(1, obj.getId());

            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting health insurance record: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean update(HealthInsurance obj) {
        StringBuilder updateSQL = new StringBuilder("UPDATE HealthInsurance SET hi_name = ?, hi_address = ?, hi_postalCode = ?, " +
                "hi_department = ?, hi_phoneNumber = ?, hi_email = ?, hi_coverageRate = ? WHERE healthInsurance_id = ?");

        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL.toString())) {
            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getAddress());
            pstmt.setString(3, obj.getPostalCode());
            pstmt.setString(4, obj.getDepartmentNumber());
            pstmt.setString(5, obj.getPhoneNumber());
            pstmt.setString(6, obj.getEmail());
            pstmt.setDouble(7, obj.getCoverageRate());
            pstmt.setInt(8, obj.getId());

            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error while updating health insurance record: " + e.getMessage(), e);
        }
    }

    @Override
    public HealthInsurance find(int id) {
        HealthInsurance healthInsurance = null;

        StringBuilder selectById = new StringBuilder("SELECT * FROM HealthInsurance WHERE healthInsurance_id = ?");

        try (PreparedStatement pstmt = connection.prepareStatement(selectById.toString())) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    healthInsurance = new HealthInsurance();
                    healthInsurance.setId(rs.getInt("healthInsurance_id"));
                    healthInsurance.setName(rs.getString("hi_name"));
                    healthInsurance.setAddress(rs.getString("hi_address"));
                    healthInsurance.setPostalCode(rs.getString("hi_postalCode"));
                    healthInsurance.setDepartmentNumber(rs.getString("hi_department"));
                    healthInsurance.setPhoneNumber(rs.getString("hi_phoneNumber"));
                    healthInsurance.setEmail(rs.getString("hi_email"));
                    healthInsurance.setCoverageRate(rs.getDouble("hi_coverageRate"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error during find operation: " + e.getMessage(), e);
        }

        return healthInsurance;
    }

    @Override
    public ArrayList<HealthInsurance> findAll() {
        ArrayList<HealthInsurance> healthInsurances = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM HealthInsurance";

        try (PreparedStatement pstmt = connection.prepareStatement(selectAllQuery);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HealthInsurance healthInsurance = new HealthInsurance();
                healthInsurance.setId(rs.getInt("healthInsurance_id"));
                healthInsurance.setName(rs.getString("hi_name"));
                healthInsurance.setAddress(rs.getString("hi_address"));
                healthInsurance.setPostalCode(rs.getString("hi_postalCode"));
                healthInsurance.setDepartmentNumber(rs.getString("hi_department"));
                healthInsurance.setPhoneNumber(rs.getString("hi_phoneNumber"));
                healthInsurance.setEmail(rs.getString("hi_email"));
                healthInsurance.setCoverageRate(rs.getDouble("hi_coverageRate"));

                healthInsurances.add(healthInsurance);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error during findAll operation: " + e.getMessage(), e);
        }

        return healthInsurances;
    }
}
