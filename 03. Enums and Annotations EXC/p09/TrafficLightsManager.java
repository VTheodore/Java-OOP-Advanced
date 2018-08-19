package EnumsAndAnnotationsEXC.p09;

public class TrafficLightsManager {
    private TrafficLight[] trafficLights;

    public TrafficLightsManager(String... trafficLights) {
        this.setTrafficLights(trafficLights);
    }

    public String updateTrafficLight() {
        for (int i = 0; i < this.trafficLights.length; i++) {
            trafficLights[i] = this.changeLight(trafficLights[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (TrafficLight trafficLight : trafficLights) {
            sb.append(trafficLight).append(" ");
        }

        return sb.toString();
    }

    private TrafficLight changeLight(TrafficLight trafficLight) {
        if ("RED".equals(trafficLight.name())) {
            trafficLight = TrafficLight.GREEN;
        } else if ("GREEN".equals(trafficLight.name())) {
            trafficLight = TrafficLight.YELLOW;
        } else if ("YELLOW".equals(trafficLight.name())) {
            trafficLight = TrafficLight.RED;
        }

        return trafficLight;
    }

    private void setTrafficLights(String... trafficLights) {
        this.trafficLights = new TrafficLight[trafficLights.length];

        for (int i = 0; i < this.trafficLights.length; i++) {
            this.trafficLights[i] = TrafficLight.valueOf(trafficLights[i].toUpperCase());
        }
    }
}
