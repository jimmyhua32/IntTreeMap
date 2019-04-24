import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class IntTreeMap<K extends Integer, V> implements SortedMap {

    private IntTreeNode overallRoot;
    private Set<Integer> keySet;

    public void put(Integer key, V value) {
        keySet.add(key);
        overallRoot = put(overallRoot, key, value);
    }

    //TODO: AVL rotation
    private IntTreeNode put(IntTreeNode node, Integer key, V value) {
        if (node == null) {
            return new IntTreeNode(key, value);
        } else if (key.equals(node.key)) {
            node.data = value;
            return node;
        }
        if (Integer.valueOf(key) > Integer.valueOf(node.key)) {
            node.right = put(node.right, key, value);
        } else {
            node.left = put(node.left, key, value);
        }
        return node;
    }

    public int size() {
        return keySet.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    // public boolean containsKey(Object key) {
    //     return keySet.contains(key);
    // }

    public boolean containsValue(Object value) {
    }

    public V get(Object k) {

    }

    public Comparator<V> comparator() {

    }

    public IntTreeMap<K, V> subMap(K fromKey, K toKey) {

    }

    private class IntTreeNode<E> {
        IntTreeNode left;
        IntTreeNode right;
        Integer key;
        E data;

        public IntTreeNode() {
            this(null, null, null, null);
        }

        public IntTreeNode(IntTreeNode left, IntTreeNode right, Integer key, T data) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.data = data;
        }

        public IntTreeNode(Integer key, T data) {
            this(null, null, key, data);
        }
    }
}
