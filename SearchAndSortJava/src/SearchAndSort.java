import java.util.Arrays;
import java.util.Scanner;

public class SearchAndSort {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		//int[] test = getArray(console);
		int[] test = new int[] {973, 330, 640, 331, 181, 84, 366, 524, 981, 19};
		mergeSort(test);
		System.out.println(Arrays.toString(test));
		
		console.close();
	}
	
	public static int[] getArray(Scanner s) {
		System.out.print("Enter the length of the array: ");
		int n = s.nextInt();
		int[] out = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Element Nr." + i + " : ");
			out[i] = s.nextInt();
		}
		System.out.println("Returned -> " + Arrays.toString(out));
		return out;
	}
	
	// LINEAR SEARCH O(n)
	public static int findIndex(int x, int[] A) { // Works on unordered lists, returns the index of x in A or -1 if x doesn't exist in A
		if (A == null || A.length == 0) {
			return -1;
		}
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	// BINARY SEARCH O(nlog(n))
	public static int incBinarySearch(int x, int[] A, int l, int r) { // Only works on increasingly ordered arrays, returns the index of x in A or where x should be in the array
		if (A == null || A.length == 0) {
			return 0;
		} 
		
		int m;
		
		while (l <= r) {
			m = (r+l)/2;
			if (A[m] == x) {
				return m;
			} else if (x < A[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return r+1;
	}
	
	public static int decBinarySearch(int x, int[] A, int l, int r) { // Only works on decreasingly ordered arrays, returns the index of x in A or where x should be in the array
		if (A == null || A.length == 0) {
			return 0;
		} 

		int m;
		
		while (l <= r) {
			m = (r+l)/2;
			if (A[m] == x) {
				return m;
			} else if (x < A[m]) {
				l = m + 1;
			} else {
				r = m -1;
			}
		}
		return r+1;
	}

	// CHECK IF SORTED O(n)
	public static boolean isSortedInc(int[] A) { // checks if for all elements i if A[i] <= A[i+1]
		if (A == null) {
			return true;
		}
		for (int i = 0; i < A.length-1; i++) {
			if (A[i] > A[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isSortedDec(int[] A) { // checks if for all elements i if A[i] >= A[i+1]
		if (A == null) {
			return true;
		}
		for (int i = 0; i < A.length-1; i++) {
			if (A[i] < A[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	// SWAP O(1)
	public static void swap(int i, int j, int[] A) {
		int rem = A[i];
		A[i] = A[j];
		A[j] = rem;
	}
	
	// BUBBLE SORT O(n^2) comparisons and swaps
	public static void bubbleSort(int[] A) {
		if (A == null) {
			return;
		}
		for (int i = 0; i < A.length-1; i++) {	
			for (int j = 0; j < A.length-1; j++) {
				if (A[j] > A[j+1]) {
					swap(j, j+1, A);
				}
			}
		}
	}
	
	// SELECTION SORT O(n) swaps and O(n^2) comparisons
	public static void selectionSort(int[] A) {
		if (A == null) {
			return;
		}
		for (int i = 0; i < A.length-1; i++) {
			// find smallest element in A[i..]
			int minInd = i;
			for (int j = i+1; j < A.length; j++) {
				if (A[j] < A[minInd]) {
					minInd = j;
				}
			}
			swap(i, minInd, A);
		}
	}
	
	// INSERTION SORT O(n^2) swaps and O(nlog(n)) comparisons
	public static void insertionSort(int[] A) {
		if (A == null) {
			return;
		}
		for (int r = 1; r < A.length; r++) {
			int k = incBinarySearch(A[r], A, 0, r);
			for (int i = r; i > 0 && i > k; i--) {
				swap(i, i-1, A);
			}
		}
	}
	
	// HEAP SORT O(nlog(n))
	public static void restoreHeapCondition(int[] A, int i, int upTo) { // versickere i-tes element im baum, so dass die heap condition wieder gilt, ignoriert alle elemente hinter upTo	
		if (A == null || A.length == 1) {
			return;
		}
		
		while (true) {		
			int lInd = 2*i+1;
			int rInd = lInd+1;
			
			boolean hasLeftChild = lInd < upTo;
			boolean hasRightChild = rInd < upTo;
			
			if (hasRightChild && A[lInd] >= A[rInd] && A[i] < A[lInd]) { // left child is >= right child and left child is > parent node
				swap(i, lInd, A);
				i = lInd;
			} else if (hasRightChild && A[rInd] >= A[lInd] && A[i] < A[rInd]){ // right child is >= left child and right child > parent node
					swap(i, rInd, A);
					i = rInd;
			} else if (hasLeftChild && A[i] < A[lInd]) { // node i only has a left child and left child > parent node
				swap(i, lInd, A);
				i = lInd;
			} else { // heap condition is met for the current node
				break;
			}
		}
		return;
	}
	
	public static void heapSort(int[] A) {
		if (A == null || A.length == 1) {
			return;
		}
		// Build Max-Heap at the beginning 
		int n = A.length;
		for (int i = A.length/2; i >= 0; i--) {
			restoreHeapCondition(A, i, n);
		}

		// repeat: swap first element (max) with the last unsorted element, then restoreHeapCondition in the unsorted part
		for (int i = n-1; i > 0; i--) {
			swap(0, i, A);
			restoreHeapCondition(A, 0, i);
		}
	}

	// MERGE SORT O(nlog(n))
	public static void merge(int[] A, int l, int m, int r) { // l and r inclusive
		int[] B = new int[r-l+1];
		
		int i = l;
		int j = m+1;
		int k = 0;
		
		
		while (i <= m && j <= r) {
			if (A[i] < A[j]) {
				B[k] = A[i];
				i++;
				k++;
			} else {
				B[k] = A[j];
				j++;
				k++;
			}
		}
		// Rest
		while (i <= m) {
			B[k] = A[i];
			i++;
			k++;
		} 
		// Rest
		while (j <= r) {
			B[k] = A[j];
			j++;
			k++;
		}
		// Copy results of B back into A
		for (int ind = l; ind <= r; ind++) {
			A[ind] = B[ind-l];
		}		
	}
	
	public static void mergeSort(int[] A, int l, int r) { // This method gets called in the recursive calls (method overloading)
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(A, l, m);
			mergeSort(A, m+1, r);
			merge(A, l, m, r);
		}
	}
	
	public static void mergeSort(int[] A) { // This method gets called in the initial call 
		if (A == null || A.length == 1) {
			return;
		}
		int n = A.length;
		int m = n/2;
		
		mergeSort(A, 0, m);
		mergeSort(A, m+1, n-1);
		merge(A, 0, m, n-1);
	}
	
	public static void straightMergeSort(int[] A) {
		
	}
	
	public static void naturalMergeSort(int[] A) {
		
	}

	// QUICK SORT O(nlog(n))
	public static void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}
	
	public static void quickSort(int[] A, int l, int r) {
		if (l < r) {
			int pivotIndex = partition(A, l, r);
			quickSort(A, l, pivotIndex - 1);
			quickSort(A, pivotIndex + 1, r);
		}
	}
	
	public static int partition(int[] A, int l, int r) {
		int i = l;
		int j = r;
		int pivot = A[r];
		
		while (i < j) {
			while (i < j && A[i] <= pivot) {
				i++;
			}
			while (j > i && A[j] > pivot) {
				j--;
			}
			if (A[i] > A[j]) {
				swap(i, j, A);
			}
		}
		
		if (A[i] > pivot) {
			swap(i, r, A);
		} else {
			i = r;
		}
		return i;
	}
}











































