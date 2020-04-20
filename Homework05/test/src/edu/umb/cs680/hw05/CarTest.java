package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

	private String[] carToStringArray1(Car c){
		String[] carInfo = {c.getMake(),c.getModel(),Integer.toString(c.setMileage(c.getMileage())),Integer.toString(c.setYear(c.getYear())),Float.toString(c.setPrice(c.getPrice()))};
		return carInfo;
		
	}
	private String[] carToStringArray2(Car c){
		String[] carInfo = {c.getMake(),c.getModel(),Integer.toString(c.setYear(c.getYear()))};
		return carInfo;
		
	}
	@Test
		public void verifyCarEqualityWithCarInfo() {

			String[] expected = {"Tesla", "Cybertruck","500", "2019","75000.43"};
			Car actual =new Car("Tesla","Cybertruck",500,2019,(float) 75000.43);
			String[] actualarray=carToStringArray1(actual);
			assertArrayEquals(expected,actualarray);

	
		}
		
		@Test
		public void verifyCarEqualityWithMakeModelYear() {

		String[] expected = {"Tesla", "Cybertruck","2019"};
		Car actual =new Car("Tesla","Cybertruck",2019);
		String[] actualarray=carToStringArray2(actual);
		assertArrayEquals(expected,actualarray);

			
		}



}
