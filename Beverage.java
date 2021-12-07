/**
 * Class: CMSC203 CRN 22297
 * Program: Assignment #6
 * Instructor: Dr. Grigoriy Grinberg
 * Description: This is the Beverage Superclass. Here we create the skeleton of a beverage object; 
 * the beverage type determines what the beverage object will become
 * Due: 12/06/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * @author Matthew McNey
 */
public abstract class Beverage {

	/*
	 * declare variables
	 */
	public String name;
	public TYPE beverageType;
	public SIZE size;
	public boolean weekend = false;
	private final double BASE_PRICE = 2.0;
	private final double UPSELL_PRICE = 1.0;

	/**
	 * Here is the Beverage constructor.
	 * @param nameInput
	 * @param drinkType
	 * @param sizeProfile
	 */
	
	public Beverage(String nameInput, TYPE drinkType, SIZE sizeProfile) 
	{
		this.name = nameInput;
		this.beverageType = drinkType;
		this.size = sizeProfile;
	}
	
	/**
	 * This method calculates the beverage price and 
	 * @return the price
	 */

	public abstract double calcPrice();

	/**
	 * This checks the equality based on name, type, size of beverage
	 * @param otherBev passes in an object to be compared to another one
	 * @return false if the passed beverage is not equal to the instance of the beverage
	 * @return true they are equal
	 * @return otherwise return false
	 */
	@Override
	public boolean equals(Object otherBev) 
	{
		if (!(otherBev instanceof Beverage))
		{
			return false;
		}
		
		Beverage beverage = (Beverage)otherBev;

		if (this.beverageType == beverage.beverageType && this.name == beverage.name && this.size == beverage.size)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * sets the name of beverage
	 * @param name
	 */

	public void setBevName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * @return name of beverage
	 */

	public String getBevName() 
	{
		return name;
	}
	
	/**
	 * @param beverage sets the beverage type
	 */

	public void setType(TYPE beverage) 
	{
		this.beverageType = beverage;
	}
	
	/**
	 * @return beverageType gets the beverage type
	 */

	public TYPE getType() 
	{
		return beverageType;
	}
	
	/**
	 * set the size of the beverage
	 * @param sizeInput
	 */

	public void setSize(SIZE sizeInput) 
	{
		this.size = sizeInput;
	}
	
	/**
	 * @return size of the beverage
	 */

	public SIZE getSize() 
	{
		return size;
	}
	
	/**
	 * @return BASE_PRICE of beverage
	 */

	public double getBasePrice() 
	{
		return BASE_PRICE;
	}
	
	/**
	 * @return UPSELL_PRICE for a larger size
	 */

	public double getUPSELL_PRICE() 
	{
		return UPSELL_PRICE;
	}
		
	/**
	 * @return str which is the beverage name and size
	 */
	
	public String toString() 
	{
		String str = "The beverage is " + name + " and it's size is " + size;
		return str;
	}


}
