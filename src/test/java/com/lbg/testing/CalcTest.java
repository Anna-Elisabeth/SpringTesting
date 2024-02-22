package com.lbg.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.lbg.testingmethods.Calculator;

public class CalcTest {

	private Calculator calc = new Calculator();

	@Test
	void testAdd() {

		Assertions.assertEquals(8, this.calc.add(4, 4));

	}

	@Test
	void testSubtract() {

		Assertions.assertEquals(7, this.calc.subtract(10, 3));
	}

	@Test
	void testMultiply() {

		Assertions.assertEquals(4, this.calc.multiply(2, 2));
	}

	@Test
	void testDivide() {

		Assertions.assertEquals(4, this.calc.divide(8, 2));
	}

	@Test
	void testRemainder() {

		Assertions.assertEquals(1, this.calc.remainder(11, 2));
	}

}
