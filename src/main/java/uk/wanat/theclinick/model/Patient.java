package uk.wanat.theclinick.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor


@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Column(name = "phone_number", length = 30)
    private String phoneNumber;
    @Column(name = "national_insurance_number", length = 30)
    private String nationalInsuranceNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "medical_history_id", referencedColumnName = "id")
    private MedicalHistory medicalHistory;
    //role + spring sceurity

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "patient",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Appointment> appointments;

    public Patient(String firstName, String lastName, Gender gender, String phoneNumber, String nationalInsuranceNumber, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
        this.birthDate = birthDate;
    }

    public void add(Appointment tempAppointment) {
        if (appointments == null) {
            appointments = new ArrayList<>();
        }
        appointments.add(tempAppointment);
        tempAppointment.setPatient(this);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nationalInsuranceNumber='" + nationalInsuranceNumber + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
