// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * This is the handle function
 * 
 * @author Khanh Pham
 * @author Cuong Pham
 * @version 12/9/2021
 *
 */
public class Handle {
    private int position;
    private int len;

    /**
     * Default constructor
     * 
     * @param len
     *            the length of handle
     * @param position
     *            the position of handle
     */
    public Handle(int len, int position) {
        this.len = len;
        this.position = position;
    }


    /**
     * This function will get the position
     * 
     * @return the position of handle
     */
    public int getPosition() {
        return this.position;
    }


    /**
     * This function will set the position of the handle
     * 
     * @param position
     *            the position of the handle
     */
    public void setPosition(int position) {
        this.position = position;
    }


    /**
     * This function will get the length of handle
     * 
     * @return the length of handle
     */
    public int getLen() {
        return this.len;
    }


    /**
     * This function will set the length of the handle
     * 
     * @param len
     *            the length of handle
     */
    public void setLen(int len) {
        this.len = len;
    }
}
