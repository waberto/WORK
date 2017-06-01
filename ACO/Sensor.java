package Partie2;

import Partie1.Temperature;

/**
 * The sensor is the source of the temperature readings.
 * Unfortunately sensors sometimes fail and provide unrealistic values
 */
public interface Sensor {
	
	Temperature getValue();

}
