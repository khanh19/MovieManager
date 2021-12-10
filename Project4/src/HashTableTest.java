
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)
import student.TestCase;

/**
 * this class will test the hash table
 * 
 * @author Cuong Pham
 * @author Khanh Pham
 * @version 12/9/2021
 *
 */
public class HashTableTest extends TestCase {
    private HashTable<String, Handle> hashtable;

    /**
     * this function will set up the test case
     */
    public void setUp() {
        this.hashtable = new HashTable<>(12);
    }

    /**
     * this function will test some basic function
     */
    public void testBasic() {
        assertEquals(12, hashtable.getHashSize());
        assertEquals(0, hashtable.getCurrSize());
    }

    /**
     * this function will test all other function
     */
    public void testAdd() {
        this.hashtable.add("khanhcuong", new Handle(10, 0));
        this.hashtable.add("khanhoutplay", new Handle(12, 5));
        this.hashtable.add("khanhcuong", new Handle(10, 0));
        this.hashtable.add("khanhoutplay", new Handle(12, 5));
        assertEquals(this.hashtable.getCurrSize(), 2);
        this.hashtable.delete("khanhoutplay");
        assertEquals(this.hashtable.getCurrSize(), 1);
        assertNotNull(this.hashtable.get("khanhcuong"));
        assertNull(this.hashtable.get("khanh"));
        this.hashtable.add("khanh", new Handle(5, 0));
        this.hashtable.add("khanhcu", new Handle(7, 0));
        this.hashtable.add("khanhcuo", new Handle(8, 0));
        this.hashtable.add("khanhc", new Handle(6, 0));
        this.hashtable.add("khanh1", new Handle(6, 0));
        this.hashtable.add("khanhpro", new Handle(8, 0));
        this.hashtable.add("khanhvip", new Handle(8, 0));
        assertEquals(24, hashtable.getHashSize());
        hashtable.dump();
        assertEquals(
                "|khanhcuong| has been added to "
                        + "the Name database.\n" + "|khanhoutplay| "
                        + "has been added to the Name database.\n"
                        + "|khanhcuong| duplicates a record already in "
                        + "the Name database.\n"
                        + "|khanhoutplay| duplicates a record already "
                        + "in the Name database.\n"
                        + "|khanhoutplay| has been deleted from the "
                        + "Name database.\n"
                        + "|khanh| has been added to the Name database.\n"
                        + "|khanhcu| has been added to the Name database.\n"
                        + "|khanhcuo| has been added to the Name database.\n"
                        + "|khanhc| has been added to the Name database.\n"
                        + "|khanh1| has been added to the Name database.\n"
                        + "Name hash table size doubled to 24 slots.\n"
                        + "|khanhpro| has been added to the Name database.\n"
                        + "|khanhvip| has been added to the Name database.\n"
                        + "|khanhc|3\n" + "|khanh|4\n" + "|khanhcu|7\n"
                        + "|khanhcuong|9\n" + "|khanhvip|11\n"
                        + "|khanhcuo|12\n" + "|khanh1|19\n"
                        + "|khanhpro|20\n" + "Total records: 8\n",
                systemOut().getHistory());
    }

}
