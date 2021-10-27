package com.github.sharifulineugene;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayIterator<T> implements Iterator<T>{
    private T[][] array;
    public CustomArrayIterator(T[][] array) {
        this.array = array;
    }
    private int i_index = 0;
    private int j_index = 0;
    @Override
    public boolean hasNext() {
        return i_index < array.length && j_index < array[i_index].length;

    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        T temp = array[i_index][j_index];
        if(j_index == array[i_index].length-1) {
            i_index += 1;
            j_index = 0;
        } else {
            j_index += 1;
        }
        return temp;
    }

}
