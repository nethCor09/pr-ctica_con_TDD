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
        int result = calculator.add(2, 2);
        assertEquals(4, result);
    }
    
    @Test
    public void addWithDifferentArguments() {
        int result = calculator.add(2, 5);
        assertEquals(7, result);
    }
    
    @Test
    public void subtract() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }
    
}
