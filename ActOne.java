import java.util.*;
import java.math.BigInteger; 

/** Author: Cassandra Jacklya
** Purpose: to show how factorial and fibonacci works using recursion (With the addition of wrapper methods)
** Last modified on: 13th August 2020
**/

public class ActOne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		//prints a menu display to the user
		try {
			System.out.println("Choose a number: ");
			System.out.println("1: Perform Factorial");	//can only reach up to n = 8930 before StackOverflowError occurs
			System.out.println("2: Perform Fibonacci");	//can reach up to any number, however takes a very long period of time to display the output as 
														//...it progresses higher
			choice = sc.nextInt();
		
			int n;
			long ans;
			if (choice == 1) {
				System.out.print("Enter n (any number): ");
				n = sc.nextInt();
				System.out.println(n+"! = "+wrapFactorialRec(n));
			}
			else if (choice == 2) {
				System.out.print("Enter nth term (any number): ");
				n = sc.nextInt();
				for (int ii = 2; ii < n; ii++) {
					System.out.println(wrapFibRec(ii));
				}
			}
			else {
				throw new IllegalArgumentException("ERROR: ");
			}
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage() + "Value is out of bounds");
		}
	}
				
	/** Submodule name: wrapFactorialRec
	** Purpose: acts a wrapper to hold any exceptional handling for the private method
	** Import: n (Integer)
	** Output: factorial (BigInteger)
	**/
	public static BigInteger wrapFactorialRec(int n) {
	    try {
			
			//ensures that only positive values are accepted
			if (n < 0) {
				throw new IllegalArgumentException("ERROR: ");
			}
		}
		catch (IllegalArgumentException e) {
			
			//provides a more specific message towards the user regarding the error encountered
			System.out.println(e.getMessage() + ": Value cannot be negative");
		}
		
		//calls the recursive method factorialRec after validation of imported data
		return factorialRec(n);
	}
			
	/** Submodule name: factorialRec
	** Purpose: performs the factorial function using recursion
	** Import: n (Integer)
	** Export: factorial (BigInteger)
	**/
	private static BigInteger factorialRec(int n) {
		BigInteger factorial = new BigInteger("1");
		if (n == 0) {
			factorial = BigInteger.valueOf(1);
		}
		else {
			
			//remember that 5! = 5 x 4!
			//4! = 4 x 3! ... and so on
			factorial = (BigInteger.valueOf(n)).multiply(factorialRec(n-1));
		}
		return factorial;
	}
	
	/** Submodule name: wrapFibRec
	** Purpose: acts as a wrapper method 
	** Import: n (Integer)
	** Export: value (BigInteger) 	//calls the recursive method fibRec(int n)
	**/
	public static BigInteger wrapFibRec(int n) {
		try {
			if (n < 0) {
				throw new IllegalArgumentException("ERROR: ");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage() + ": Value cannot be negative");
		}
		return fibRec(n);
	}
	
	/** Submodule: fibRec
	** Purpose: performs the fibonacci function of two integers
	** Import: n (Integer)
	** Export: value (BigInteger)
	**/
	private static BigInteger fibRec(int n) {
		BigInteger value = new BigInteger("0");
		
		//if there is none or just one value, then the result will be the value itself
		if (n == 0) {
			value = BigInteger.valueOf(0);
		}
		else if (n == 1) {
			value = BigInteger.valueOf(1);
		}
		else {
			
			//fibonacci is the result of the previous two values (can be addition or subtraction)
			//however, uses addition here just to show how it works
			value = (fibRec(n-1)).add(fibRec (n-2));
		}
		return value;
	}
	
}
	
			
			
			