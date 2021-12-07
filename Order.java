import java.util.*;

/**
 * Class: CMSC203 CRN 22297
 * Program: Assignment #6
 * Instructor: Dr. Grigoriy Grinberg
 * Description: This program creates an order for a beverage shop
 * Due: 12/06/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * 
 * @author Matthew McNey
 *
 */

public class Order implements OrderInterface, Comparable<Object>
{

	/*
	 * declare variables
	 */
	public int orderNum;
	private int orderTime;
	private DAY day;
	private Customer newCustomer;
	private ArrayList<Beverage> list = new ArrayList<Beverage>();

	/**
	 * This method creates a random number to be our order number.
	 * @return randNum a random number between 10000 and 90000
	 */
	public int randomNum() 
	{
		Random random = new Random();
		int randNum = random.nextInt(90000) + 10000;
		return randNum;
	}

	/**
	 * This constructor will instantiate Order with the time, day, customer info and generate a random number.
	 * @param orderTime when order was placed
	 * @param daySelected when order was placed
	 * @param customer object storing name and age
	 */
	
	public Order(int orderTime, DAY daySelected, Customer customer)
	{
		this.orderTime = orderTime;
		this.day = daySelected;
		this.newCustomer = customer;
		this.orderNum = randomNum();
	}
	
	/**
	 * This will add a coffee beverage to the order.
	 * This will override the other addNewBeverage methods depending on passed parameters.
	 * @param bevName given beverage name
	 * @param size of the beverage
	 * @param extraShot whether the customer got an extra shot of coffee
	 * @param extraSyrup whether the customer got extra syrup in the coffee
	 */
	
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) 
	{
		list.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	/**
	 * This will add an alcohol beverage to the order
	 * This will override the other addNewBeverage methods depending on passed parameters.
	 * @param bevName given beverage name
	 * @param size of the beverage
	 */
	
	@Override
	public void addNewBeverage(String bevName, SIZE size) 
	{
		list.add(new Alcohol(bevName, size, isWeekend()));
	}

	/**
	 * This will add a smoothie beverage to the order.
	 * This will override the other addNewBeverage methods depending on passed parameters.
	 * @param bevName given beverage name
	 * @param size of the beverage
	 * @param numOfFruits purchased by the customer
	 * @param addProtein whether protein is being added
	 */
	
	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) 
	{
		list.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	/**
	 * @return orderNum gets the order number
	 */
	
	public int getOrderNo() 
	{
		return orderNum;
	}

	/**
	 * @return orderTime gets the order time
	 */
	
	public int getOrderTime() 
	{
		return orderTime;
	}

	/**
	 * @return day gets the day order was purchased
	 */
	
	public DAY getOrderDay() 
	{
		return day;
	}

	/**
	 * This will get a deep copy of the customer
	 * @return deepCustomer a deep copy of the customer that cannot be changed while the order is being made
	 */
	
	public Customer getCustomer() 
	{
		Customer deepCustomer = new Customer(newCustomer);
		
		return deepCustomer;
	}

	/**
	 * This method overrides all other isWeekend methods
	 * @return isWeekend whether it is the weekend; special pricing is used if it is the weekend for alcoholic beverages
	 */
	
	@Override
	public boolean isWeekend() 
	{
		boolean isWeekend = false;
		
		// if it is Saturday or Sunday the isWeekend variable is set to true
		if (this.day == DAY.SATURDAY || this.day == DAY.SUNDAY)
		{
			isWeekend = true;
		}

		return isWeekend;
	}

	/**
	 * @param itemNo is an index used to identify a particular beverage in the beverage list
	 * @return null if there is no beverage object at the index location otherwise it will return the beverage selected
	 */
	
	@Override
	public Beverage getBeverage(int itemNo) 
	{
		int index = itemNo;
		Beverage beverage = list.get(index);
		if (beverage == null)
		{
			return null;
		}
		else
		{
			return beverage;
		}
	}

	/**
	 * This method will calculate the order total
	 * @return orderTotal the order total
	 */
	
	@Override
	public double calcOrderTotal() 
	{
		double orderTotal = 0; // accumulator
		
		// runs through the ArrayList of beverages in the order
		for (int index = 0; index < list.size(); index++)
		{
			Beverage beverage = list.get(index);
			// add them to the accumulator
			orderTotal += beverage.calcPrice();
		}
		return orderTotal;
	}
	
	/**
	 * This method will find the number of a passed in beverage type
	 * @param type the beverage type
	 * @return numOfBeveType the count of passed beverage type
	 */
	
	@Override
	public int findNumOfBeveType(TYPE type) 
	{
		int numOfBeveType = 0; // counter
		
		// runs through the ArrayList of beverages
		for (int index = 0; index < list.size(); index++)
		{
			Beverage beverage = list.get(index);
			// find what is the type and add those to the accumulator
			if (beverage.getType() == type)
			{
				numOfBeveType++; // add one
			}
		}
		return numOfBeveType;
	}
	
	/**
	 * get the total number of items in the order
	 * @return totalItem the total number of items in the order
	 */
	
	public int getTotalItems()
	{
		int totalItems = 0; // sum-er
		totalItems = list.size(); // because the arraylist expands or shrinks based on what is actually in it we'll just use the current size
		return totalItems; // summed
	}
	
	/**
	 * The toString method for the Order will return 
	 * @return str the order number, order time, order day, customer info, calculated order total, all beverages
	 */
	
	public String toString() 
	{
		String str = getOrderNo() + "/n" + getOrderTime() + "/n" + getOrderDay() + "/n" + getCustomer() + "/n" + calcOrderTotal() + "/n";
		
		// for loop for running through the beverages in a list of beverages
		for (int index = 0; index < list.size(); index++)
		{
			Beverage beverage = list.get(index);
			str += beverage.toString() + "/n";	
		}
		return str;
	}

	/**
	 * This method will compare two orders based on their order numbers; the highest order number is sorted to the top of the array
	 * @return 0 if this order number is same as another order's order number, 
	 * @return 1 if it is greater than another order's order number, 
	 * @return -1 if it smaller than another order's order number.
	 */
	
	@Override
	public int compareTo(Object anotherOrder) 
	{
		if (this.orderNum == ((Order)anotherOrder).orderNum)
		{
			  return 0;
		}
		return ( (this.orderNum > ((Order)anotherOrder).orderNum )? 1 : -1 );	
	}
	
}
