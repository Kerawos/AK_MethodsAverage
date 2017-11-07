package pl.AkademiaKodu.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryCalculatorTest {

    private static SalaryCalculator calculator;

    @BeforeClass
    public static void Start(){
        calculator = new SalaryCalculator();
    }

    @AfterClass
    public static void stop(){
        calculator = null;
    }

    @Test
    public void zusTest(){
        double x = calculator.calcZUSTribute(250);
        double y = 34.28;
        assertEquals(y, x, 0);
        assertEquals(calculator.calcZUSTribute(1), 0.14, 0);
        assertEquals(calculator.calcZUSTribute(1504.15), 206.22, 0);
        assertNotEquals(calculator.calcZUSTribute(100), 10);
    }

    @Test
    public void netSalaryTest(){
        double x = calculator.salaryNetCalculator(3000, 0, 15);
        double y = 2155.72;
        assertEquals(y, x, 0);
        assertEquals(calculator.salaryNetCalculator(15687,1200,5), 9773.34, 0);
        assertEquals(calculator.salaryNetCalculator(1250,20,0), 949.25, 0);
        assertNotEquals(calculator.salaryNetCalculator(5000,2000,100), 20000);
    }

    @Test
    public void netSalaryTest2(){
        try{
            calculator.salaryNetCalculator(-2005,25,1);
            fail("Exc not catch");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}