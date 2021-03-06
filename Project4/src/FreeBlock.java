
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)
import java.util.LinkedList;

/**
 * this function will check free block
 * 
 * @author Cuong Pham
 * @author Khanh Pham
 * @version 12/9/2021
 *
 */
public class FreeBlock {
    private LinkedList<Integer> positionList;
    private int blockSize;

    /**
     * default constructor
     * 
     * @param blockSize the size of block
     */
    public FreeBlock(int blockSize) {
        this.blockSize = blockSize;
        this.positionList = new LinkedList<Integer>();
    }

    /**
     * This function will get the position of the list
     * 
     * @return the list
     */
    public LinkedList<Integer> getPositionList() {
        return this.positionList;
    }

    /**
     * This function will set the list
     * 
     * @param positionList the list that we want to set
     */
    public void setPositionList(LinkedList<Integer> positionList) {
        this.positionList = positionList;
    }

    /**
     * This function will get the size of the block
     * 
     * @return
     */
    public int getBlockSize() {
        return this.blockSize;
    }

    /**
     * this function will set the block size
     * 
     * @param blockSize the size of block
     */
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    /**
     * This function will set the list at position
     */
    public void sortPositionList() {
        LinkedList<Integer> lister = new LinkedList<Integer>();
        while (this.getPositionList().size() > 0) {
            int val = this.positionList.get(0);
            int k = 0;
            while (k < this.positionList.size()) {
                if (val > this.getPositionList().get(k)) {
                    val = this.getPositionList().get(k);
                }
                k++;
            }
            this.getPositionList().remove((Object)val);
            lister.add(val);
        }
        this.setPositionList(lister);

    }

}
