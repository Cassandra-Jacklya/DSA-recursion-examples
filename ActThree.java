import java.util.*;

/** Author: Cassandra Jacklya
** Purpose: to show how to implement base conversions from decimal (With the addition of wrapper methods)
** Last modified on: 13th August 2020
**/

public class ActThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int baseNum;
		long n;
		boolean valid;
		try {
			//loop only breaks once the valid number is provided (2-16) inclusive
			do {
				valid = true;
				System.out.print("Convert Decimal to (Enter a number 2-16): ");
				baseNum = sc.nextInt();
				if ((baseNum < 2) || (baseNum > 16)) {
					valid = false;
				}
			} while (valid == false);
			System.out.print("Enter a base-10 number: ");
			n = sc.nextLong();
			System.out.println("Decimal to base-" + baseNum + " number system: " + wrapConvert(n, baseNum));
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage() + ": Value is not an integer");
		}
	}
	
	/** Submodule name: wrapConvert
	** Purpose: acts as a wrapper method for decConvRec
	** Import: num (Long), base (Integer)
	** Export: finalNum (String)	//..calls the recursive method decConvRec
	**/
	public static String wrapConvert(long num, int base) {
		try {
			if (num < 0) {
				throw new IllegalArgumentException("Error: ");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage() + "The base-10 number should not be negative");
		}
		return decConvRec(num,base);
	}
		
	/** Submodule name: decConvRec
	** Purpose: to convert decimal base number system (base 10) to any base number system from 2-16 inclusive
	** Import: num (Long), base (Integer)
	** Export: finalNum (String)
	**/
	private static String decConvRec(long num, int base) {
		long remainder;
		String finalNum = "";
		
		//..remember that conversions occur generally on the remainder
		remainder = num%base;
		
		//num changes after every recurse
		num = num/base;
		
		//checks whether it is a base-16 conversion
		if (remainder > 9) {
			if (num == 0) {						//this is the base case
				finalNum = casesOfHex((int)remainder) + finalNum;
			}
			else {
				finalNum = decConvRec(num,base) + casesOfHex((int)remainder) + finalNum;
			}
		}
		
		//applies for all base conversions 2-15 (except 16 as it is a special case including letters)
		else {
			if (num == 0) {
				finalNum = remainder + finalNum;
			}
			else {
				finalNum = decConvRec(num,base) + remainder + finalNum;
			}
		}
		return finalNum;
	}
	
	/** Submodule name: casesOfHex
	** Purpose: to correctly match the conversion of decimal numbers > 9 to base-16 equivalent
	** Import: value (Integer)
	** Export: temp (String)
	**/
	private static String casesOfHex(int value) {
		String temp = "";
		switch(value){
			case 10:
				temp = "A";
				break;
			case 11:
				temp = "B";
				break;
			case 12:
				temp = "C";
				break;
			case 13: 
				temp = "D";
				break;
			case 14: 
				temp = "E";
				break;
			case 15: 
				temp = "F";
				break;
		}
		return temp;
	}
}

	
				
		
		
		