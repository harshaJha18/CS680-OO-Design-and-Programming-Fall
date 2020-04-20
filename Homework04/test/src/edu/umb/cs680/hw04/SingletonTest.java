package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingletonTest {

	Singleton instance1=Singleton.getInstance();
	Singleton instance2=Singleton.getInstance();
	
@Test 
public void sameInstance(){
	
	Singleton instance1=Singleton.getInstance();
	Singleton instance2=Singleton.getInstance();
	assertSame(instance1, instance2);
}
}
