package fr.pompey.dev.afpa.controller;

import fr.pompey.dev.afpa.model.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * DoctorController is a class dedicated to managing the list of doctors.
 */
public class DoctorController {

    /** The list of doctors */
    private List<Doctor> doctors;

    /** Constructor to initialize the doctor list */
    public DoctorController() {
        this.doctors = new ArrayList<>();
        initializeDoctors();
    }



    // auto generated list of doctors registered
    private void initializeDoctors() {
        doctors.add(new Doctor("John", "Doe", "123 Rue de Rivoli", "75001", "Paris", "0600000001", "john.doe@mail.com", "AG1001"));
        doctors.add(new Doctor("Jane", "Smith", "12 Avenue des Champs-Élysées", "75008", "Paris", "0600000002", "jane.smith@mail.com", "AG1002"));
        doctors.add(new Doctor("Robert", "Johnson", "45 Boulevard Haussmann", "75009", "Paris", "0600000003", "robert.johnson@mail.com", "AG1003"));
        doctors.add(new Doctor("Emily", "Davis", "7 Rue de la Paix", "75002", "Paris", "0600000004", "emily.davis@mail.com", "AG1004"));
        doctors.add(new Doctor("Michael", "Miller", "33 Quai de la Seine", "75019", "Paris", "0600000005", "michael.miller@mail.com", "AG1005"));
        doctors.add(new Doctor("Laura", "Garcia", "88 Avenue de la République", "75011", "Paris", "0600000006", "laura.garcia@mail.com", "AG1006"));
        doctors.add(new Doctor("James", "Martinez", "99 Rue de Rennes", "75006", "Paris", "0600000007", "james.martinez@mail.com", "AG1007"));
        doctors.add(new Doctor("Anna", "Rodriguez", "15 Boulevard Saint-Michel", "75005", "Paris", "0600000008", "anna.rodriguez@mail.com", "AG1008"));
        doctors.add(new Doctor("David", "Hernandez", "28 Rue du Faubourg Saint-Honoré", "75008", "Paris", "0600000009", "david.hernandez@mail.com", "AG1009"));
        doctors.add(new Doctor("Sarah", "Lopez", "66 Avenue Victor Hugo", "75116", "Paris", "0600000010", "sarah.lopez@mail.com", "AG1010"));
        doctors.add(new Doctor("Matthew", "Wilson", "37 Rue des Pyrénées", "75020", "Paris", "0600000011", "matthew.wilson@mail.com", "AG1011"));
        doctors.add(new Doctor("Olivia", "Clark", "20 Rue de Belleville", "75019", "Paris", "0600000012", "olivia.clark@mail.com", "AG1012"));
        doctors.add(new Doctor("Daniel", "Lewis", "5 Rue Saint-Dominique", "75007", "Paris", "0600000013", "daniel.lewis@mail.com", "AG1013"));
        doctors.add(new Doctor("Sophia", "Lee", "43 Avenue de Wagram", "75017", "Paris", "0600000014", "sophia.lee@mail.com", "AG1014"));
        doctors.add(new Doctor("Christopher", "Walker", "18 Rue du Commerce", "75015", "Paris", "0600000015", "christopher.walker@mail.com", "AG1015"));
        doctors.add(new Doctor("Isabella", "Hall", "25 Rue de la Convention", "75015", "Paris", "0600000016", "isabella.hall@mail.com", "AG1016"));
        doctors.add(new Doctor("Andrew", "Young", "11 Rue de Tolbiac", "75013", "Paris", "0600000017", "andrew.young@mail.com", "AG1017"));
        doctors.add(new Doctor("Charlotte", "Allen", "76 Rue d'Alésia", "75014", "Paris", "0600000018", "charlotte.allen@mail.com", "AG1018"));
        doctors.add(new Doctor("Joshua", "King", "9 Rue Lamarck", "75018", "Paris", "0600000019", "joshua.king@mail.com", "AG1019"));
        doctors.add(new Doctor("Mia", "Wright", "22 Boulevard de Strasbourg", "75010", "Paris", "0600000020", "mia.wright@mail.com", "AG1020"));
    }


    /**
     * Adds a doctor to the list of doctors.
     *
     * @param doctor the doctor to add.
     */
    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    /**
     * Removes a doctor from the list of doctors.
     *
     * @param doctor the doctor to remove.
     */
    public void removeDoctor(Doctor doctor) {
        this.doctors.remove(doctor);
    }

    /**
     * Returns the list of doctors.
     *
     * @return the list of doctors.
     */
    public List<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Prints the list of doctors to the console.
     */
    public void displayDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
        } else {
            System.out.println("List of doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getFirstname() + " " + doctor.getLastname() + " - Agreement ID: " + doctor.getAgreementId());
            }
        }
    }
}
