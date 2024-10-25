public class Calculator {
    private int upperLimit;
    private int lowerLimit;
    
    public Calculator(){}
    
    public Calculator(int minValue, int maxValue) {
        upperLimit = maxValue;
        lowerLimit = minValue;
    }
    
    public int getLowerLimit() {
        return lowerLimit;
    }
    
    public void setLowerLimit(int minValue) {
        lowerLimit = minValue;
    }
    
    public int getUpperLimit() {
        return upperLimit;
    }
    
    public void setUpperLimit(int maxValue) {
        upperLimit = maxValue;
    }
    
    
    public int add(int arg1, int arg2) {
        int result = arg1 + arg2;
        if(result > upperLimit) {
            throw new ArithmeticException("Upper limit exceeded");
        }
        return result;
    }
    
    public int substract(int arg1, int arg2) {
        int result = arg1 - arg2;
        if(result < lowerLimit) {
            throw new ArithmeticException("lower limit exccede");
        }
        return result;
    }
}
