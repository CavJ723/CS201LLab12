import java.io.PrintWriter;
import java.util.ArrayList;

public class Recursion {

    // PRE: accepts a non-negative integer value
    // POST: returns the factorial of the given value
    public static long factorialR(long value){
        if (value == 0)
            return 1;
        return value * factorialR(value - 1);
    }
    
    public static boolean palindromeR(String str, int left, int right){
        // Base case 1: left >= right
        if (left >= right) {
            return true;
        }
        
        // Base case 2: characters at left and right positions don't match
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        
        // Recursive case
        return palindromeR(str, left + 1, right - 1);
    }


    // PRE: accepts a PrintWriter and a string
    // POST: prints the reverse of the string using recursion
    public static void reverseStringR(PrintWriter outputWriter, String str){
        outputWriter.print("The string " + str + " in reverse is: ");
        reverseStringRHelper(outputWriter, str, str.length() - 1);
        outputWriter.println(); // Add newline
    }
    

    // PRE: accepts a PrintWriter, a string, and an index
    // POST: helper method to print the string in reverse recursively
    private static void reverseStringRHelper(PrintWriter outputWriter, String str, int index) {
        // Base case: index is negative
        if (index < 0) {
            return;
        }
        
        // Print current character and recursively print the rest
        outputWriter.print(str.charAt(index));
        reverseStringRHelper(outputWriter, str, index - 1);
    }


    // PRE: accepts an integer value and a divisor n
    // POST: returns true if value is prime, false otherwise
    public static boolean isPrimeR(int value, int n) {
        // Base case 1: n is larger than sqrt of value
        if (n * n > value) {
            return true;
        }
        
        // Base case 2: value is divisible by n exactly
        if (value % n == 0) {
            return false;
        }
        
        // Recursive case
        return isPrimeR(value, n + 1);
    }
 

    // PRE: accepts an ArrayList of integers and a position index
    // POST: returns the sum of the integers in the ArrayList
    public static int sumR(ArrayList<Integer> nums, int pos) {
        // Base case: pos equals the length of the ArrayList
        if (pos == nums.size()) {
            return 0;
        }
        
        // Recursive case
        return nums.get(pos) + sumR(nums, pos + 1);
    }
 

}

   