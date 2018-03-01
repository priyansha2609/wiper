package app.wiper.domain.core;

import app.wiper.domain.type.EntityType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Administrator implements Entity {
	Integer administratorId;
	Credentials credentials;
	EntityType entityType;
	
	
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
