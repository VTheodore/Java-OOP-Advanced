package EnumsAndAnnotations.p01;

public class WeeklyEntry {
    private Weekday day;

    private String notes;

    public WeeklyEntry(String day, String notes) {
        this.day = Enum.valueOf(Weekday.class, day.toUpperCase());
        this.notes = notes;
    }

    public Weekday getDay() {
        return this.day;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.day.toString(), this.notes);
    }
}
