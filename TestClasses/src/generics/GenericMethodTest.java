package generics;

//Fig. 20.3: GenericMethodTest.java
//Printing array elements using generic method printArray.

public class GenericMethodTest
{
	public static void main(String[] args)
	{
		// create arrays of Integer, Double and Character
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

		// original printArray tests
		System.out.printf("Array integerArray contains:%n");
		printArray(integerArray); // pass an Integer array
		System.out.printf("%nArray doubleArray contains:%n");
		printArray(doubleArray); // pass a Double array
		System.out.printf("%nArray characterArray contains:%n");
		printArray(characterArray); // pass a Character array

		// text separator
		System.out.println("_______________________________________\n");
		System.out.println("Overloaded printArray method tests:");
		System.out.println("_______________________________________\n");
		System.out.println("Array characterArray contains:");

		// tests
		try
		{
			int size = printArray(characterArray, 0, 4);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(characterArray, 0, 3);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(characterArray, 0, 2);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(characterArray, 0, 1);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(characterArray, 0, 0);
//			System.out.println("\nArray size = " + size);
			System.out.println();
//			throws exception. Exception is appropriately caught.
//			size = printArray(characterArray, 1, 0);
//			System.out.println("\nArray size = " + size);
//			System.out.println();
//			size = printArray(characterArray, 0, 10);
//			System.out.println("\nArray size = " + size);
//			System.out.println();
//			size = printArray(characterArray, 10, 11);
//			System.out.println("\nArray size = " + size);
//			System.out.println();
			System.out.println("\nArray doubleArray contains:");
			size = printArray(doubleArray, 2, 5);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(doubleArray, 1, 1);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(doubleArray, 1, 1);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(doubleArray, 0, 6);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(doubleArray, 4, 5);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(doubleArray, 4, 6);
//			System.out.println("\nArray size = " + size);
			System.out.println();
//			throws exception. Exception is appropriately caught.
//			size = printArray(doubleArray, 0, 7);
//			System.out.println("\nArray size = " + size);
//			System.out.println();
//			size = printArray(doubleArray, 7, 8);
//			System.out.println("\nArray size = " + size);
//			System.out.println();
//			size = printArray(doubleArray, 3, 2);
//			System.out.println("\nArray size = " + size);
//			System.out.println();
			System.out.println("\nArray integerArray contains:");
			size = printArray(integerArray, 2, 5);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(integerArray, 1, 1);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(integerArray, 0, 1);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(integerArray, 0, 5);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(integerArray, 4, 5);
//			System.out.println("\nArray size = " + size);
			System.out.println();
			size = printArray(integerArray, 3, 5);
//			System.out.println("\nArray size = " + size);
			System.out.println();
//			the three following tests throw exception. Exception is appropriately caught.
//			size = printArray(integerArray, 6, 7);
//			System.out.println("\nArray size = " + size);
//			System.out.println();
//			size = printArray(integerArray, 4, 3);
//			System.out.println("\nArray size = " + size);
//			System.out.println();
//			size = printArray(integerArray, 0, 7);
//			System.out.println("\nArray size = " + size);
//			System.out.println();
		}
		catch (InvalidSubscriptException e)
		{
			System.out.println("Exception caught: " + e.getClass());
		}
	}

	// generic method printArray
	public static <T> void printArray(T[] inputArray)
	{
		// display array elements
		for (T element : inputArray)
		{
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	// overloaded generic method printArray
	public static <T> int printArray(T[] inputArray, int lowSubscript, int highSubscript)
			throws InvalidSubscriptException
	{
		int numberOfElementsPrinted = 0;
		int lowIndex = lowSubscript;
		int highIndex = highSubscript;
		if (inputArray != null)
		{
			int arraySize = inputArray.length;
			if (lowIndex >= arraySize || lowIndex < 0 || highIndex >= arraySize 
					|| highIndex < 0 || highIndex < lowIndex)
			{
				throw new InvalidSubscriptException();
			}
			for (int i = lowIndex; i <= highIndex; i++)
			{
				System.out.print(inputArray[i].toString() + " ");
				numberOfElementsPrinted++;
			}
		}
		return numberOfElementsPrinted;
	}
} // end class GenericMethodTest

/**************************************************************************
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
 *************************************************************************/