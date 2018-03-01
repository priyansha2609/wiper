package app.wiper.domain.core;

import app.wiper.domain.type.EntityType;

public interface Entity {
	
	Integer getEntityId();
	EntityType getEntityType();
	Credentials getEntityCredentials();
	
}
