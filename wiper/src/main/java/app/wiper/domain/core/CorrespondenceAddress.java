package app.wiper.domain.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorrespondenceAddress {
	String flatNo;
	String building;
	String city;
	String state;
	Integer pin;
}
