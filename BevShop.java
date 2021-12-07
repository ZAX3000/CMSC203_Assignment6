/**
 * Class: CMSC203 CRN 22297
 * Program: Assignment #6
 * Instructor: Dr. Grigoriy Grinberg
 * Description: This is the BevShop data class. Here we create and store the orders for the customers
 * Due: 12/06/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * @author Matthew McNey
 */

import java.util.*;

public class BevShop implements BevShopInterface {

	/**
	 * declare the variables
	 */
	
	private int count_alcohol_drinks = 0;
	private Order currentOrder;
	private ArrayList<Order> list = new ArrayList<Order>();

	/**
	 * @param time that is passed from the order created
	 * @return true if value is within MIN_TIME and MAX_TIME range
	 * @return false otherwise
	 */
	
	@Override
	public boolean validTime(int time) 
	{
		if (time >= MIN_TIME && time <= MAX_TIME)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * @return true if the count_alcohol_drinks is less than the MAX_ORDER_FOR_ALCOHOL
	 * @return false otherwise
	 */
	
	@Override
	public boolean eligibleForMore() 
	{
		// tests count of drinks
		if (count_alcohol_drinks < MAX_ORDER_FOR_ALCOHOL)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * @param age of customer
	 * @return false if the user age is below min age for alcohol; 
	 * @return true otherwise
	 */

	@Override
	public boolean validAge(int age) 
	{
		// tests age of customer
		if (age <= MIN_AGE_FOR_ALCOHOL)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * The startNewOrder method creates the skeleton of an order without any beverages adding it to the list of orders
	 * @param time passed in from driver
	 * @param day passed in from driver
	 * @param customerName passed in from driver
	 * @param customerAge passed in from driver
	 */
	
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) 
	{
		currentOrder = new Order (time, day, new Customer (customerName, customerAge));
		list.add(currentOrder);
	}

	/**
	 * @return currentOrder you've started
	 */
	
	public Order getCurrentOrder()
	{
		return currentOrder;
	}
	
	/**
	 * This method will if someone buys coffee then call to the coffee class and add this beverage to the order
	 * @param bevName the given name of beverage
	 * @param size of the beverage
	 * @param extraShot of coffee
	 * @param extraSyrup used in the coffee
	 */
	
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) 
	{
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	/**
	 * This method will create an alcoholic beverage in the currently selected order object
	 *  @param bevName passed in given name
	 *  @param size passed in drink size
	 */
	
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) 
	{
		if(validAge(getCurrentOrder().getCustomer().getAge()) == true)
		{
			getCurrentOrder().addNewBeverage(bevName, size);
		}
	}
	
	/**
	 * This method creates a smoothie beverage
	 * @param bevName passed given name of beverage
	 * @param size passed to add to a beverage
	 * @param numOfFruits the total passed number of fruits
	 * @param addProtein passed whether the customer wanted protein in their shake
	 */

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) 
	{
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);	
	}

	/**
	 * Tries to find an order
	 * @param orderNo based on the passed order number will find the
	 * @return index of the order with a matching order number or 
	 * @return -1 if nothing is found
	 */
	
	@Override
	public int findOrder(int orderNo) 
	{
		// for loop for running through orders
		for (int index = 0; index < list.size(); index++)
		{
			Order order = list.get(index);
			// find correct order based on order number and add those to the accumulator
			if (order.getOrderNo() == orderNo)
			{
				return index;
			}
		}
		return -1;
	}

	/**
	 * This will total up the order price based on a passed
	 * @param orderNo 
	 * @return totalPrice of the order with the passed order number
	 */
	
	@Override
	public double totalOrderPrice(int orderNo) 
	{
		double totalPrice = 0;
		
		// for loop for running through the order list
		for (int index = 0; index < list.size(); index++)
		{
			Order currentOrder = list.get(index);
			// how many alcoholic beverages and add those to the accumulator
			if (currentOrder.getOrderNo() == orderNo)
			{
				totalPrice += currentOrder.calcOrderTotal();
			}
		}
		
		return totalPrice;
	}

	/**
	 * this totals up the orders total price per month
	 * @return totalPrice of the monthly sales
	 */
	
	@Override
	public double totalMonthlySale() 
	{
		double totalPrice = 0;
		
		// for loop for searching the order list
		for (int index = 0; index < list.size(); index++)
		{
			// accumulate total price
			Order currentOrder = list.get(index);
			totalPrice += currentOrder.calcOrderTotal();
		}
		return totalPrice;
	}

	/**
	 * This will use the compareTo method with the comparable interface the BevShop class implements to sort the orders list in ascending order.
	 * Uses a selection sort algorithm.
	 */
	
	@Override
	public void sortOrders() 
	{
		list.sort(null);
	}
	
	/**
	 * Adds the length of the Order list to totalCount
	 * @return totalCount which is a total of all the orders for the month
	 */
	
	public int totalNumOfMonthlyOrders()
	{
		int totalCount = list.size();
		
		return totalCount;
	}
	
	/**
	 * @param index specifies the location of an order in an array of orders
	 * @return orderAtIndex will return the instance of an order at the index location
	 */
	
	@Override
	public Order getOrderAtIndex(int index) 
	{
		Order orderAtIndex = list.get(index);
		return orderAtIndex;
	}
	
	/**
	 * calculates the number of alcoholic beverages in the currently selected order
	 * @return alcoholicDrinks
	 */
	
	public int getNumOfAlcoholDrink()
	{
		int alcoholicDrinks = 0; // accumulator
		
		// runs through the ArrayList
		for (int index = 0; index < list.size(); index++)
		{
			Order currentOrder = list.get(index);
			// how many alcoholic beverages and add those to the accumulator
			alcoholicDrinks = currentOrder.findNumOfBeveType(TYPE.ALCOHOL);
		}
		count_alcohol_drinks = alcoholicDrinks;
		
		return alcoholicDrinks;
	}
	
	/**
	 * gets the max a customer can purchase alcohol for one order
	 * @return MAX_ORDER_FOR_ALCOHOL the max alcohol a customer can buy which is 3
	 */
	
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * Grabs the minimum age for alcohol
	 * @return MIN_AGE_FOR_ALCOHOL the minimum age for a customer to buy alcohol which is 21
	 */
	
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	/**
	 * The max num of fruit a customer can buy
	 * @param numOfFruits the customer is buying
	 * @return true if customer has ordered the max
	 * @return false if customer has ordered less than max
	 */
	
	public boolean isMaxFruit(int numOfFruits)
	{
		if (numOfFruits > MAX_FRUIT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @return str will show the totalMonthlySale and a list of all the orders
	 */
	
	public String toString() 
	{
		String str = "" + totalMonthlySale();
		// this for loop will run through the order list and display every order toString
		for (int index = 0; index < list.size(); index++)
		{
			Order order = list.get(index);
			str += order.toString();
			
		}
		return str;
	}

}
