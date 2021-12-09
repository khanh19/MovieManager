import java.util.LinkedList;

public class FreeBlock {
    private LinkedList<Integer> positionList;
    private int blockSize;

    public FreeBlock(int blockSize) {
        this.blockSize = blockSize;
        this.positionList = new LinkedList<Integer>();
    }

    public LinkedList<Integer> getPositionList() {
        return this.positionList;
    }

    public void setPositionList(LinkedList<Integer> positionList) {
        this.positionList = positionList;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public boolean insertFreeBlock(int position, int bsize) {

        return true;
    }

    public void sortPositionList() {
        //

    }

}
