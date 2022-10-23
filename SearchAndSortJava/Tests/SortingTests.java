
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

public class SortingTests {
	
	static boolean print = false;
	
	@Test
	void test() {
		// Sets the sorting function to test (algo is now a method reference to the sorting algorithm)
		Consumer<int[]> sortingAlgo = SearchAndSort::quickSort;

		// Setup the arrays to test and their solution
		int numOfTests = 1;
		int arrayLength = 1_000_000;
		int upperBound = 10_000_000;
		
		int[][] allTests = new int[numOfTests][arrayLength];
		int[][] allTestsSolutions = new int[numOfTests][arrayLength];
		
		Random rand = new Random();
		
		for (int i = 0; i < numOfTests; i++) {
			for (int j = 0; j < arrayLength; j++) {
				allTests[i][j] = rand.nextInt(upperBound);
			}
			int[] copy = Arrays.copyOf(allTests[i], arrayLength);
			Arrays.sort(copy);
			allTestsSolutions[i] = copy;
		}
		
		// Running the sorting algorithm on the arrays and compare outcome to the solution
		if (print) System.out.println("Testing Algorithm: ");
		
		double startTime = System.nanoTime();
		
		for (int i = 0; i < numOfTests; i++) {

			int[] testCopy = Arrays.copyOf(allTests[i], arrayLength); // Copying the next (unsorted) array from the allTests array
			
			if (print) System.out.print("A: " + Arrays.toString(testCopy));
			//SearchAndSort.bubbleSort(testCopy); // Sorting the array with bubbleSort
			sortingAlgo.accept(testCopy);
			if (print) System.out.println(" -> " + Arrays.toString(testCopy) + " Goal: " + Arrays.toString(allTestsSolutions[i]));
			
			assertArrayEquals(allTestsSolutions[i], testCopy); // Comparing the result to the solution in the allTestsSolutions array
		}
		
		double executionTime = (System.nanoTime() - startTime)/1_000_000_000;
		System.out.println("Execution Time in seconds: " + executionTime);
	}
}
