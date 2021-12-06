public class HashTable<K extends Comparable<K>, V> {
    private KVPair<K, V>[] table;
    private int currSize;
    private int hashSize;

    @SuppressWarnings("unchecked")
    public HashTable(int hashsize) {
        this.hashSize = hashsize;
        this.currSize = 0;
        this.table = new KVPair[hashsize];
    }

    public KVPair<K, V>[] getTable() {
        return this.table;
    }

    public void setTable(KVPair<K, V>[] table) {
        this.table = table;
    }

    public int getCurrSize() {
        return this.currSize;
    }

    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }

    public int getHashSize() {
        return this.hashSize;
    }

    public void setHashSize(int hashSize) {
        this.hashSize = hashSize;
    }

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
        System.out.println("|" + key + "| is added to the Name database.");
        return true;
    }

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

}
