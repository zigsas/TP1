package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Passenger;
import lt.vu.entities.Trip;
import lt.vu.persistence.PassengersDAO;
import lt.vu.persistence.TripsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class TripsForPassenger implements Serializable {
    @Inject
    private PassengersDAO passengersDAO;

    @Inject
    private TripsDAO tripsDAO;

    @Getter @Setter
    private Passenger passenger;

    @Getter
    private List<Trip> availableTrips;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer passengerId = Integer.parseInt(requestParameters.get("passengerId"));
        passenger = passengersDAO.getById(passengerId);
        availableTrips = tripsDAO.getAvailableForPassenger(passengerId);
    }

    @Transactional
    public String joinTrip(Trip trip) {
        trip.getPassengers().add(passenger);
        return "passengerDetails?faces-redirect=true&passengerId=" + passenger.getId();
    }

    @Transactional
    public String leaveTrip(Trip trip) {
        trip.getPassengers().remove(passenger);
        return "passengerDetails?faces-redirect=true&passengerId=" + passenger.getId();
    }
}
