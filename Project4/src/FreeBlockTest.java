
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)
import java.util.LinkedList;

/**
 * this function will test the free block function
 * 
 * @author Cuong Pham
 * @author Khanh Pham
 * @version 12/9/2021
 *
 */
public class FreeBlockTest extends student.TestCase {
	private FreeBlock cuong;
	private FreeBlock cuong2;
	private LinkedList<Integer> position1;
	private LinkedList<Integer> position2;

	/**
	 * this function will set up the test case
	 */
	public void setUp() {
		cuong = new FreeBlock(50);
		cuong2 = new FreeBlock(100);
		position1 = new LinkedList<Integer>();
		position2 = new LinkedList<Integer>();
	}

	/**
	 * this function will test the block size
	 */
	public void testBlockSize() {
		assertEquals(50, cuong.getBlockSize());
		assertEquals(100, cuong2.getBlockSize());
		cuong.setBlockSize(60);
		cuong2.setBlockSize(110);
		assertEquals(60, cuong.getBlockSize());
		assertEquals(110, cuong2.getBlockSize());
		System.out.println(cuong2.getBlockSize());
	}

	/**
	 * this function will test the position of block
	 */
	public void testPosition() {
		cuong = new FreeBlock(2);
		position1.add(100);
		position2.add(1);
		cuong.setPositionList(position1);
		cuong.setPositionList(position2);
		assertEquals(position2, cuong.getPositionList());
		assertEquals(position2, cuong.getPositionList());
	}
}
