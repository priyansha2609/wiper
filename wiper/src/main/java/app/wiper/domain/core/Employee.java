package app.wiper.domain.core;

import java.util.List;

import app.wiper.domain.type.EntityType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee{
	
	Integer employeeId;
	String name;
	Credentials credentials;
	String aadharNumber;
	EntityType entityType;
	CorrespondenceAddress correspondenceAddress;
	List<Location> locations;
	Boolean isActive;
}
