package app.wiper.domain.type;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City implements Serializable {

		Integer cityId;
		String name;
		String description;
		Integer isActive;
		Integer orderId;
	}

