package uk.wanat.theclinick.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Speciality speciality;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;

    @OneToMany(mappedBy="doctor",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Appointment> appointments;

    public Doctor(Speciality speciality, String firstName, String lastName) {
        this.speciality = speciality;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void add(Appointment tempAppointment) {

        if (appointments == null) {
        public Doctor(Speciality speciality, String firstName, String lastName) {
        this.speciality = speciality;
        this.firstName = firstName;
        this.lastName = lastName;
        appointments = new ArrayList<>();
    }
        }
        appointments.add(tempAppointment);
        tempAppointment.setDoctor(this);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", speciality=" + speciality +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
