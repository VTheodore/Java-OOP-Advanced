package IteratorsAndComparatorsEXC.p04;

import java.util.*;

public class Lake implements Iterable<Integer> {
    private List<Integer> collection;

    public Lake(Integer... items) {
        this.setCollection(items);
    }

    private void setCollection(Integer[] items) {
        this.collection = new ArrayList<>(Arrays.asList(items));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {
        private int cursor = -2;
        private boolean isFirstCycle = true;
        private final int COLLECTION_LENGTH = collection.size();


        @Override
        public boolean hasNext() {
            if (isFirstCycle) {
                if (cursor == COLLECTION_LENGTH - 1 || cursor == COLLECTION_LENGTH - 2) {
                    isFirstCycle = false;
                    cursor = -1;
                }
            } else {
                if (cursor == COLLECTION_LENGTH - 1 || cursor == COLLECTION_LENGTH - 2) {
                    return false;
                }
            }

            if (cursor == COLLECTION_LENGTH - 1 || cursor == COLLECTION_LENGTH - 2){
                return false;
            }
            return true;
        }

        @Override
        public Integer next() {
            return collection.get(cursor += 2);
        }
    }
}
