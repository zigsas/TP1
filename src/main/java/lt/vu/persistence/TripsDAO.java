package lt.vu.persistence;

import lt.vu.entities.Trip;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TripsDAO {
    @Inject
    private EntityManager entityManager;

    public void create(Trip trip) {
        entityManager.persist(trip);
    }

    public List<Trip> getAll() {
        return entityManager.createNamedQuery("Trip.findAll", Trip.class).getResultList();
    }

    public Trip getById(Integer id) {
        return entityManager.find(Trip.class, id);
    }

    public Trip update(Trip trip) {
        return entityManager.merge(trip);
    }

    public void delete(Trip trip) {
        entityManager.remove(trip);
    }
}
