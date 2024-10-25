import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void add() {
        calculator.setUpperLimit(10);
        int result = calculator.add(2, 2);
        assertEquals(4, result);
    }
    
    @Test
    public void addWithDifferentArguments() {
        calculator.setUpperLimit(10);
        int result = calculator.add(2, 5);
        assertEquals(7, result);
    }
    
    @Test
    public void substract() {
        int result = calculator.substract(5, 3);
        assertEquals(2, result);
    }
    
    @Test
    public void substractReturningNegative() {
        calculator.setLowerLimit(-10);
        int result = calculator.substract(3, 5);
        assertEquals(-2, result);
    }
    
    @Test
    public void substractSettingLimintValues() {
        Calculator calculator = new Calculator(-100, 100);
        int result = calculator.substract(5, 10);
        assertEquals(-5, result);
    }
    
    @Test
    public void substractExcedingLowerLimit() {
        Calculator calculator = new Calculator(-100, 100);
        try{
            int result = calculator.substract(10,150);
            fail("Exception is not being thrown when exceeding lower limit");
        }catch(ArithmeticException e){
            // Ok, the SUT works as expected
        }
    }
    
    @Test
    public void setAndGetUpperLimt() {
        Calculator calculator = new Calculator(-100, 100);
        assertEquals(100, calculator.getUpperLimit());
    }
    
    @Test
    public void setAndGetLimit() {
        Calculator calculator = new Calculator(-100, 100);
        assertEquals(100, calculator.getUpperLimit());
        assertEquals(-100, calculator.getLowerLimit());
    }
    
    @Test
    public void addExcedingUpperLimit() {
        Calculator calculator = new Calculator(-100, 100);
        try{
            int result = calculator.add(10, 150);
            fail("This should fail: we're exceding upper limit");
        }catch(ArithmeticException e) {
            //Ok, the SUT works as expected
        }
    }
    
    @Test
    public void argumentsExceedLimits() {
        Calculator calculator = new Calculator(-100, 100);
        try{
            calculator.add(calculator.getUpperLimit() +1, calculator.getLowerLimit() -1);
            fail("This should fail: arguments exceed limits");
        }catch(ArithmeticException e) {
            //OK, this works
        }
    }
    
    @Test
    public void argumentsExceedLimitsInverse() {
        Calculator calculator = new Calculator(-100, 100);
        try{
            calculator.add(calculator.getLowerLimit() -1, calculator.getUpperLimit() +1);
            fail("This should fail: arguments exceed limits");
        }catch(ArithmeticException e) {
            // Ok, this works
        }
    }
}
