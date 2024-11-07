package fr.pompey.dev.afpa.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a purchase made by prescription of doctor in the pharmacy.
 * This class inherits from Purchase and includes additional information such as the prescribing doctor,
 * a list of specialists, and prescription details like indication and posology.
 */
public class PurchaseByPrescription extends Purchase {

    /**
     * The doctor who prescribed the medications
     */
    private Doctor prescribingDoctor;

    /**
     * List of specialists involved in the prescription
     */
    private List<Specialist> specialists;

    /**
     * The indication for the prescription (reason for the medication)
     */
    private String indication;

    /**
     * The posology (dosage instructions) for the prescribed medications
     */
    private String posology;

    /**
     * Constructor for a purchase by prescription.
     *
     * @param purchaseDate      The date the purchase was made
     * @param totalPrice        The total price of the purchase
     * @param medicines         The list of medicines in this purchase
     * @param customer          The customer who made the purchase
     * @param prescribingDoctor The doctor who prescribed the medications
     * @param specialists       The list of specialists involved in the prescription
     * @param indication        The indication for the prescription
     * @param posology          The posology (dosage instructions) for the medications
     */
    public PurchaseByPrescription(LocalDate purchaseDate, double totalPrice, List<Medicine> medicines, Customer customer,
                                  Doctor prescribingDoctor, List<Specialist> specialists, String indication, String posology) {

        super(purchaseDate, totalPrice, medicines, customer);

        setPrescribingDoctor(prescribingDoctor);

        this.specialists = specialists;

        setIndication(indication);

        setPosology(posology);

    }

    /**
     * Gets the doctor who prescribed the medications.
     *
     * @return the prescribing doctor
     */
    public Doctor getPrescribingDoctor() {
        return prescribingDoctor;
    }

    /**
     * Sets the doctor who prescribed the medications.
     *
     * @param prescribingDoctor The prescribing doctor to set
     */
    public void setPrescribingDoctor(Doctor prescribingDoctor) {

        this.prescribingDoctor = prescribingDoctor;

    }

    /**
     * Gets the list of specialists related to the prescription.
     *
     * @return the list of specialists.
     */
    public List<Specialist> getSpecialists() {
        return specialists;
    }

    /**
     * Sets the list of specialists related to the prescription.
     *
     * @param specialists the specialists to set.
     */
    public void setSpecialists(List<Specialist> specialists) {
        this.specialists = specialists;
    }

    /**
     * Gets the indication for the prescription.
     *
     * @return the indication for the prescription.
     */
    public String getIndication() {
        return indication;
    }

    /**
     * Sets the indication for the prescription.
     *
     * @param indication the indication to set.
     */
    public void setIndication(String indication) {
        this.indication = indication;
    }

    /**
     * Gets the posology (dosage) for the prescription.
     *
     * @return the posology for the prescription.
     */
    public String getPosology() {
        return posology;
    }

    /**
     * Sets the posology (dosage) for the prescription.
     *
     * @param posology the posology to set.
     */
    public void setPosology(String posology) {
        this.posology = posology;
    }

    @Override
    public String toString() {
        return "PurchaseByPrescription{" + "prescribingDoctor=" + prescribingDoctor + ", specialists=" + specialists + ", indication='" + indication + '\'' + ", posology='" + posology + '\'' + ", purchaseDate=" + getPurchaseDate() + ", totalPrice=" + getTotalPrice() + ", medicines=" + getMedicines() + ", customer=" + getCustomer() + '}';
    }

}
