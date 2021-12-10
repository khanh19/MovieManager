import student.TestCase;

public class MemManagerTest extends TestCase {
    private MemManager memPool;

    public void setUp() {
        memPool = new MemManager(32);
    }

    public void testMenManager() {
        assertEquals(memPool.getFreeList().get(0).getPositionList().size(), 1);
        String str = "Khanh Pro";
        Handle hd = memPool.insert(str.getBytes(), str.getBytes().length);
        assertFalse(memPool.getFreeList().isEmpty());
        assertEquals(str.getBytes().length, hd.getLen());
        assertEquals(1, memPool.getFreeList().size());
    }

}
