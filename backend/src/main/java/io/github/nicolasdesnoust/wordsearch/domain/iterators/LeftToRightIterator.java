package io.github.nicolasdesnoust.wordsearch.domain.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import io.github.nicolasdesnoust.wordsearch.domain.Grid;

public class LeftToRightIterator implements Iterator<String> {
    
    private final Grid grid;
    private int currentLineIndex;

    public LeftToRightIterator(Grid grid) {
        this.grid = grid;
        this.currentLineIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentLineIndex < grid.getLetters().length;
    }

    @Override
    public String next() {        
        if(hasNext()) {
            return String.valueOf(grid.getLetters()[currentLineIndex++]);
        } else {
            throw new NoSuchElementException();
        }
    }

}