
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * this is the memory manager class
 * 
 * @author Cuong Pham
 * @author Khanh Pham
 * @version 12/9/2021
 *
 */
public class MemManager {

    private int poolsize;
    private byte[] pool;
    private ArrayList<FreeBlock> freeList;

    public MemManager(int poolsize) {
        if (poolsize <= 0) {
            this.poolsize = 1;
        } else {
            this.poolsize = poolsize;
        }
        this.pool = new byte[poolsize];
        FreeBlock newB = new FreeBlock(poolsize);
        freeList = new ArrayList<>();
        newB.getPositionList().add(0);
        freeList.add(newB);
    }

    /**
     * 
     * @param space byte array that store record
     * @param size  record's size
     * @returna handle hoding size and location
     */
    public Handle insert(byte[] space, int size) {
        // define block size of record
        int bSize = 0;
        for (int i = 0; Math.pow(2, i) < size; i++) {
            bSize = (int) Math.pow(2, i);
        }
        int bloca = allocateBlock(bSize);
        int j = 0;
        while (j < size) {
            pool[bloca + j] = space[j];
            j++;
        }
        detachBlock(bloca, bSize);
        Handle hd = new Handle(size, bloca);
        sortOuter();
        return hd;

    }
    // Return the length of the record associated with theHandle

    /**
     * to get length
     * 
     * @param theHandle is handle
     * @return
     */
    public int length(Handle theHandle) {
        return theHandle.getLen();
    }

    // Free a block at the position specified by theHandle.

    // Merge adjacent free blocks.

    public void remove(Handle theHandle) {
        int bSize = 0;
        for (int i = 0; Math.pow(2, i) < theHandle.getLen(); i++) {
            bSize = (int) Math.pow(2, i);
        }
        int posit = theHandle.getPosition();
        for (int i = posit; i < posit + bSize; i++) {
            pool[i] = 0;
        }
        insertBlock(posit, bSize);
        merge();
        sortOuter();
    }

    public int get(byte[] space, Handle theHandle, int size) {
        return 0;
    }

    /**
     * Dump a printout of the freeblock list
     */
    public void dump() {
        if (!(freeList.isEmpty())) {
            int count = 0;
            while (count < freeList.size()) {
                StringBuilder str = new StringBuilder();
                LinkedList<Integer> lList = freeList.get(count).getPositionList();
                int bsize = freeList.get(count).getBlockSize();
                str.append(bsize);
                str.append(":");
                int k = 0;
                while (k < lList.size()) {
                    str.append(" ");
                    str.append(lList.get(k));
                    k++;
                }
                if (!(count != 0 || freeList.size() <= 1)) {
                    str.append(" ");
                }
                count++;
                System.out.println(str.toString());
            }
        } else {
            System.out.println("No free blocks are available.");
        }
    }

    /**
     * to get list
     * 
     * @return a list
     */
    public ArrayList<FreeBlock> getFreeList() {
        return this.freeList;
    }

    /**
     * to set list
     * 
     * @param freeList is a list
     */
    public void setFreeList(ArrayList<FreeBlock> freeList) {
        this.freeList = freeList;
    }

    /**
     * to get pool size
     * 
     * @return integer
     */
    public int getPoolsize() {
        return this.poolsize;
    }

    /**
     * to set pool size
     * 
     * @param poolsize is size
     */
    public void setPoolsize(int poolsize) {
        this.poolsize = poolsize;
    }

    /**
     * to get pool
     * 
     * @return byte array
     */
    public byte[] getPool() {
        return this.pool;
    }

    /**
     * to set pool
     * 
     * @param pool new array
     */
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
        FreeBlock fb = null;
        for (int i = size; i <= poolsize; i = i * 2) {
            for (int k = 0; k < freeList.size(); k++) {
                if (freeList.get(k).getBlockSize() == i) {
                    fb = freeList.get(k);
                    k = freeList.size();
                    i = poolsize + 1;
                }
            }
        }
        if (fb == null) {
            // expand
            insertBlock(poolsize, poolsize);
            poolsize = 2 * poolsize;
            byte[] newP = new byte[poolsize];
            for (int i = 0; i < pool.length; i++) {
                newP[i] = pool[i];
            }
            this.setPool(newP);
            merge();
            // just to check delete later
            System.out.println("Memory pool expanded to be " + poolsize
                    + " bytes.");
            location = allocateBlock(size);
        } else {
            location = fb.getPositionList().getFirst();
            if (size < fb.getBlockSize()) {
                splitBlock(size, fb);
            }
        }
        return location;
    }

    /**
     * to merge unused blocks
     */
    private void merge() {
        int i = 0;
        boolean merge = false;
        while (i < freeList.size()) {
            sortOuter();
            int c = 0;
            LinkedList<Integer> lList = freeList.get(i).getPositionList();
            FreeBlock block = freeList.get(i);
            do {
                int posit = lList.get(c);
                int posit1 = lList.get(c + 1);
                int bSize = block.getBlockSize();
                int sum = bSize + posit;
                int bit = posit | bSize;
                int bit1 = bSize | posit1;
                if (!(sum != posit1 || bit != bit1)) {
                    insertBlock(posit, bSize * 2);
                    detachBlock(posit, bSize);
                    detachBlock(posit + bSize, bSize);
                    merge = true;
                }
                c++;
            } while (!((c > (lList.size() - 1)) || lList.size() <= 1));
            if (merge) {
                merge = false;
                i = -1;
            }
            i++;
        }
    }

    /**
     * sort in ascending order for outer list
     */
    private void sortOuter() {
        ArrayList<FreeBlock> lister = new ArrayList<FreeBlock>();
        while (freeList.size() > 0) {
            FreeBlock minBlock = freeList.get(0);
            int k = 0;
            while (k < freeList.size()) {
                freeList.get(k).sortPositionList();
                if (minBlock.getBlockSize() > freeList.get(k).getBlockSize()) {
                    minBlock = freeList.get(k);
                }
                k++;
            }
            lister.add(minBlock);
            freeList.remove(minBlock);
        }
        this.setFreeList(lister);
    }

}