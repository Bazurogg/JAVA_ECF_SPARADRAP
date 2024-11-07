package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.model.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class DoctorPanel extends JPanel {

    private JPanel panelDoctor;
    private JComboBox<Doctor> comboBox1;
    private JButton addNewDoctorButton;
    private JLabel panelDoctorInfo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextPane textPane1;
    private JTextArea textArea1;

    public DoctorPanel(List<Doctor> doctors) {

        // Initialisation of the components
        initializeComponents();

        // Sort the doctor list by alphabetical order base on the Lastname
        Collections.sort(doctors, Comparator.comparing(Doctor::getLastname));

        // make the panel visible
        this.setVisible(true);

        add(panelDoctor);

        // Add doctors to the comboBox
        for (Doctor doctor : doctors) {

            comboBox1.addItem(doctor);

        }

        // no doctor selected by default
        comboBox1.setSelectedIndex(-1);

        // Add an ActionListener to update the fields when a doctor is selected
        comboBox1.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                Doctor selectedDoctor = (Doctor) comboBox1.getSelectedItem();

                if (selectedDoctor != null) {

                    updateDoctorDetails(selectedDoctor);

                }

            }

        });

    }

    private void initializeComponents() {
        // Suppression des bordures pour les JTextFields

        textField8.setBorder(null);

    }

    // Method to update the JTextFields with doctor information
    private void updateDoctorDetails(Doctor doctor) {
        textField1.setText(doctor.getFirstname());
        textField2.setText(doctor.getLastname());
        textField3.setText(doctor.getAddress());
        textField4.setText(doctor.getEmail());
        textField5.setText(doctor.getCity());
        textField6.setText(doctor.getPhoneNumber());
        textField7.setText(doctor.getPostalCode());
        textField8.setText(doctor.getAgreementId());
    }

}