import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//comment name, lecture & lab section
// Judi Cavender, CS201L, Lab section: Tuesdays 7:00 PM

class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String errorFile = "error.txt";

    System.out.println("Starting Recursion Program");
 
        ArrayList<String> inputLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                inputLines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return;
        }

       // go through input lines and use token[0] to determine which method to call
       // then use token[1] as input(s) to that method
       // write results to output file
        try (PrintWriter outputWriter = new PrintWriter(new FileWriter(outputFile));
             PrintWriter errorWriter = new PrintWriter(new FileWriter(errorFile))) {
            for (String inputLine : inputLines) {
                String[] tokens = inputLine.split(",");
                String command = tokens[0];
                try {
                    // Use cases to call appropriate Recursion methods
                    switch (command) {
                        case "factorialR":
                            // Make sure input is valid (will check for all cases)
                            if (tokens.length != 2 || !isDigits(tokens[1])) {
                                throw new IllegalArgumentException("Invalid input for factorial");
                            }
                            // Now assign tokens and call method
                            long value = Long.parseLong(tokens[1]);
                            long result = Recursion.factorialR(value);
                            // Write result to output file
                            outputWriter.println("The factorial of " + value + " is " + result);
                            break;
                        case "palindromeR":
                            if (tokens.length != 2) {
                                throw new IllegalArgumentException("Invalid input for palindrome");
                            }
                            String str = tokens[1];
                            boolean isPalindrome = Recursion.palindromeR(str, 0, str.length() - 1);
                            outputWriter.println("The string " + str + " is " + (isPalindrome ? "a palindrome" : "not a palindrome"));
                            break;
                        case "reverseStringR":
                            if (tokens.length != 2) {
                                throw new IllegalArgumentException("Invalid input for reverseString");
                            }
                            Recursion.reverseStringR(outputWriter, tokens[1]);
                            break;
                        case "isPrimeR":
                            if (tokens.length != 2 || !isDigits(tokens[1])) {
                                throw new IllegalArgumentException("Invalid input for isPrime");
                            }
                            int intValue = Integer.parseInt(tokens[1]);
                            boolean isPrime = Recursion.isPrimeR(intValue, 2);
                            outputWriter.println("The value of " + intValue + " is " + (isPrime? "prime" : "not prime"));
                            break;
                        case "sumR":
                            if (tokens.length < 2) {
                                throw new IllegalArgumentException("Invalid input for sum");
                            }
                            ArrayList<Integer> nums = new ArrayList<>();
                            for (int i = 1; i < tokens.length; i++) {
                                if (!isDigits(tokens[i])) {
                                    throw new IllegalArgumentException("Non-integer value in sum input");
                                }
                                nums.add(Integer.parseInt(tokens[i]));
                            }
                            int sum = Recursion.sumR(nums, 0);
                            outputWriter.println("The sum of values: " + nums + " is " + sum);
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown command: " + command);
                    }
                } catch (Exception e) {
                    errorWriter.println("Error processing line: \"" + inputLine + "\" - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to output or error file: " + e.getMessage());
        }

        System.out.println("Recursion Program Completed");
 
    }


    // Given helper method to check if a string is all digits
    public static boolean isDigits(String str){
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
