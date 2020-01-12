package uk.wanat.theclinick.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor


@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 30)
    private String email;
    @Column(name = "password", length = 30)
    private String password;
    @OneToOne(mappedBy = "login", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Patient patient;


    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
