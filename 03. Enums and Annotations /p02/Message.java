package EnumsAndAnnotations.p02;

public class Message {
    private Importance importance;

    private String notes;

    public Message(String importance, String notes) {
        this.setImportance(importance);
        this.setNotes(notes);
    }

    private void setImportance(String importance) {
        this.importance = Enum.valueOf(Importance.class, importance.toUpperCase());
    }

    private void setNotes(String notes) {
        this.notes = notes;
    }

    public Importance getImportance() {
        return this.importance;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.importance.name(), this.notes);
    }

    public int getImportanceOrdinal() {
        return this.importance.ordinal();
    }
}
