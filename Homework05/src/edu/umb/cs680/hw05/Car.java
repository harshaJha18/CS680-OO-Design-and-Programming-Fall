package edu.umb.cs680.hw05;

public class Car {
	private String model, make;
	private int mileage, year;
	private float price;
	public Car(String make ,String model,int year)
	{
		this.model=model;
		this.make=make;
		this.year=year;
		
	}
	public Car(String make ,String model,int mileage,int year,float price )
	{
		this.model=model;
		this.make=make;
		this.mileage=mileage;
		this.year=year;
		this.price=price ;
		
	}
	public String getModel() {
		return model;
	}
	public String getMake() {
		return make;
		
	}
	public int getMileage() {
		return mileage;
		
	}
	
	public int setMileage(int mileage)
	{
		return this.mileage=mileage;
		
	}
	public int getYear() 
	{
		return year;
		
	}
	public int setYear(int year) 
	{
		return this.year=year;
		
	}
	
	public float getPrice() 
	{
		return price ;
	}

	public float setPrice(float price)
	{
		return this.price=price;
		
	}
	
	
}
