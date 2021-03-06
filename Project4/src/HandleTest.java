// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * This class will test the handle class
 * 
 * @author Khanh Pham
 * @author Cuong Pham
 * @version 12/9/2021
 *
 */
public class HandleTest extends student.TestCase {
	private Handle cuong;
	private Handle cuong2;

	/**
	 * This will set up all the test case
	 */
	public void setUp() {
		cuong = new Handle(5, 10);
		cuong2 = new Handle(15, 20);
	}

	/**
	 * this function will test position
	 */

	public void testPosision() {
		assertEquals(10, cuong.getPosition());
		assertEquals(20, cuong2.getPosition());
		cuong.setPosition(30);
		assertEquals(30, cuong.getPosition());
		cuong2.setPosition(90);
		assertEquals(90, cuong2.getPosition());
	}

	/**
	 * this function will test length of handle
	 */
	public void testLen() {
		assertEquals(5, cuong.getLen());
		assertEquals(15, cuong2.getLen());

		cuong2.setLen(25);
		assertEquals(25, cuong2.getLen());
		cuong.setLen(15);
		assertEquals(15, cuong.getLen());
	}
}
