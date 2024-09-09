package fr.pompey.dev.afpa.vue;

import fr.pompey.dev.afpa.model.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DoctorPanel extends JPanel {

    // Composants créés par le designer
    private JComboBox<Doctor> comboBoxDoctorList;
    private JButton addANewDoctorButton;
    private JLabel doctorsDataManagementLabel;
    private JPanel doctorDetails;
    private JLabel labelFirstname, labelLastname, labelEmail, labelPhoneNumber, labelAgreementId;

    // Constructeur
    public DoctorPanel(List<Doctor> doctors) {
        // Initialise les composants de l'interface
        initUI(doctors);
    }

    // Initialisation de l'interface graphique
    private void initUI(List<Doctor> doctors) {
        // Assurez-vous que les composants créés par le designer sont correctement initialisés
        // et que vous n'avez pas besoin de les recréer.

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

        // Assurer que le bouton d'ajout a un écouteur, si nécessaire
        addANewDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour ajouter un nouveau médecin
                // Vous pouvez définir ce que vous voulez faire lorsque ce bouton est cliqué
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
