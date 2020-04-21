package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Vehicle;
import lt.vu.persistence.VehiclesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
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

    @PostConstruct
    public void init() {
        loadAllVehicles();
    }

    @Transactional
    public String createVehicle() {
        vehiclesDAO.create(vehicle);
        return "vehicles?faces-redirect=true";
    }

    @Transactional
    public String updateVehicle() {
        vehiclesDAO.update(vehicle);
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
