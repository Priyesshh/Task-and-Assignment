public class TemperatureConverter {

    public double fToC(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0; 
    }

    public double cToF(double celsius) {
        return celsius * 9.0 / 5.0 + 32;     
    }

    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        double cTemp = 25;
        double fTempFromC = converter.cToF(cTemp);
        System.out.println(cTemp + " Celsius is " + fTempFromC + " Fahrenheit");

        double fTemp = 98.6;
        double cTempFromF = converter.fToC(fTemp);
        System.out.println(fTemp + " Fahrenheit is " + cTempFromF + " Celsius");
    }
}