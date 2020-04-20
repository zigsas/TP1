package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip AS t")
})
@Table(name = "TRIP")
@Getter @Setter
public class Trip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;

    @ManyToMany
    @JoinTable(name = "PASSENGER_TRIP")
    private List<Passenger> passengers;

    public Trip() {
    }
}
