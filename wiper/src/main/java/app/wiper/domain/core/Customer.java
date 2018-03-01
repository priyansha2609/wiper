package app.wiper.domain.core;

import java.util.List;

import app.wiper.domain.type.EntityType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer implements Entity{
	Integer customerId;
	Credentials credentials;
	EntityType entityType;
	String aadharNumber;
	CorrespondenceAddress correspondenceAddress;
	List<Vehicle> vehicles;
	
	public Integer getEntityId() {
		// TODO Auto-generated method stub
		return null;
	}
	public EntityType getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}
	public Credentials getEntityCredentials() {
		// TODO Auto-generated method stub
		return null;
	}
}
