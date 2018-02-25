/***
 * HashMap Interface
 * @param <K>
 * @param <V>
 */
public interface HashMap<K, V> {
    /**
     *
     * @param key
     * @return
     */
    V get(Object key);

    /**
     *
     * @param key
     * @param value
     * @return
     */
    V put(K key, V value);

    /**
     *
     * @param key
     * @return
     */
    V remove(Object key);

    /**
     *
     * @return
     */
    int size();

    /**
     *
     * @return
     */
    boolean isEmpty();
}
