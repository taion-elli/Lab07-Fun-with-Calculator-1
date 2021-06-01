package Ü3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClass2 {
	
	// Emulate actionPerformed() from UserInterfaceHex.
	private int testInt(String s, int j) {
		int i = Integer.parseInt(s, j);
		return i;
	}
	
	// Emulate redisplay() from UserInterfaceHex.
	private String testString(int i) {
		String s = Integer.toString(i, 16).toUpperCase();
		return s;
	}
	
	// Test operations with HexCalcEngine.
	@Test
	public void test1A() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("1E", 16));
		engine.plus();
		engine.numberPressed(testInt("9B", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("B9", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test1B() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("15", 16));
		engine.plus();
		engine.numberPressed(testInt("46", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("5B", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test1C() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("-1E", 16));
		engine.plus();
		engine.numberPressed(testInt("9B", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("7D", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test2A() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("-1E", 16));
		engine.minus();
		engine.numberPressed(testInt("9B", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("-B9", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test2B() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("1E4", 16));
		engine.minus();
		engine.numberPressed(testInt("8C", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("158", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test2C() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("FF", 16));
		engine.minus();
		engine.numberPressed(testInt("9", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("F6", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test3A() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("-A", 16));
		engine.multiply();
		engine.numberPressed(testInt("A", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("-64", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test3B() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("FF", 16));
		engine.multiply();
		engine.numberPressed(testInt("A", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("9F6", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test4A() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("51", 16));
		engine.divide();
		engine.numberPressed(testInt("9", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("9", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test4B() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("54", 16));
		engine.divide();
		engine.numberPressed(testInt("9", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("9", testString(engine.getDisplayValue()));
	}
	
	@Test
	public void test5() {
		CalcEngine engine = new HexCalcEngine();
		engine.numberPressed(testInt("C", 16));
		engine.modulo();
		engine.numberPressed(testInt("9", 16));
		engine.equals();
		System.out.println(engine.getDisplayValue());
		assertEquals("3", testString(engine.getDisplayValue()));
	}
	
	//// Test UserInterface. (Create new Calculator)
	@Test
	public void test6() {
		CalculatorHex c = new CalculatorHex();
		c.show();
	}

}
