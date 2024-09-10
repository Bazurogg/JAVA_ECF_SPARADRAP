package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.model.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DoctorPanel extends JPanel {

    // Components created by the GUI Designer
    private JLabel doctorsDataManagementLabel;
    private JComboBox<Doctor> comboBoxDoctorList;
    private JButton addANewDoctorButton;
    private JPanel doctorDetails;
    private JLabel labelFirstname;
    private JLabel labelLastname;
    private JLabel labelEmail;
    private JLabel labelPhoneNumber;
    private JLabel labelAgreementId;

    // Constructeur
    public DoctorPanel(List<Doctor> doctors) {
        // Initialise les composants de l'interface
        initUI(doctors);
    }

    // Initialisation de l'interface graphique
    private void initUI(List<Doctor> doctors) {
        // Remplir la combo box avec la liste des médecins
        assert comboBoxDoctorList != null;
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
