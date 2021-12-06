import student.TestCase;

public class HashTableTest extends TestCase {
    private HashTable<String, Handle> hashtable;

    public void setUp() {
        this.hashtable = new HashTable<>(10);
    }

    public void testBasic() {
        assertEquals(10, hashtable.getHashSize());
        assertEquals(0, hashtable.getCurrSize());
    }

    public void testAdd() {
        this.hashtable.add("khanhcuong", new Handle(0));
        this.hashtable.add("khanhoutplay", new Handle(5));
        this.hashtable.add("khanhcuong", new Handle(0));
        this.hashtable.add("khanhoutplay", new Handle(5));
        assertEquals(this.hashtable.getCurrSize(), 2);
        this.hashtable.delete("khanhoutplay");
        assertEquals(this.hashtable.getCurrSize(), 1);
        assertNotNull(this.hashtable.get("khanhcuong"));
        assertNull(this.hashtable.get("khanh"));
        this.hashtable.add("khanh", new Handle(0));
        this.hashtable.add("khanhcu", new Handle(0));
        this.hashtable.add("khanhcuo", new Handle(0));
        this.hashtable.add("khanhc", new Handle(0));
        this.hashtable.add("khanh1", new Handle(0));
        this.hashtable.add("khanhpro", new Handle(0));
        this.hashtable.add("khanhvip", new Handle(0));
        assertEquals(20, hashtable.getHashSize());

    }

}
