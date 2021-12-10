
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
 * @version 9/20/2021
 *
 */
public class KVPairTest extends student.TestCase {
    @SuppressWarnings("rawtypes")
    private KVPair rec;
    @SuppressWarnings("rawtypes")
    private KVPair rec1;
    @SuppressWarnings("rawtypes")
    private KVPair rec2;
    private Rectangle obRec;
    private Rectangle text;

    /**
     * method to set up the test methods
     * runs before every test method
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void setUp() {
        obRec = new Rectangle("cuong", 11, 10, 4, 5);
        text = new Rectangle("John", 10, 5, 4, 3);
        rec = new KVPair(obRec.getName(), obRec);
        rec1 = new KVPair(text.getName(), text);
        rec2 = new KVPair();
    }


    /**
     * method to test the get() method in KVPair;
     */
    public void testGet() {
        assertNull(rec2.getValue());
        assertNull(rec2.getKey());
        assertEquals("cuong", rec.getKey());
        assertEquals("(cuong, 11, 10, 4, 5)", rec.getValue().toString());
    }


    /**
     * method to test the set() method in KVPair;
     */
    @SuppressWarnings("unchecked")
    public void testSet() {
        rec.setKey("Khanh");
        assertEquals("Khanh", rec.getKey());
        rec.setValue(text);
        assertEquals("(John, 10, 5, 4, 3)", rec.getValue().toString());
        rec.setValue(obRec);
        assertEquals("(cuong, 11, 10, 4, 5)", rec.getValue().toString());
    }


    /**
     * method to test the compare() method in KVPair;
     */
    @SuppressWarnings("unchecked")
    public void testCompare() {
        assertEquals(25, rec.compareTo(rec1));
        assertEquals(-25, rec1.compareTo(rec));
        assertEquals(rec.getKey().toString() + " (cuong, 11, 10, 4, 5)", rec
            .toString());
        assertEquals(0, rec.compareTo(rec));
        assertEquals(25, rec.compareTo(rec1.getKey()));
        assertEquals(-25, rec1.compareTo(rec.getKey()));
    }
}
