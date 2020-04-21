package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Passenger;
import lt.vu.persistence.PassengersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Passengers {
    @Inject
    private PassengersDAO passengersDAO;

    @Getter @Setter
    private Passenger passenger = new Passenger();

    @Getter
    private List<Passenger> allPassengers;

    @PostConstruct
    public void init() {
        loadAllPassengers();
    }

    @Transactional
    public String createPassenger() {
        passengersDAO.create(passenger);
        return "passengers?faces-redirect=true";
    }

    @Transactional
    public String updatePassenger() {
        passengersDAO.update(passenger);
        return "passengers?faces-redirect=true";
    }

    @Transactional
    public String deletePassenger() {
        passengersDAO.delete(passenger);
        return "passengers?faces-redirect=true";
    }

    private void loadAllPassengers() {
        allPassengers = passengersDAO.getAll();
    }
}
