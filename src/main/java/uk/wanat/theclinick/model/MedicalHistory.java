package uk.wanat.theclinick.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor


@Entity
@Table(name = "medical_history")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "allergy")
    private String allergy;
    @Column(name = "undergone_surgery")
    private String undergoneSurgery;
    @Column(name = "pregnancy")
    private String pregnancy;
    @Column(name = "diabetes")
    private boolean diabetes;
    @Column(name = "cancer_family_history")
    private String cancerFamilyHistory;
    @Column(name = "under_medications")
    private String underMedications;
    @OneToOne(mappedBy = "medicalHistory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Patient patient;


    public MedicalHistory(String allergy, String undergoneSurgery, String pregnancy, boolean diabetes, String cancerFamilyHistory, String underMedications) {
        this.allergy = allergy;
        this.undergoneSurgery = undergoneSurgery;
        this.pregnancy = pregnancy;
        this.diabetes = diabetes;
        this.cancerFamilyHistory = cancerFamilyHistory;
        this.underMedications = underMedications;
    }
}
