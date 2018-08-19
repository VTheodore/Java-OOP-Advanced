package EnumsAndAnnotations.p02;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    List<Message> messages;

    private Importance importance;

    public Logger(String importance) {
        this.messages = new ArrayList<>();
        this.importance = Enum.valueOf(Importance.class, importance.toUpperCase());
    }

    public void recordMessages(String importance, String notes){
        Message message = new Message(importance, notes);

        if (Integer.compare(message.getImportanceOrdinal(), this.importance.ordinal()) >= 0){
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }
}
