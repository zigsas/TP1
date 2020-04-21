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

    @PostConstruct
    public void init() {
        loadAllVehicles();
    }

    @Transactional
    public String createVehicle() {
        vehicleMapper.insert(vehicle);
        return "/myBatis/vehicles?faces-redirect=true";
    }

    @Transactional
    public String updateVehicle() {
        vehicleMapper.updateByPrimaryKey(vehicle);
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
