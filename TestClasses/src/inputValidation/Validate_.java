package inputValidation;

// Fig. 14.21: Validate.java
// Input and validate data from user using the ValidateInput class.
import java.util.Scanner;

public class Validate_
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		boolean valid;

		// get user input
		do
		{
			valid = true; // assume valid data
			System.out.println("Please enter first name:");
			String firstName = scanner.nextLine();
			if (!ValidateInput_.validateFirstName(firstName))
			{
				System.out.println("Invalid first name");
				valid = false;
			}
		}
		while (!valid);
		scanner.close();
	} // end main()
} // end class Validate

/*
 **************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 **************************************************************************
 */