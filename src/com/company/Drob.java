package src.com.company;

public class Drob {
    private final int numerator;
    private final int denominator;


    public Drob(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator can't be equal to 0");
        }

        if (denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }

        int divisor = calculateGreatestCommonDivisor(numerator, denominator);
        this.numerator = numerator / divisor;
        this.denominator = denominator / divisor;
    }


    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    @Override
    public String toString() {
        boolean isPositive = numerator > 0;
        int a = numerator;
        if (!isPositive) {
            a *= -1;
        }
        int b = denominator;

        int full = 0;
        while (a > b) {
            full++;
            a -= b;
        }

        if (full == 0 && a == 0) {
            return "0";
        }

        String answer = "";
        if (!isPositive) {
            answer += "-";
        }
        if (full > 0) {
            answer += full + " ";
        }
        if (a > 0) {
            answer += a + "/" + b;
        }

        return answer.trim();
    }



    private int calculateGreatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculateGreatestCommonDivisor(b, a % b);
        }
    }
}
