package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip AS t")
})
@Table(name = "TRIP")
@Getter @Setter
@EqualsAndHashCode
public class Trip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "ORIGIN")
    private String origin;

    @Size(max = 50)
    @Column(name = "DESTINATION")
    private String destination;

    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;

    @ManyToMany
    @JoinTable(name = "PASSENGER_TRIP")
    private List<Passenger> passengers;

    public Trip() {
    }
}
