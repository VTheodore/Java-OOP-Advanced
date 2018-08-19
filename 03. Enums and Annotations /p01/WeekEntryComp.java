package EnumsAndAnnotations.p01;

import java.util.Comparator;

public class WeekEntryComp implements Comparator<WeeklyEntry> {
    @Override
    public int compare(WeeklyEntry o1, WeeklyEntry o2) {
        if (o1.getDay().ordinal() - o2.getDay().ordinal() > 0){
            return 1;
        }else if (o1.getDay().ordinal() - o2.getDay().ordinal() < 0){
            return -1;
        }

        return 0;
    }
}
