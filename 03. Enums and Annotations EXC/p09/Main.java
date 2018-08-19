package EnumsAndAnnotationsEXC.p09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String[] cmdArgs = in.readLine().split("\\s+");
        TrafficLightsManager tlm = new TrafficLightsManager(cmdArgs);

        int numberOfUpdates = Integer.parseInt(in.readLine());

        for (int i = 0; i < numberOfUpdates; i++) {
            System.out.println(tlm.updateTrafficLight());
        }
    }
}
