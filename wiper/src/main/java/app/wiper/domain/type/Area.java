package app.wiper.domain.type;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Area implements Serializable{
		Integer areaId;
		String name;
		String description;
		Integer isActive;
		Integer orderId;
	}

