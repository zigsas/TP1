package lt.vu.persistence;

import lt.vu.entities.Passenger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PassengersDAO {
    @Inject
    private EntityManager entityManager;

    public void create(Passenger passenger) {
        entityManager.persist(passenger);
    }

    public List<Passenger> getAll() {
        return entityManager.createNamedQuery("Passenger.getAll", Passenger.class).getResultList();
    }

    public Passenger getById(Integer id) {
        return entityManager.find(Passenger.class, id);
    }

    public Passenger update(Passenger passenger) {
        return entityManager.merge(passenger);
    }

    public void delete(Passenger passenger) {
        entityManager.remove(passenger);
    }
}
