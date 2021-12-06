// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * KVPair class
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 10/20/2021
 * @param <K>
 *            the key
 * @param <E>
 *            the element
 */

public class KVPair<K extends Comparable<K>, E>
        implements

        Comparable<KVPair<K, E>> {
    private K key;
    private E value;

    /**
     * Constructor that takes key and value parameter
     * 
     * @param key
     *              the key of KVPair
     * @param value
     *              the value of KVPair
     */
    public KVPair(K key, E value) {

        this.key = key;

        this.value = value;

    }

    /**
     * method to get the key
     * 
     * @return the key
     */

    public K getKey() {
        return this.key;
    }

    /**
     * method to set the rectangle's key
     * 
     * @param key
     *            rectangle's key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * method to get the value
     * 
     * @return the value
     */
    public E getValue() {
        return this.value;
    }

    /**
     * method to set the rectangle's value
     * 
     * @param value
     *              that user want to set
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * method to compare two KVPair's object
     * 
     * @param object
     *               object the rectangle object
     * @return the number
     */
    public int compareTo(KVPair<K, E> object) {

        return this.getKey().compareTo(object.getKey());
    }

    /**
     * method to compare two KVPair's key
     * 
     * @param key1
     *             the key of rectangle
     * @return the number
     */
    public int compareTo(K key1) {
        return this.key.compareTo(key1);
    }

    /**
     * method to get details of key and value
     * 
     * @return the details
     */
    public String toString() {
        return key.toString() + " " + value.toString();
    }

}
