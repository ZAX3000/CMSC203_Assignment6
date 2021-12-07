/**
 * Class: CMSC203 CRN 22297
 * Program: Assignment #6
 * Instructor: Dr. Grigoriy Grinberg
 * Description: The Alcohol subclass extends the Beverage superclass
 * Due: 12/06/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * @author Matthew McNey
 *
 */

public class Alcohol extends Beverage
{
	/**
	 * declare instance variables
	 */
	private final TYPE beverageType = TYPE.ALCOHOL;
	public boolean isWeekend;
	public final double ALCOHOL_PRICE = .60;

	
	/**
	 * The Alcohol constructor creates an alcoholic beverage object using the values passed in
	 * @param name passed in for the alcoholic beverage
	 * @param productSize passed in to create the beverage
	 * @param isWeekend passed in signaling if it is the weekend or not
	 */
	public Alcohol(String name, SIZE productSize, boolean isWeekend) 
	{
		super(name, TYPE.ALCOHOL, productSize);
		this.isWeekend = isWeekend;
	}

	/**
	 * checks equality based on the Beverage class equals method and additional instance variables for this class
	 * @param otherBev is another object passed that will be compared with the current instance
	 * @return false if comparing the wrong objects
	 * @return true if comparing the same Alcohol objects
	 * @return false otherwise if neither are true
	 */
	@Override
	public boolean equals(Object otherBev) 
	{
		// checks if the object passed is the same as the instance of the object
		if (!(otherBev instanceof Alcohol))
		{
			return false;
		}

		// creates a new alcohol object
		Alcohol alcohol = (Alcohol)otherBev;

		// the equality of all the attributes is checked
		if (this.beverageType == alcohol.beverageType && this.name == alcohol.name && this.size == alcohol.size && this.isWeekend == alcohol.isWeekend && this.ALCOHOL_PRICE == alcohol.ALCOHOL_PRICE)
		{
			return true;
		}
		return false;
	}

	/**
	 * calculate the price of the drink
	 * @return totalPrice sums the total price of the alcoholic beverage
	 */
	public double calcPrice() 
	{
		
		double totalPrice = 0;
		totalPrice = super.getBasePrice();
		
		// checks if it is the weekend then adds the alcohol price if it is
		if (isWeekend == true)
		{
			totalPrice += ALCOHOL_PRICE;
		}
		
		// checks to see if the size is larger than small
		if (super.getSize() == SIZE.MEDIUM)
		{
			totalPrice += super.getUPSELL_PRICE();
		}
		
		// checks for a large size
		if (super.getSize() == SIZE.LARGE)
		{
			totalPrice += super.getUPSELL_PRICE() * 2;
		}
				
		return totalPrice;
	}
	
	/**
	 * The Alcohol toString method will return the beverage stuff and the alcohol stuff
	 * @return str that is a sentence telling the user the beverage name, size and calculated price of the alcoholic beverage
	 */
	@Override
	public String toString() 
	{
		String str = "The beverage is " + super.getBevName() + " and it's size is " + super.getSize() + " it's price " + this.calcPrice();

		return str;
	}

}
