package Partie1;

final public class Temperature {
	


	private static double ZeroCelsiusInKelvins = 273.15;
	private static double MinimalCelsiusTemperature = -ZeroCelsiusInKelvins;
	private static double MinimalFahrenheitTemperature = ((MinimalCelsiusTemperature*9)/5)+32;
	private static double valueInkelvins;
	
	private Temperature(double valueInKelvins){
		this.valueInkelvins = valueInKelvins;
	}
	
	/**
	 * Creates a new temperature object from a numerical value that use the
	 * Celsius temperature unit
	 * 
	 * @param value numerical value in Celsius
	 * @return new temperature
	 * @throws IllegalArgumentException if value is < -273.15°C
	 */
	public static Temperature createFromCelsius(double value){
		
		if(value < -273.15){
			throw new IllegalArgumentException();
		}
		//********TODO: write the precondition checks in Java
		return new Temperature(value + ZeroCelsiusInKelvins);
	}
	
	//********TODO: write the Javadoc with the precondition(s)
	
	/**
	 * Creates a new temperature object from a numerical value that use the
	 * Celsius temperature unit
	 * 
	 * @param value numerical value in Celsius
	 * @return new temperature
	 * @throws IllegalArgumentException if value is < MinimalCelsiusTemperature
	 */
	public static Temperature createFromFahrenheit(double value){
		
		if(value < MinimalCelsiusTemperature){
			throw new IllegalArgumentException("value must be >=" + MinimalCelsiusTemperature);
		}
		
		return Temperature((((value / 5)*9)-32)+ZeroCelsiusInKelvins);
	}
	
	

	private static Temperature Temperature(double d) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double getValueInCelsius(){
		return valueInkelvins - ZeroCelsiusInKelvins;
	}
	
	public Temperature add(Temperature temperatureToAdd){
		
		return new Temperature(this.valueInkelvins + temperatureToAdd.valueInkelvins - ZeroCelsiusInKelvins);
	}
	
	public void setValueInCelsius(double valueInKelvins){
		this.valueInkelvins = valueInKelvins;
	}
	public static double getZeroCelsiusInKelvins() {
		return ZeroCelsiusInKelvins;
	}

	public static void setZeroCelsiusInKelvins(double zeroCelsiusInKelvins) {
		ZeroCelsiusInKelvins = zeroCelsiusInKelvins;
	}

	public static double getMinimalCelsiusTemperature() {
		return MinimalCelsiusTemperature;
	}

	public static void setMinimalCelsiusTemperature(double minimalCelsiusTemperature) {
		MinimalCelsiusTemperature = minimalCelsiusTemperature;
	}

	public static double getMinimalFahrenheitTemperature() {
		return MinimalFahrenheitTemperature;
	}

	public static void setMinimalFahrenheitTemperature(double minimalFahrenheitTemperature) {
		MinimalFahrenheitTemperature = minimalFahrenheitTemperature;
	}

	public double getValueInkelvins() {
		return valueInkelvins;
	}

	public void setValueInkelvins(double valueInkelvins) {
		this.valueInkelvins = valueInkelvins;
	}
}
