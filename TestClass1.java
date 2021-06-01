package Ü3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClass1 {
	
	// Test the old and new operations.(CalcEngine)

	@Test
	public void test1A() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(12);
		engine.plus();
		engine.numberPressed(9);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(21, engine.getDisplayValue());
	}
	
	@Test
	public void test1B() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(1265);
		engine.plus();
		engine.numberPressed(98);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(1363, engine.getDisplayValue());
	}
	
	@Test
	public void test1C() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(-12);
		engine.plus();
		engine.numberPressed(23);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(11, engine.getDisplayValue());
	}
	
	@Test
	public void test2A() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(12);
		engine.minus();
		engine.numberPressed(9);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(3, engine.getDisplayValue());
	}
	
	@Test
	public void test2B() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(9);
		engine.minus();
		engine.numberPressed(12);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(-3, engine.getDisplayValue());
	}
	
	@Test
	public void test2C() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(128);
		engine.minus();
		engine.numberPressed(58);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(70, engine.getDisplayValue());
	}
	
	@Test
	public void test3A() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(12);
		engine.multiply();
		engine.numberPressed(9);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(108, engine.getDisplayValue());
	}
	
	@Test
	public void test3B() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(-10);
		engine.multiply();
		engine.numberPressed(10);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(-100, engine.getDisplayValue());
	}
	
	@Test
	public void test4A() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(81);
		engine.divide();
		engine.numberPressed(9);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(9, engine.getDisplayValue());
	}
	
	@Test
	public void test4B() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(89);
		engine.divide();
		engine.numberPressed(9);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(9, engine.getDisplayValue());
	}
	
	@Test
	public void test5() {
		CalcEngine engine = new CalcEngine();
		engine.numberPressed(12);
		engine.modulo();
		engine.numberPressed(9);
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals(3, engine.getDisplayValue());
	}
	
	// Test UserInterface. (Create new Calculator)
	@Test
	public void test6() {
		Calculator c = new Calculator();
		c.show();
	}

}
