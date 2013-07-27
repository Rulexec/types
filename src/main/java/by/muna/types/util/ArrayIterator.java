package by.muna.types.util;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int length;
    private int pos;

    public ArrayIterator(T[] array) {
        this(array, 0);
    }
    public ArrayIterator(T[] array, int offset) {
        this(array, offset, array.length - offset);
    }
    public ArrayIterator(T[] array, int offset, int length) {
        this.array = array;
        this.length = length;
        
        this.pos = offset;
    }
    
    @Override
    public boolean hasNext() {
        return this.pos < this.length;
    }
    
    @Override
    public T next() {
        return this.array[this.pos++];
    }
    
    @Override
    public void remove() {}
}