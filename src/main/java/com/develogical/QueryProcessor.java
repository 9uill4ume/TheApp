package com.develogical;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Arrays;
import java.util.Scanner;

public class QueryProcessor {

    public String process(String query) {


        if
                (
                !query.contains("Fibonacci")
                        && !query.contains("plus")
                        && !query.contains("minus")
                        && !query.contains("primes")
                        && !query.contains("Britain")
                        && !query.contains("square")
                        && !query.contains("multiplied")
                        && !query.contains("largest")
                        && !query.contains("James")
                        && !query.contains("Eiffel")
                        && !query.contains("banana")
                        && !query.contains("spain")
                        && !query.contains("programming")
                        && !query.contains("power")
                ) {
            return "";
        }


        if (query.contains("programming")) {
            return "Computer programming is the comprehensive process that leads from an original "
                    + "formulation of a computing problem to executable programs.";
        }

        if (query.contains("who is the Prime Minister of Great Britain")) {
            return "David Cameron";
        }
        if (query.contains("what colour is a banana")) {
            return "yellow";
        }

        if (query.contains("what currency did Spain use before the Euro")) {
            return "peseta";
        }
        if (query.contains("which city is the Eiffel tower in")) {
            return "paris";
        }
        if (query.contains("who played James Bond in the film Dr No")) {
            return "sean connery";
        }

        if (query.contains("square") || query.contains("which")) {
            String[] parts = query.split(":");
            String numbers = parts[2].trim();
            String[] listNumber = numbers.split(",");
            Integer[] ListNumberInt = new Integer[listNumber.length];
            for (int i = 0; i < listNumber.length; i++) {
                ListNumberInt[i] = Integer.parseInt(listNumber[i].trim());
            }

            if (query.contains("square")) {
                for (int i = 0; i < ListNumberInt.length; i++) {

                    if (
                            (Math.floor(Math.sqrt(ListNumberInt[i])) == Math.sqrt(ListNumberInt[i]))
                                    && (Math.floor(Math.cbrt(ListNumberInt[i])) == Math.cbrt(ListNumberInt[i]))

                            ) {
                        Integer resulta = ListNumberInt[i];
                        return resulta.toString();
                    }

                }
                return "";
            }
            if (query.contains("primes")) {
                String Resultats = "";
                boolean first = true;
                for (int i = 0; i < ListNumberInt.length; i++) {
                    if (isPrime(ListNumberInt[i])) {
                        if (first) {
                            first = false;
                            Resultats.concat(ListNumberInt[i].toString());
                        } else {
                            Resultats.concat(", ").concat(ListNumberInt[i].toString());
                        }
                    }
                }
            }
            if (query.contains("which")) {
                Arrays.sort(ListNumberInt);
                return ListNumberInt[ListNumberInt.length - 1].toString();

            }
        }
        if (query.contains("what")) {


            String[] Parts = query.split(" ");
            Integer result = new Integer(0);

            if (query.contains("Fibonacci")) {
                Scanner in = new Scanner(Parts[4]).useDelimiter("[^0-9]+");
                int iteration = in.nextInt();
                result = fibonacci(iteration);
                return result.toString();
            }
            if (query.contains("power")) {
                result = (int) Math.pow(Double.parseDouble(Parts[3].toString()), Double.parseDouble(Parts[8].toString()));
                return result.toString();
            }

            String[] parties = query.split(":");
            String Expression = parties[1];
            Expression = Expression.replace("by", "").replaceAll("what is", "").replaceAll("to","").replaceAll("of","").replaceAll("the","")
                    .replaceAll(" ", "")
                    .replaceAll("plus", "+")
                    .replaceAll("minus", "-")
                    .replaceAll("multiplied", "*")
                    .replaceAll("divided", "/")
                    .replaceAll("power", "^")
            ;
            try {
                Calculable calc = new ExpressionBuilder(Expression).build();
                return Double.toString(Math.floor(calc.calculate()));
            }catch(Exception nfe) {
                System.out.println(nfe.getMessage());
                return "";
            }

        }


        return "";
    }

    public boolean isPrime(Integer number) {
        //check if number is 2, the odd even prime
        if (Math.abs(number) == 2)
            return true;
        //check if number is a multiple of 2
        if (number % 2 == 0)
            return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;

    }


    public int fibonacci(int n) {

//Error condition:

        if (n < 0) {
            return -1;
        }

//Base cases:
        else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
        return 0;
    }

}
