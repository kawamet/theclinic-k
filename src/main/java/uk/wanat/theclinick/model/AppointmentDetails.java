package uk.wanat.theclinick.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
public class AppointmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "appointmentDetails")
    private Appointment appointment;
    @Column(name = "nature_of_sickness_and_symptoms")
    private String natureOfSicknessAndSymptoms;
    @Column(name = "medical_examination")
    private String medicalExamination;
    @Column(name = "treatment")
    private String treatment;
    @Column(name = "medicine")
    private String medicine;

    @Builder
    public AppointmentDetails(String natureOfSicknessAndSymptoms, String medicalExamination, String treatment, String medicine) {
        this.natureOfSicknessAndSymptoms = natureOfSicknessAndSymptoms;
        this.medicalExamination = medicalExamination;
        this.treatment = treatment;
        this.medicine = medicine;
    }
}
