import java.util.*;
import java.util.HashMap;

/** Hash table implementation using chaining.
 *   @author Koffman and Wolfgang
 * */

public class HashTableChaining < K, V > extends HashMap<K,V> {
    /** The table */
    Entry <K,V> [] table;

    /** The number of keys */
    private int numKeys;

    /** The capacity */
    private static final int CAPACITY = 101;

    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    /** Contains key-value pairs for a hash table. */
    private static class Entry < K, V > {

        /** The next object to keep the every same keys value*/
        private Entry<K,V> next = null;

        /** The key */
        private K key;

        /** The value */
        private V value;

        public Entry(){
            this.key = null;
            this.value = null;
        }

        /** Creates a new key-value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        public void addFirst(Entry<K, V> kvEntry) {
            while(next != null){
                next = next.next;
            }
            next = kvEntry;
        }
    }

    // No parameter constructor
    public HashTableChaining() {
        table = new Entry[CAPACITY];
    }

    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.

        Entry<K,V> temp = table[index];
        // Search the list at table[index] to find the key.
        while(temp.next != null){
            if (temp.next.key.equals(key))
                return temp.next.value;
            else {
                temp = temp.next;
            }
        }
        // assert: key is not in the table.
        return null;
    }

    /** Method put for class HashtableChain.
     post: This key-value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            table[index] = new Entry<K,V>(key,value);
            numKeys++;
        }
        else{
            Entry<K,V> temp = table[index];
            // Search the list at table[index] to find the key.
            while(temp.next != null) {
                temp = temp.next;
            }
            if (temp.next == null)
                table[index].addFirst(new Entry<K, V>(key,value));
        }
        // assert: key is not in the table, add new item.
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;
    }

    /** Method remove for class HashtableChain
     @param  key
     @return V type exactly removed value
     */
    public V remove(Object key){
        int index = key.hashCode() % table.length;

        if(index < 0)
            index += table.length;

        if (table[index] == null)
            return null;

        Entry<K,V> temp = table[index];
        // Search the list at table[index] to find the key.
        while(temp.next != null){
            if (temp.next.key.equals(key)){
                V oldVal = temp.next.value;
                table[index] = null;
                --numKeys;
                return oldVal;
            }
            temp = temp.next;
        }
        return null;
    }

     /**
     /*Private rehash method. If numKeys greater than the table length multiplying to
      /*Load factor it rehash the size of the table*/
    private void rehash() {
        // Save a reference to oldTable.
        Entry <K,V> [] oldTable = table;
        // Double capacity of this table.
        table = new Entry[2 * oldTable.length + 1];
        // Reinsert all items in oldTable into expanded table.
        int size = 0;
        while (size < numKeys){
            Entry<K,V> temp = oldTable[size];
            while(temp.next != null) {
                put(temp.next.key,temp.next.value);
                temp = temp.next;
            }
            size++;
        }
    }

    /** Returns the number of entries in the map */
    public int size() {
        return numKeys;
    }

    /** Returns true if empty */
    public boolean isEmpty() {
        return numKeys == 0;
    }

}
