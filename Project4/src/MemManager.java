import java.util.ArrayList;

public class MemManager {

    private int poolsize;
    private byte[] pool;
    private ArrayList<FreeBlock> freeList;

    public MemManager(int poolsize) {
        this.poolsize = poolsize;
        this.pool = new byte[poolsize];
        FreeBlock newB = new FreeBlock(poolsize);
        freeList = new ArrayList<>();
        newB.getPositionList().add(0);
        freeList.add(newB);
    }

    // Insert a record and return its position handle.

    // space contains the record to be inserted, of length size.

    /**
     * 
     * @param space byte array that store record
     * @param size  record's size
     * @returna handle hoding size and location
     */
    public Handle insert(byte[] space, int size) {
        // define block size of record
        int bSize = 1;
        for (int i = 0; Math.pow(2, i) < size; i++) {
            bSize = (int) Math.pow(2, i);
        }

        return null;
    }

    // Return the length of the record associated with theHandle

    public int length(Handle theHandle) {
        return theHandle.getLen();
    }

    // Free a block at the position specified by theHandle.

    // Merge adjacent free blocks.

    public void remove(Handle theHandle) {

    }

    // Return the record with handle posHandle, up to size bytes, by

    // copying it into space.

    // Return the number of bytes actually copied into space.

    public int get(byte[] space, Handle theHandle, int size) {
        return 0;
    }

    // Dump a printout of the freeblock list

    public void dump() {

    }

    public int getPoolsize() {
        return this.poolsize;
    }

    public void setPoolsize(int poolsize) {
        this.poolsize = poolsize;
    }

    public byte[] getPool() {
        return this.pool;
    }

    public void setPool(byte[] pool) {
        this.pool = pool;
    }

    // ------------------Helper Function-----------------

    /**
     * split freeblock until fit the given size
     * 
     * @param requiredSize given size
     * @param free         is free block
     */
    private void splitBlock(int requiredSize, FreeBlock free) {
        // noted check again
        int position = free.getPositionList().getFirst();
        int size = free.getBlockSize();
        do {
            detachBlock(position, size);
            size = size / 2;
            insertBlock(position, size);
            insertBlock(position + size, size);
        } while (requiredSize != size);
    }

    /**
     * insert freeblock
     * 
     * @param position  is the position to add
     * @param blockSize is the size of the block
     * @return true or false
     */
    private boolean insertBlock(int position, int blockSize) {
        boolean check = false;
        for (FreeBlock blocker : freeList) {
            if (blocker.getBlockSize() == blockSize) {
                blocker.getPositionList().add(position);
                check = true;
                break;
            }
        }
        FreeBlock newer = new FreeBlock(blockSize);
        newer.getPositionList().add(position);
        freeList.add(newer);
        check = true;
        return check;
    }

    /**
     * to remove freeblock
     * 
     * @param position  is the position to add
     * @param blockSize is the size of the block
     * @return true or false
     */
    private boolean detachBlock(int position, int blockSize) {
        for (FreeBlock blocker : freeList) {
            if (blocker.getBlockSize() == blockSize) {
                blocker.getPositionList().remove(position);
                if (blocker.getPositionList().isEmpty()) {
                    freeList.remove(blocker);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * locate the block to location that fit
     * the size
     * 
     * @param size is the given size
     * @return location
     */
    private int allocateBlock(int size) {
        int location = 0;
        return location;
    }

}