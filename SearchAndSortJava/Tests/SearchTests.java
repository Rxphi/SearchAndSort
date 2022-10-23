import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SearchTests {
	
	@Test
	void unorderedArrays() {
		assertEquals(-1, SearchAndSort.findIndex(0, null));
		assertEquals(3, SearchAndSort.findIndex(-5, new int[] {12,-432,123,-5,123}));
		assertEquals(1, SearchAndSort.findIndex(69, new int[] {-63,69,420,42,1000,-500}));
		assertEquals(-1, SearchAndSort.findIndex(1000, new int[] {25,-673,143,-230}));
		assertEquals(3, SearchAndSort.findIndex(4, new int[] {1,2,3,4}));
		assertEquals(5, SearchAndSort.findIndex(4, new int[] {9,8,7,6,5,4}));
		assertEquals(4, SearchAndSort.findIndex(-634, new int[] {123,-745,-6342,2134,-634}));
		assertEquals(0, SearchAndSort.findIndex(523, new int[] {523,-1243,5376,745,-21}));
	}

	@Test
	void increasingArrays() {
		assertEquals(6, SearchAndSort.incBinarySearch(7, new int[] {1,2,3,4,5,6}, 0, 5));
		assertEquals(0, SearchAndSort.incBinarySearch(7, new int[] {}, 0, 0));
		assertEquals(1, SearchAndSort.incBinarySearch(7, new int[] {5}, 0, 0));
		assertEquals(0, SearchAndSort.incBinarySearch(69, new int[] {69}, 0, 0));
		assertEquals(6, SearchAndSort.incBinarySearch(7, new int[] {1,2,3,4,5,6,7}, 0, 7));
		assertEquals(3, SearchAndSort.incBinarySearch(42, new int[] {1,2,3,42}, 0, 3));
		assertEquals(5, SearchAndSort.incBinarySearch(420, new int[] {1,2,3,4,6,420}, 0, 5));
		assertEquals(6, SearchAndSort.incBinarySearch(100, new int[] {1,2,3,4,5,6}, 0, 5));
		assertEquals(0, SearchAndSort.incBinarySearch(21, new int[] {21, 21, 23, 54, 97}, 0, 4));
		assertEquals(3, SearchAndSort.incBinarySearch(32, new int[] {-10,-5,0,32}, 0, 3));
		assertEquals(4, SearchAndSort.incBinarySearch(14235, new int[] {1,634,5387,9000,14235}, 0, 4));
		
	}
	
	@Test
	void decreasingArrays() {
		assertEquals(0, SearchAndSort.decBinarySearch(0, new int[] {}, 0, 0));
		assertEquals(0, SearchAndSort.decBinarySearch(0, new int[] {0}, 0, 0));
		assertEquals(0, SearchAndSort.decBinarySearch(100, new int[] {69}, 0, 0));
		assertEquals(1, SearchAndSort.decBinarySearch(50, new int[] {69}, 0, 0));
		assertEquals(0, SearchAndSort.decBinarySearch(50, new int[] {20,10,5}, 0, 2));
		assertEquals(4, SearchAndSort.decBinarySearch(1, new int[] {30,20,10,5}, 0, 3));
		assertEquals(2, SearchAndSort.decBinarySearch(60, new int[] {100,80,60,50}, 0, 3));
		assertEquals(0, SearchAndSort.decBinarySearch(100, new int[] {100,80,50}, 0, 2));
		assertEquals(3, SearchAndSort.decBinarySearch(3, new int[] {6,5,4,3,2,1}, 0, 5));
		assertEquals(3, SearchAndSort.decBinarySearch(-75, new int[] {100,50,25,-75,-100}, 0, 5));
		assertEquals(2, SearchAndSort.decBinarySearch(-10001, new int[] {10000,-10000,-10001,-10002}, 0, 4));
	}

}
