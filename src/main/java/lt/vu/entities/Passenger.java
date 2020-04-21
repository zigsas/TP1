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
        @NamedQuery(name = "Passenger.getAll", query = "SELECT p FROM Passenger AS p")
})
@Table(name = "PASSENGER")
@Getter @Setter
@EqualsAndHashCode
public class Passenger implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;

    @ManyToMany(mappedBy = "passengers")
    private List<Trip> trips;

    public Passenger() {
    }
}
