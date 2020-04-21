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
        @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location AS l")
})
@Table(name = "LOCATION")
@Getter @Setter
@EqualsAndHashCode
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "location")
    private List<Trip> trips;

    public Location() {
    }
}
