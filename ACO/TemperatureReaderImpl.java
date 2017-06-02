package Partie2;

import Partie1.Temperature;

public class TemperatureReaderImpl implements TemperatureReader{

	Sensor sensor;
	//Temperature[] t;
	Temperature t;
	
	public TemperatureReaderImpl(Sensor s, Temperature t) {
		this.sensor = s;
		this.t = t;
		//this.t = new Temperature[100];
	}
	@Override
	public void setSensor(Sensor sensor) {
				
		if (this.sensor == null){
			throw new IllegalArgumentException("Sensor is null");
		}
		this.sensor = sensor;
	}

	@Override
	public void takeMeasure() {
		//t[1] = sensor.getValue();
		t = sensor.getValue();
	}

	@Override
	public Temperature getLastMeasure() {
		
		return t;
		//return t[t.length - 1];
	}

	@Override
	public void setLowerLimit(Temperature threshold, Command alarmCommand) {
		//if(Temperature.createFromCelsius(Math.abs(t[t.length - 1 ] - t[t.length - 2]) > threshold)){
			if(alarmCommand.equals(getLastMeasure())){
				alarmCommand.execute(this);
			}
		//} 
	}

	@Override
	public void setDiffeerenceLimit(Temperature differenceThreshold, Command alarmCommand) {
		//if(Temperature.createFromCelsius(Math.abs(t[t.length - 1 ] - t[t.length - 2]) > threshold)){
		if(alarmCommand.equals(getLastMeasure())){
			alarmCommand.execute(this);
		}
	//} 
	}

}
