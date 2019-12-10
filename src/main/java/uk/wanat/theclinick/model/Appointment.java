package uk.wanat.theclinick.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

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

    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @Column(name = "time_start", length = 50)
    private LocalDateTime timeStart;
    @Column(name = "time_end", length = 50)
    private LocalDateTime timeEnd;
    @Enumerated(value = EnumType.STRING)
    private ExaminationRoom examinationRoom;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    private AppointmentDetails appointmentDetails;

    public Appointment(LocalDateTime timeStart, LocalDateTime timeEnd, ExaminationRoom examinationRoom) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.examinationRoom = examinationRoom;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", examinationRoom=" + examinationRoom +
                '}';
    }
}
