package lt.vu.persistence;

import lt.vu.entities.Location;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class LocationsDAO {
    @Inject
    private EntityManager entityManager;

    public void create(Location location) {
        entityManager.persist(location);
    }

    public List<Location> getAll() {
        return entityManager.createNamedQuery("Location.findAll", Location.class).getResultList();
    }

    public Location getById(Integer id) {
        return entityManager.find(Location.class, id);
    }

    public Location update(Location location) {
        return entityManager.merge(location);
    }

    public void delete(Location location) {
        entityManager.remove(location);
    }
}
