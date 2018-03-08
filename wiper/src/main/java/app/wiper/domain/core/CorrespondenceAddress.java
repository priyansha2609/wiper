package app.wiper.domain.core;

import app.wiper.domain.type.Area;
import app.wiper.domain.type.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorrespondenceAddress {
	String flatNo;
	String building;
	Area area;
	City city;	
	Integer pin;
}
