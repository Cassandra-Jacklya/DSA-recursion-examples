import java.util.*;

/** Author: Cassandra Jacklya
** Purpose: to show how the GCD (Greatest Common Denominator) can be found using recursion (With the addition of wrapper methods)
** Last modified on: 13th August 2020
**/

public class ActTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Greatest Common Denominator");
		int first, second, ans;
		
		//ensures that the program does not crash immediately upon encountering
		// ..an input mismatch
		try {
			System.out.print("Enter the first number: ");
			first = sc.nextInt();
			System.out.print("Enter the second number: ");
			second = sc.nextInt();
			ans = wrapGCDRec(first,second);
			System.out.println("The GCD for " + first + " and " + second + " : " + ans);
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage() + ": Value must be an integer");
		}
	}
	
	/** Submodule name: wrapGCDRec
	** Purpose: acts as a wrapper for the method GCDRec
	** Import: first (Integer), second (Integer)
	** Export: first (Integer)	//calls the recursive method GCDRec
	**/
	public static int wrapGCDRec(int first, int second) {
		//to take note that if either the first or second number is 0, the GCD is the
		// ...non-zero value
		if (first == 0) {
			first = second;
		}
		else if (second == 0) {
			second = first;
		}
		return GCDRec (first,second);
	}
	
	/** Submodule name: GCDRec
	** Purpose: performs the mathematical function to obtain the GCD between two integers
	** Import: first (Integer), second (Integer)
	** Export: first (Integer)
	**/
	
	//modified from previous own code in PDI to fit the usage of recursion
	private static int GCDRec(int first, int second) {
		while (first != second) {
			if (first > second ) {
				first = GCDRec(first-second,second);
			}
			else {
				second = GCDRec(first,second-first);
			}
		}
		return first;
	}
}