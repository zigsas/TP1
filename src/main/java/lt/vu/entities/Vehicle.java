package lt.vu.entities;

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
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 6)
    @Pattern(regexp = "^[A-Z]{3}[0-9]{3}$")
    @Column(name = "LICENCE_PLATE")
    private String licencePlate;

    @OneToMany(mappedBy = "vehicle")
    private List<Trip> trips;

    public Vehicle() {
    }
}
