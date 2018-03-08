package app.wiper.mapper.interfaces;

import app.wiper.domain.core.Credentials;

public interface CredentialsMapper {
	
	Credentials getCredentialsForEntityIdAndEntityTypeId(Integer entity_type_id, Integer  entity_id);

}
