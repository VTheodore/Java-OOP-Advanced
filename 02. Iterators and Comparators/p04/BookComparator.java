package IteratorsAndComparators.p04;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getTitle().compareTo(o2.getTitle()) > 0){
            return 1;
        }else if (o1.getTitle().compareTo(o2.getTitle()) < 0){
            return -1;
        }

        if (o1.getYear() - o2.getYear() > 0 ){
            return 1;
        }else if (o1.getYear() - o2.getYear() < 0){
            return -1;
        }

        return 0;
    }
}
