package EnumsAndAnnotations.p01;

import java.util.ArrayList;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> weeklySchedule;

    public WeeklyCalendar() {
        this.weeklySchedule = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes){
        WeeklyEntry weekEntry = new WeeklyEntry(weekday, notes);

        this.weeklySchedule.add(weekEntry);
    }

    public Iterable<WeeklyEntry> getWeeklySchedule(){
        this.weeklySchedule.sort(new WeekEntryComp());

        return this.weeklySchedule;
    }
}
