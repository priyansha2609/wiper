package app.wiper.domain.core;

import java.util.List;

import app.wiper.domain.type.EntityType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer{
	Integer customerId;
	String name;
	Credentials credentials;
	EntityType entityType;
	String aadharNumber;
	CorrespondenceAddress correspondenceAddress;
	List<Vehicle> vehicles;
	Boolean isActive;
	
	
}
