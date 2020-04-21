package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.VehicleMapper;
import lt.vu.mybatis.model.Vehicle;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class VehiclesMyBatis {
    @Inject
    private VehicleMapper vehicleMapper;

    @Getter
    private List<Vehicle> allVehicles;

    @Getter @Setter
    private Vehicle vehicle = new Vehicle();

    @Getter
    private String errorMessage;

    @PostConstruct
    public void init() {
        loadAllVehicles();
    }

    @Transactional
    public String createVehicle() {
        try {
            vehicleMapper.insert(vehicle);
        }
        catch (Exception exception) {
            errorMessage = "Vehicle with provided licence plate already exists!";
            return null;
        }
        return "/myBatis/vehicles?faces-redirect=true";
    }

    @Transactional
    public String updateVehicle() {
        try {
            vehicleMapper.updateByPrimaryKey(vehicle);
        }
        catch (Exception exception) {
            errorMessage = "Vehicle with provided licence plate already exists!";
            return null;
        }
        return "/myBatis/vehicles?faces-redirect=true";
    }

    @Transactional
    public String deleteVehicle() {
        vehicleMapper.deleteByPrimaryKey(vehicle.getId());
        return "/myBatis/vehicles?faces-redirect=true";
    }

    private void loadAllVehicles() {
        allVehicles = vehicleMapper.selectAll();
    }
}
