package uk.wanat.theclinick.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "full_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime appointmetDate;

    @Enumerated(value = EnumType.STRING)
    private ExaminationRoom examinationRoom;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id")
    private AppointmentDetails appointmentDetails;

    @Builder
    public Appointment(LocalDateTime appointmetDate, ExaminationRoom examinationRoom) {
        this.appointmetDate = appointmetDate;
        this.examinationRoom = examinationRoom;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", fulldate=" + appointmetDate +
                ", examinationRoom=" + examinationRoom +
                '}';
    }
}
