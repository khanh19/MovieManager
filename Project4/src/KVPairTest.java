
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * class that test the method in KVPair
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 12/9/2021
 *
 */
public class KVPairTest extends student.TestCase {
	@SuppressWarnings("rawtypes")
	private KVPair rec;
	@SuppressWarnings("rawtypes")
	private KVPair rec1;
	@SuppressWarnings("rawtypes")
	private KVPair rec2;

	/**
	 * method to set up the test methods runs before every test method
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setUp() {
		rec = new KVPair("cuong", 15);
		rec1 = new KVPair("khanh", 20);
		rec2 = new KVPair("Giang", 25);
	}

	/**
	 * this will test all key function
	 */
	@SuppressWarnings("unchecked")
	public void testKey() {
		assertEquals("cuong", rec.getKey());
		assertEquals("khanh", rec1.getKey());
		assertEquals("Giang", rec2.getKey());
		rec.setKey("long");
		assertEquals("long", rec.getKey());
		rec1.setKey("test");
		assertEquals("test", rec1.getKey());
	}

	/**
	 * this will test value function
	 */
	@SuppressWarnings("unchecked")
	public void testValue() {
		assertEquals(15, rec.getValue());
		assertEquals(20, rec1.getValue());
		assertEquals(25, rec2.getValue());
		rec.setValue(20);
		assertEquals(20, rec.getValue());
		rec1.setValue(25);
		assertEquals(25, rec1.getValue());
	}

	/**
	 * this will test compare function
	 */
	@SuppressWarnings("unchecked")
	public void testCompare() {
		assertEquals(-8, rec.compareTo(rec1));
		assertEquals(8, rec1.compareTo(rec));
		assertEquals(0, rec.compareTo(rec));
		assertEquals("cuong 15", rec.toString());
		assertEquals("khanh 20", rec1.toString());
		assertEquals("Giang 25", rec2.toString());
	}
}
