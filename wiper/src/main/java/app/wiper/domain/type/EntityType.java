package app.wiper.domain.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityType {
	Integer entityTypeId;
	String name;
	String description;
	Integer isActive;
	Integer orderId;
}
