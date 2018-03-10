package app.wiper.domain.core;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeLocation implements Serializable{
	Integer employeeLocationId;
	Location location;
	Boolean isActive;

}
