package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.model.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DoctorPanel extends JFrame {

    // Composants créés par le designer
    private JComboBox<Doctor> comboBoxDoctorList;
    private JButton addANewDoctorButton;
    private JLabel doctorsDataManagementLabel;
    private JPanel doctorDetails;
    private JPanel panelDoctor;
    private JLabel labelFirstname, labelLastname, labelEmail, labelPhoneNumber, labelAgreementId;

    // Constructeur
    public DoctorPanel(List<Doctor> doctors) {
        // Initialise les composants de l'interface
        initUI(doctors);

        this.setVisible(true);
        add(panelDoctor);

    }

    // Initialisation de l'interface graphique
    private void initUI(List<Doctor> doctors) {

        // Remplir la combo box avec la liste des médecins
        comboBoxDoctorList.setModel(new DefaultComboBoxModel<>(doctors.toArray(new Doctor[0])));
        comboBoxDoctorList.setSelectedIndex(-1); // Aucun médecin sélectionné par défaut

        // Ajouter un écouteur pour réagir à la sélection d'un médecin
        comboBoxDoctorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode pour afficher les détails du médecin sélectionné
                Doctor selectedDoctor = (Doctor) comboBoxDoctorList.getSelectedItem();
                if (selectedDoctor != null) {
                    displayDoctorDetails(selectedDoctor);
                }
            }
        });

        addANewDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    // Méthode pour afficher les détails du médecin sélectionné
    private void displayDoctorDetails(Doctor doctor) {
        labelFirstname.setText(doctor.getFirstname());
        labelLastname.setText(doctor.getLastname());
        labelEmail.setText(doctor.getEmail());
        labelPhoneNumber.setText(doctor.getPhoneNumber());
        labelAgreementId.setText(doctor.getAgreementId());
    }
}
