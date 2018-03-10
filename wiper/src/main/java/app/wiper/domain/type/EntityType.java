package app.wiper.domain.type;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityType implements Serializable{
	Integer entityTypeId;
	String name;
	String description;
	Integer isActive;
	Integer orderId;
}
