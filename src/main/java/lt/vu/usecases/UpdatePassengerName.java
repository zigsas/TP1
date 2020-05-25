package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Passenger;
import lt.vu.persistence.PassengersDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdatePassengerName implements Serializable {
    private Passenger passenger;

    @Inject
    private PassengersDAO passengersDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer passengerId = Integer.parseInt(requestParameters.get("passengerId"));
        passenger = passengersDAO.getById(passengerId);
    }

    @Transactional
    public String updatePassenger() {
        try {
            System.out.println(passenger.getId() + " " + passenger.getFirstName() + " " + passenger.getLastName());
            passengersDAO.update(passenger);
        } catch (OptimisticLockException e) {
            return "/passengerDetails.xhtml?passengerId=" + passenger.getId() + "&faces-redirect=true&error=optimistic-lock-exception";
        }
        return "passengerDetails.xhtml?passengerId=" + passenger.getId() + "&faces-redirect=true";
    }
}
