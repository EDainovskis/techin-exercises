public class Division {

    public static void main(String[] args) {
        division(2, 1);
    }

    public static void division(int numerator, int denominator) {
        double result = (double) numerator / denominator;
        System.out.println(numerator + " / " + denominator + " = " + result);
    }
}