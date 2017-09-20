package cars;


public class FordCar extends CoolCar
{
    /**
     * Creates a new instance of a {@link CoolCar}.
     */
	
    public FordCar()
    {
    }
    
    /**
     * Retrieves the brand of the car.
     * 
     * @return The brand of the car.
     */
    @Override
    public String getBrand()
    {
        return "Ford";
    }
    
    /**
     * Retrieves the model of the car.
     * 
     * @return The model of the car.
     */
    @Override
    public String getModel()
    {
        return "Mustang";
    }
    
    /**
     * Retrieves the model year of the car.
     * 
     * @return The model year of the car.
     */
    @Override
    public int getModelYear()
    {
        return 1968;
    }
    
    /**
     * Retrieves the current mileage of the car.
     * 
     * @return The current mileage of the car.
     */
    @Override
    public int getMileage()
    {
        return 72500;
    }
    
    /**
     * Retrieves the current fuel level.  Valid range is 0.00 to 1.00.
     * 
     * @return The current fuel level.
     */
    @Override 
    public double getFuelLevel()
    {
        return 0.50;
    }
    
    /**
     * Determines if the car has mechanical problems or not.
     * 
     * @return <tt>True</tt> if the car has mechanical problems, <tt>false</tt> otherwise.
     */
    public boolean hasProblems()
    {
        return false;
    }
}