package app.wiper.mapper.interfaces;

import java.util.List;

import app.wiper.domain.type.EntityType;

public interface EntityTypeMapper {

	List<EntityType> getAllEntityTypes();
	
	EntityType getEntityTypeById(Integer id);
}
