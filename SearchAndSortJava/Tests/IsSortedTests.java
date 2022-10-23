import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsSortedTests {

	@Test
	void isSortedInc() {
		assertEquals(true, SearchAndSort.isSortedInc(null));
		assertEquals(true, SearchAndSort.isSortedInc(new int[] {1,1,1,1}));
		assertEquals(true, SearchAndSort.isSortedInc(new int[] {10,20,30,40}));
		assertEquals(true, SearchAndSort.isSortedInc(new int[] {10,20,20,20,50,50,50}));
		assertEquals(true, SearchAndSort.isSortedInc(new int[] {-1}));
		assertEquals(false, SearchAndSort.isSortedInc(new int[] {-1,0,1,2,3,45,44}));
		assertEquals(false, SearchAndSort.isSortedInc(new int[] {-100,50,50,50,-3}));
		assertEquals(false, SearchAndSort.isSortedInc(new int[] {-1,-1,-1,1,1,1,-1}));
		assertEquals(false, SearchAndSort.isSortedInc(new int[] {1000,1000,2300,2350,2349}));
	}

	void isSortedDec() {
		assertEquals(true, SearchAndSort.isSortedDec(null));
		assertEquals(true, SearchAndSort.isSortedDec(new int[] {500}));
		assertEquals(true, SearchAndSort.isSortedDec(new int[] {500,400,300,200,-500}));
		assertEquals(true, SearchAndSort.isSortedDec(new int[] {500,500,500}));
		assertEquals(true, SearchAndSort.isSortedDec(new int[] {9,8,7,6,5,4,3,3,3,3}));
		assertEquals(true, SearchAndSort.isSortedDec(new int[] {10,10,-20,-25,-1000}));
		assertEquals(false, SearchAndSort.isSortedDec(new int[] {1,1,1,1,-1,-1,-1,1}));
		assertEquals(false, SearchAndSort.isSortedDec(new int[] {5,5,5,5,-12,-20,4}));
		assertEquals(false, SearchAndSort.isSortedDec(new int[] {0,0,0,-1,-2,-3,-4,5}));
		assertEquals(false, SearchAndSort.isSortedDec(new int[] {6432,1200,795,87,50,50,51,52}));
	}
}
