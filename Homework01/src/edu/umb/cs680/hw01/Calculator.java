package edu.umb.cs680.hw01;

public class Calculator {

	public float multiply(float x, float y){
		return x*y;
	}
	
	public float subtract(float x, float y){
		return x-y;
	}
	public float addition(float x, float y){
		return x+y;
	}
	public float divide (float x, float y) {
		if(y==0){
			throw new IllegalArgumentException("division by zero");
		}
		return x/y;
	}
	
	public static void main(String[] args){
		Calculator	calc = new Calculator();
		System.out.println( calc.multiply(2, 3) );
		System.out.println( calc.divide(10, 2) );
	}
	
}
