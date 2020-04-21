package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle AS v")
})
@Table(name = "VEHICLE")
@Getter @Setter
@EqualsAndHashCode
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 6, max = 6)
    @Pattern(regexp = "^[A-Z]{3}[0-9]{3}$")
    @Column(name = "LICENCE_PLATE", nullable = false, unique = true)
    private String licencePlate;

    @OneToMany(mappedBy = "vehicle")
    private List<Trip> trips;

    public Vehicle() {
    }
}
