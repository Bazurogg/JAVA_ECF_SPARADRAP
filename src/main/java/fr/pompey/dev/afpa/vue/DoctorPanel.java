package fr.pompey.dev.afpa.vue;

import DAO.DoctorDAO;
import fr.pompey.dev.afpa.model.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class DoctorPanel extends JPanel {

    private JPanel panelDoctor;
    private JComboBox<Doctor> comboBox_doctorList;
    private JButton addNewDoctorButton;
    private JLabel panelDoctorInfo;
    private JTextField textField_DoctorFirstname;
    private JTextField textField_DoctorLastname;
    private JTextField textField_DoctorAddress;
    private JTextField textField_DoctorEmail;
    private JTextField textField_DoctorCity;
    private JTextField getTextField_DoctorPhone;
    private JTextField textField_DoctorPostalCode;
    private JTextField textField_DoctorAgreementId;
    private JButton updateDoctorButton;
    private JButton deleteDoctorButton;
    private JTextPane textPane1;
    private JTextArea textArea1;
    private DoctorDAO doctorDAO;

    public DoctorPanel(List<Doctor> doctors) {

        doctorDAO = DoctorDAO.getInstance();

        // Initialisation of the components
        initializeComponents();

        doctors = doctorDAO.findAll();

        // Sort the doctor list by alphabetical order base on the Lastname
        Collections.sort(doctors, Comparator.comparing(Doctor::getLastname));

        // make the panel visible
        this.setVisible(true);

        add(panelDoctor);

        // Add doctors to the comboBox
        for (Doctor doctor : doctors) {

            comboBox_doctorList.addItem(doctor);

        }

        // no doctor selected by default
        comboBox_doctorList.setSelectedIndex(-1);

        // Add an ActionListener to update the fields when a doctor is selected
        comboBox_doctorList.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                Doctor selectedDoctor = (Doctor) comboBox_doctorList.getSelectedItem();

                if (selectedDoctor != null) {

                    updateDoctorDetails(selectedDoctor);

                }

            }

        });

    }

    private void initializeComponents() {
        // Suppression des bordures pour les JTextFields

        textField_DoctorAgreementId.setBorder(null);

    }

    // Method to update the JTextFields with doctor information
    private void updateDoctorDetails(Doctor doctor) {
        textField_DoctorFirstname.setText(doctor.getFirstname());
        textField_DoctorLastname.setText(doctor.getLastname());
        textField_DoctorAddress.setText(doctor.getAddress());
        textField_DoctorEmail.setText(doctor.getEmail());
        textField_DoctorCity.setText(doctor.getCity());
        getTextField_DoctorPhone.setText(doctor.getPhoneNumber());
        textField_DoctorPostalCode.setText(doctor.getPostalCode());
        textField_DoctorAgreementId.setText(doctor.getAgreementId());
    }

}