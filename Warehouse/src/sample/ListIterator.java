package sample;

import java.util.Iterator;

public class ListIterator<K> implements Iterator<K> {
    private WNode<K> pos;

    public ListIterator(WNode<K> node){pos = node; }

    @Override
    public boolean hasNext() {
        return pos != null;
    }

    @Override
    public K next() {
        WNode<K> temp = pos;
        pos = pos.next;
        return temp.getContents();
    }
}
