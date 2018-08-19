package EnumsAndAnnotations.p02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String baseImportance = in.readLine();
        Logger logger = new Logger(baseImportance);

        String line;

        while (!"END".equals((line = in.readLine()))){
            String[] cmdArgs = line.split(": ");

            String importance = cmdArgs[0];
            String notes = cmdArgs[1];

            logger.recordMessages(importance, notes);
        }

        Iterable<Message> messages = logger.getMessages();

        for (Message message : messages) {
            System.out.println(message.toString());
        }
    }
}
