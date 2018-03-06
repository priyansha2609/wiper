package app.wiper.mapper.interfaces;

import app.wiper.domain.core.VehicleAddress;

public interface VehicleAddressMapper {

	VehicleAddress getAddressForVehicle(Integer vehicleId);

}
