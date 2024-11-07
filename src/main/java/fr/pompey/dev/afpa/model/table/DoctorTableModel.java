package fr.pompey.dev.afpa.model.table;

import fr.pompey.dev.afpa.model.Doctor;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DoctorTableModel extends AbstractTableModel {

    // Les noms des colonnes pour la table des médecins
    private final String[] columnNames = {"Firstname", "Lastname", "Email", "Phone Number", "Agreement ID"};

    // Liste des médecins à afficher dans la table
    private final List<Doctor> doctors;

    // Constructeur qui prend en paramètre la liste des médecins
    public DoctorTableModel(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public int getRowCount() {
        return doctors.size(); // Retourne le nombre de médecins (lignes)
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Retourne le nombre de colonnes
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Récupère le médecin à l'index de la ligne
        Doctor doctor = doctors.get(rowIndex);

        // Retourne la valeur correspondant à la colonne demandée
        switch (columnIndex) {
            case 0:
                return doctor.getFirstname(); // Colonne "Firstname"
            case 1:
                return doctor.getLastname(); // Colonne "Lastname"
            case 2:
                return doctor.getEmail(); // Colonne "Email"
            case 3:
                return doctor.getPhoneNumber(); // Colonne "Phone Number"
            case 4:
                return doctor.getAgreementId(); // Colonne "Agreement ID"
            default:
                return null; // Si la colonne n'existe pas, retourne null
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Retourne le nom de la colonne
    }

}
