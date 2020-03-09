package uk.wanat.theclinick.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor


@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street", length = 100)
    private String street;
    @Column(name = "postcode", length = 20)
    private String postcode;
    @Column(name = "city", length = 50)
    private String city;
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Patient patient;

    @Builder
    public Address(Long id, String street, String postcode, String city) {
        this.id = id;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", patient=" + patient +
                '}';
    }
}
