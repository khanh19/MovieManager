// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

/**
 * this is the HashTable class
 * 
 * @author Cuong Pham
 * @author Khanh Pham
 * @version 12/9/2021
 *
 * @param <K> the key of hash table
 * @param <V> the value of hash table
 */
public class HashTable<K extends Comparable<K>, V> {
    private KVPair<K, V>[] table;
    private int currSize;
    private int hashSize;

    /**
     * Default constructor
     * 
     * @param hashsize the size of hash table
     */
    @SuppressWarnings("unchecked")
    public HashTable(int hashsize) {
        this.hashSize = hashsize;
        this.currSize = 0;
        this.table = new KVPair[hashsize];
    }

    /**
     * this will get the table
     * 
     * @return the table
     */
    public KVPair<K, V>[] getTable() {
        return this.table;
    }

    /**
     * this will set the table in hash
     * 
     * @param table the hash table
     */
    public void setTable(KVPair<K, V>[] table) {
        this.table = table;
    }

    /**
     * this will get the current size
     * 
     * @return the current size
     */
    public int getCurrSize() {
        return this.currSize;
    }

    /**
     * this will set the current size of the hash table
     * 
     * @param currSize the size of current hash
     */
    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }

    /**
     * this will get the size of hash
     * 
     * @return the size of hash table
     */
    public int getHashSize() {
        return this.hashSize;
    }

    /**
     * this will set the size of hash table
     * 
     * @param hashSize
     */
    public void setHashSize(int hashSize) {
        this.hashSize = hashSize;
    }

    /**
     * this will get the value of hash table at key
     * 
     * @param key the key of hash
     * @return value of hash table
     */
    public V get(K key) {
        Hash hashfunc = new Hash();
        int hash = hashfunc.h((String) key, hashSize);
        int position = hash;
        int i = 1;
        while (table[position] != null) {
            if (this.table[position].getKey().compareTo(key) == 0 && this.table[position].getKey() != null) {
                return this.table[position].getValue();
            }
            position = (hash + i * i) % hashSize;
            i++;
        }
        return null;
    }

    /**
     * this function will help to add table into the hash
     * 
     * @param key   the key of table
     * @param value the value of table
     * @return true if we can add, otherwise false
     */
    public boolean add(K key, V value) {
        if (currSize + 1 > hashSize / 2) {
            rehash();
        }
        KVPair<K, V> element = new KVPair<K, V>(key, value);
        Hash hashfunc = new Hash();
        int hash = hashfunc.h((String) key, hashSize);
        int position = hash;
        int i = 1;
        while (table[position] != null) {
            if (this.table[position].getKey() == null) {
                break;
            }
            if (this.table[position].getKey().compareTo(key) == 0) {
                System.out.println("|" + key + "| duplicates a record already in the Name database.");
                return false;
            }
            position = (hash + i * i) % hashSize;
            i++;
        }
        table[position] = element;
        currSize++;
        System.out.println("|" + key + "| has been added to the Name database.");
        return true;
    }

    /**
     * this function will delete the table by key
     * 
     * @param key the key of table
     * @return table remove
     */
    public V delete(K key) {
        KVPair<K, V> deleted = new KVPair<K, V>(null, null);
        Hash hashfunc = new Hash();
        int hash = hashfunc.h((String) key, hashSize);
        int position = hash;
        int i = 1;
        while (table[position] != null) {
            if (this.table[position].getKey().compareTo(key) == 0 && this.table[position].getKey() != null) {
                V ele = this.table[position].getValue();
                this.table[position] = deleted;
                currSize -= 1;
                System.out.println("|" + key + "| has been deleted from the Name database.");
                return ele;
            }
            position = (hash + i * i) % hashSize;
            i++;
        }
        System.out.println("|" + key + "| not deleted because it does not exist in the Name database.");
        return null;
    }

    /**
     * this function will rehash the table
     */
    @SuppressWarnings("unchecked")
    public void rehash() {
        this.hashSize = this.hashSize * 2;
        KVPair<K, V>[] newTable = new KVPair[this.hashSize];
        for (int i = 0; i < hashSize / 2; i++) {
            if (this.table[i] != null && this.table[i].getKey() != null) {
                Hash hashfunc = new Hash();
                int hash = hashfunc.h((String) this.table[i].getKey(), hashSize);
                int position = hash;
                int j = 1;
                while (newTable[position] != null) {
                    position = (hash + j * j) % hashSize;
                    j++;
                }
                newTable[position] = this.table[i];
            }
        }
        this.table = newTable;
        System.out.println("Name hash table size doubled to " + hashSize + " slots.");
    }

    public void dump() {
        for (int i = 0; i < this.hashSize; i++) {
            if (this.table[i] != null && this.table[i].getKey() != null) {
                System.out.println("|" + this.table[i].getKey() + "|" + i);
            }
        }
        System.out.println("Total records: " + this.currSize);
    }

}
