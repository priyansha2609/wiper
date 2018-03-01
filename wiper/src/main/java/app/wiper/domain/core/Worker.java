package app.wiper.domain.core;

import java.util.List;

import app.wiper.domain.type.EntityType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Worker implements Entity {
	
	Integer workerId;
	Credentials credentials;
	String aadharNumber;
	EntityType entityType;
	CorrespondenceAddress correspondenceAddress;
	List<LocationDetails> locationDetails;
	
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
