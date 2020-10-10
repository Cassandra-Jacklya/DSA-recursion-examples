import java.util.*;

/** Author: Cassandra Jacklya
** Purpose: to show how to implement base conversions from decimal (With the addition of wrapper methods)
** Last modified on: 13th August 2020
**/

public class ActFive {
	
	//to be used in the moveDisk method for applying indentation to the outputs in different levels
	static Integer indents = -2;
	static String indent = "  ";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean valid;
		int disk = -1;
		//loop will only break if the number of disks entered is a positive number
		do {
			valid = true;
			try {
				System.out.print("Enter the number of disks: ");
				disk = sc.nextInt();
				if (disk < 0) {
					valid = false;
					throw new IllegalArgumentException("Error: ");
				}
				else {
					towersOfHanoi(disk,1,3);
				}
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage() + "Please enter a positive number");
			}
			catch (InputMismatchException e2) {
				valid = false;
				System.out.println(e2.getMessage() + ": Value must be an integer");
			}
			sc.nextLine();
		} while (valid == false);
	}
	
	/** Submodule name: towersOfHanoi
	** Purpose: perform the towersOfHanoi game to move from the source peg to the destination peg
	** Import: disk (Integer), source (Integer), dest (Integer)
	** Export: none
	**/
	public static void towersOfHanoi(int disk, int source, int dest){
		int temp;
		if (disk == 1) {	//base case
			moveDisk(source,dest);	
		}
		else {
			temp = 6 - source - dest;	// temp is the auxillary peg (or the unused peg which is neither the source or dest)
			towersOfHanoi(disk-1,source,temp);
			moveDisk(source,dest);
			towersOfHanoi(disk-1,temp,dest);
		}
	}
	
	/** Submodule name: moveDisk
	** Purpose: outputs the action of the movement of disks from one peg to another
	** Import: source (Integer), dest (Integer)
	** Export: none
	**/
	private static void moveDisk(int source, int dest) {
		
		//increases the count for every time the moveDisk method is called
		indents = indents + 1;
		
		/** part of code refers to
		** https://stackoverflow.com/questions/63388895/how-to-output-indenting-strings-in-java
		** Author: Aneesh
		** 13th August 2020
		**/
		
		StringBuilder sb = new StringBuilder();	
		for(int ii = 0; ii<= indents; ii++) {
			sb.append(indent);	//appends the sb by adding the variable "indent" to the String sb
		}
		
		//adds more strings to the variable String sb
		sb.append("Moving top disk from "+ source + " to " + dest);
		
		//prints out the value in String sb
		System.out.println(sb.toString());
		
	}
}
		
		
	
		