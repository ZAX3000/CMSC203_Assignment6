/**
 * Class: CMSC203 CRN 22297
 * Program: Assignment #6
 * Instructor: Dr. Grigoriy Grinberg
 * Description: The Smoothie class extends the Beverage superclass; creates a smoothie beverage object
 * Due: 12/06/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * @author Matthew McNey
 *
 */

public class Smoothie extends Beverage 
{

	private int numOfFruits;
	private TYPE beverageType = TYPE.SMOOTHIE;
	private boolean proteinPowderUpsell;
	private final double PROTEIN_PRICE = 1.50;
	private final double FRUIT_PRICE = .50;

	/**
	 * The constructor for the smoothie class used to create the foundation for this beverage type
	 * @param name of the beverage
	 * @param productSize of the beverage
	 * @param fruits used to make the smoothie
	 * @param powder whether the customer wanted protein powder added
	 */
	
	public Smoothie(String name, SIZE productSize, int fruits, boolean powder) 
	{
		super(name, TYPE.SMOOTHIE, productSize);
		this.numOfFruits = fruits;
		this.proteinPowderUpsell = powder;
	}

	/**
	 * @return numOfFruits the total number of fruits the customer wanted
	 */
	
	public int getNumOfFruits() 
	{
		return numOfFruits;
	}

	/**
	 * @return proteinPowderUpsell whether the customer wanted protein powder added
	 */
	
	public boolean getAddProtien() 
	{
		return proteinPowderUpsell;
	}
	
	/**
	 * This method will calculate the price of the smoothie beverage
	 * @return totalPrice accumulates the total price of the smoothie
	 */
	
	public double calcPrice() 
	{
		double totalPrice = 0;
		
		// total price will always start with the base price
		totalPrice = super.getBasePrice();
		
		// total price will add the protein powder upsell
		if (this.proteinPowderUpsell == true)
		{
			totalPrice += PROTEIN_PRICE;
		}
		
		// checks if there is any fruit being added then multiplied by the fruit price
		if (this.getNumOfFruits() > 0)
		{
			totalPrice += (this.getNumOfFruits() * FRUIT_PRICE);
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
	 * @param otherBev adds another beverage object to compare to the current instance of a beverage object
	 * @return false if the passed beverage object is not an instance of the Smoothie subclass object
	 * @return true if each of the current instance variables are equal to the instance variables of the passed object
	 * @return false otherwise
	 */
	
	@Override
	public boolean equals(Object otherBev) 
	{
		if (!(otherBev instanceof Smoothie))
		{
			return false;
		}
		
		Smoothie smoothie = (Smoothie)otherBev;

		if (beverageType == smoothie.beverageType && super.name == smoothie.name && this.size == smoothie.size && this.getNumOfFruits() == smoothie.getNumOfFruits() && this.getAddProtien() == smoothie.getAddProtien())
		{
			return true;
		}
		return false;
	}
	
	/**
	 * toString method for the Smoothie beverage
	 * @return str will return the beverage name, size and total price of the smoothie ordered
	 */
	
	public String toString() 
	{
		String str = "The beverage is " + super.getBevName() + " and it's size is " + super.getSize() + " it's price " + this.calcPrice();
		return str;
	}

}
