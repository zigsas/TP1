package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Vehicle;
import lt.vu.persistence.VehiclesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Vehicles {
    @Inject
    private VehiclesDAO vehiclesDAO;

    @Getter @Setter
    private Vehicle vehicle = new Vehicle();

    @Getter
    private List<Vehicle> allVehicles;

    @Getter
    private String errorMessage;

    @PostConstruct
    public void init() {
        errorMessage = "";
        loadAllVehicles();
    }

    @Transactional
    public String createVehicle() {
        try {
            vehiclesDAO.create(vehicle);
        }
        catch (Exception exception) {
            errorMessage = "Vehicle with provided licence plate already exists!";
            return null;
        }
        return "vehicles?faces-redirect=true";
    }

    @Transactional
    public String updateVehicle() {
        try {
            vehiclesDAO.update(vehicle);
        }
        catch (Exception exception) {
            errorMessage = "Vehicle with provided licence plate already exists!";
            return null;
        }
        return "vehicles?faces-redirect=true";
    }

    @Transactional
    public String deleteVehicle() {
        vehiclesDAO.delete(vehicle);
        return "vehicles?faces-redirect=true";
    }

    private void loadAllVehicles() {
        allVehicles = vehiclesDAO.getAll();
    }
}
