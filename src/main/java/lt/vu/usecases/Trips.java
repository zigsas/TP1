package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Trip;
import lt.vu.entities.Vehicle;
import lt.vu.persistence.TripsDAO;
import lt.vu.persistence.VehiclesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Trips {
    @Inject
    private TripsDAO tripsDAO;

    @Inject
    private VehiclesDAO vehiclesDAO;

    @Getter @Setter
    private Trip trip = new Trip();

    @Getter
    private List<Trip> allTrips;

    @Getter
    private List<Vehicle> availableVehicles;

    @PostConstruct
    public void init() {
        loadAllTrips();
    }

    @Transactional
    public String createTrip() {
        tripsDAO.create(trip);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String updateTrip() {
        tripsDAO.update(trip);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String deleteTrip() {
        tripsDAO.delete(trip);
        return "index?faces-redirect=true";
    }

    private void loadAllTrips() {
        allTrips = tripsDAO.getAll();
        availableVehicles = vehiclesDAO.getAll();
    }
}
