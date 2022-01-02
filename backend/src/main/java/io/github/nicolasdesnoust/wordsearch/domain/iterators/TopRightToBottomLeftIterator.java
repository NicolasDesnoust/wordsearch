package io.github.nicolasdesnoust.wordsearch.domain.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import io.github.nicolasdesnoust.wordsearch.domain.Grid;

public class TopRightToBottomLeftIterator implements Iterator<String> {

    private final Grid grid;
    private int diagonalIndex;

    public TopRightToBottomLeftIterator(Grid grid) {
        this.grid = grid;
        this.diagonalIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return diagonalIndex < grid.getWidth() + grid.getHeight() - 2;
    }

    @Override
    public String next() {
        if (hasNext()) {
            String currentline = "";
            for (int j = diagonalIndex; j >= 0; j--) {
                int i = diagonalIndex - j;
                if (i < grid.getHeight() && j < grid.getWidth()) {
                    currentline += grid.getLetters()[i][j];
                }
            }
            diagonalIndex++;

            return currentline;
        } else {
            throw new NoSuchElementException();
        }
    }
}