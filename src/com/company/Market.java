package src.com.company;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Market {

    public static void main(String[] args) throws IOException {
        List<Integer> input = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("./src/com/company/input2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(Integer.parseInt(line));
            }
        }

        List<Drob> drobs = new ArrayList<>();
        for (int i = 0; i < input.size() - 1; i += 2) {
            drobs.add(new Drob(input.get(i), input.get(i + 1)));
        }

        Scanner in = new Scanner(System.in);

        // Index of first Drob starting from 0.
        System.out.print("Input a number: ");
        int left = in.nextInt();
        // Operation sign
        System.out.print("Input an operation: ");
        String op = in.next();
        // Index of second Drob starting from 0.
        System.out.print("Input a number: ");
        int right = in.nextInt();
        in.close();

        System.out.println("Drob[" + left + "] " + op + " Drob[" + right + "]");
        Calculator calculator = new Calculator();
        Drob result = null;

        if (op.equals("+")) {
            result = calculator.sum(drobs.get(left), drobs.get(right));
        } else if (op.equals("-")) {
            result = calculator.minus(drobs.get(left), drobs.get(right));
        } else if (op.equals("*")) {
            result = calculator.times(drobs.get(left), drobs.get(right));
        } else if (op.equals("/")) {
            result = calculator.divide(drobs.get(left), drobs.get(right));
        } else if (op.equals("+/2")) {
            result = calculator.sumTwiceDiv(drobs.get(left), drobs.get(right));
        } else {
            System.out.println("Only `+`, `-`, `*`, `/`, `+*2`, `+/2` operations are supported");
        }

        if (result != null) {
            System.out.println(result);
        }

    }

}
