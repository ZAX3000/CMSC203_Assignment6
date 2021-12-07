/**
 * Class: CMSC203 CRN 22297
 * Program: Assignment #6
 * Instructor: Dr. Grigoriy Grinberg
 * Description: The coffee class extends the Beverage class if it is called; the beverageType is set to coffee.
 * Due: 12/06/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * @author Matthew McNey
 */

public class Coffee extends Beverage
{
	private TYPE beverageType = TYPE.COFFEE;
	private boolean shotOfCoffee;
	private boolean extraSyrup;
	private final double EXTRA_SHOT_PRICE = .50;
	private final double EXTRA_SYRUP_PRICE = .50;

	/**
	 * The parameterized Coffee constructor
	 * @param name
	 * @param productSize
	 * @param coffeeShot
	 * @param syrupAdded
	 */
	
	public Coffee(String name, SIZE productSize, boolean coffeeShot, boolean syrupAdded) 
	{
		super(name, TYPE.COFFEE, productSize);
		this.shotOfCoffee = coffeeShot;
		this.extraSyrup = syrupAdded;
	}
	
	/**
	 * This method will calculate the price.
	 * @return totalPrice accumulated price of the coffee beverage
	 */
	
	public double calcPrice() 
	{
		// total price will always start with the base price
		double totalPrice = super.getBasePrice();
		
		// checks if there is a shot of coffee
		if (this.shotOfCoffee == true)
		{
			totalPrice += .50;
		}
		
		// checks if there is extra syrup added
		if (this.extraSyrup == true)
		{
			totalPrice += .50;
		}
		
		// checks size for medium
		if (super.getSize() == SIZE.MEDIUM)
		{
			totalPrice += super.getUPSELL_PRICE();
		}
		
		// checks size for large
		if (super.getSize() == SIZE.LARGE)
		{
			totalPrice += super.getUPSELL_PRICE() * 2;
		}
				
		return totalPrice;
	}

	/**
	 * Did the customer get an extra shot of coffee?
	 * @return shotOfCoffee true or false, did they?
	 */
	
	public boolean getExtraShot()
	{
		return shotOfCoffee;
	}

	/**
	 * And did they get an extra helping of syrup?
	 * @return extraSyrup yes or no?
	 */
	
	public boolean getExtraSyrup() 
	{
		return extraSyrup;
	}

	/**
	 * @return EXTRA_SHOT_PRICE the price of an extra shot of coffee price
	 */
	
	public double getEXTRA_SHOT_PRICE() 
	{
		return EXTRA_SHOT_PRICE;
	}

	/**
	 * 
	 * @return EXTRA_SYRUP_PRICE the price of adding syrup to the coffee
	 */
	
	public double getEXTRA_SYRUP_PRICE() 
	{
		return EXTRA_SYRUP_PRICE;
	}

	/**
	 * @param otherBev adds another beverage object to compare to the current instance of a beverage object
	 * @return false if the passed beverage object is not an instance of the coffee subclass object
	 * @return true if each of the current instance variables are equal to the instance variables of the passed object
	 * @return false otherwise
	 */
	
	@Override
	public boolean equals(Object otherBev) 
	{
		if (!(otherBev instanceof Coffee))
		{
			return false;
		}
		
		Coffee coffee = (Coffee)otherBev;

		if (beverageType == coffee.beverageType && super.name == coffee.name && this.size == coffee.size && this.shotOfCoffee == coffee.shotOfCoffee && this.extraSyrup == coffee.extraSyrup)
		{
			return true;
		}
		return false;
	}

	/**
	 * toString method for the coffee beverage
	 * @return str will return the beverage name, size and total price of the coffee ordered
	 */
	
	public String toString() 
	{
		String str = "The beverage is " + getBevName() + " and it's size is " + getSize() + " it's price " + calcPrice();
		return str;
	}
	
}
