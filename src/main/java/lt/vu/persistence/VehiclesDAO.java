package lt.vu.persistence;

import lt.vu.entities.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class VehiclesDAO {
    @Inject
    private EntityManager entityManager;

    public void create(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    public List<Vehicle> getAll() {
        return entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class).getResultList();
    }

    public Vehicle getById(Integer id) {
        return entityManager.find(Vehicle.class, id);
    }

    public Vehicle update(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    public void delete(Vehicle vehicle) {
        entityManager.remove(vehicle);
    }
}
