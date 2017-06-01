package Partie2;

import Partie1.Temperature;

/**
 * A temperature reading service that signals when
 * it reads too low or too quickly changing values.
 * <p>
 * A TemperatureReader reads a sensor when its takeMeasure() operation is called
 * by some other code (e.g the system).
 *The last value measured can be read with the getLastMeasure() operation.
 */
public interface TemperatureReader {

	/**
	 * Sets the sensor that will be read
	 * 
	 * @param sensor is the sensor to reads from, null value is forbidden 
	 * @throws IllegalArgumentException if the sensor parameter is null
	 */
	void setSensor(Sensor sensor);
	
	/**
	 * Reads a temperature from the sensor set by calling setSensor.
	 * To get the value one must call getLastMeasure()
	 */
	void takeMeasure();
	
	
	Temperature getLastMeasure();
	
	void setLowerLimit(Temperature threshold, Command alarmCommand);
	
	void setDiffeerenceLimit(Temperature differenceThreshold, Command alarmCommand);	
	
}
