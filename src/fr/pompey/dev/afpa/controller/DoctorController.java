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
