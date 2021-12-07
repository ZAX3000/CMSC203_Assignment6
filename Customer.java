/**
 * Class: CMSC203 CRN 22297
 * Program: Assignment #6
 * Instructor: Dr. Grigoriy Grinberg
 * Description: The customer class creates a customer using a passed in customer name and age
 * Due: 12/06/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * @author Matthew McNey
 */

public class Customer {

	private int age;
	private String name;

	/**
	 * The Customer constructor creates a customer object using a passed in name and age
	 * @param cus_name
	 * @param ageCus
	 */
	
	public Customer(String cus_name, int ageCus) 
	{
		this.name = cus_name;
		this.age = ageCus;
	}

	/**
	 * the copy constructor creates a deep copy of the customer class
	 * @param customer object used to create a deep copy
	 */
	
	public Customer(Customer customer)
	{
		this.name = customer.name;
		this.age = customer.age;
		Customer deepCustomer = new Customer (customer.getName(), customer.getAge());
	}
	
	/**
	 * @param nam adds the name of the customer to name
	 */
	
	public void setName(String nam)
	{
		this.name = nam;
	}
	
	/**
	 * @return name of the customer
	 */
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param ageSet sets the age of the customer
	 */
	
	public void setAge(int ageSet)
	{
		age = ageSet;
	}
	
	/**
	 * @return age of the customer
	 */
	
	public int getAge()
	{
		return age;
	}
	
	/**
	 * @return str will return the customer name and age
	 */
	
	public String toString() 
	{
		String str = "";
		str += "Customer name: " + getName();
		str += "Customer age: " + getAge();
		return str;
	}

}
