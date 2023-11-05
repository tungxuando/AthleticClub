import java.util.ArrayList;

public class Athlete {
    private String name;
    private final ArrayList<Lap> personalRecords;

    public Athlete(String name) {
        this.name = name;
        this.personalRecords = new ArrayList<>();
    }

    public int getAverageTime() {
        return this.getTotalTime() / this.getTotalLap();
    }

    public void addPersonalLap(Lap lap) {
        this.personalRecords.add(lap);
    }

    public int getTotalTime() {
        int totalTime = 0;
        for (Lap lap : this.personalRecords) {
            totalTime = totalTime + lap.getDuration();
        }
        return totalTime;
    }

    public int getTotalLap() {
        return this.personalRecords.size();
    }

    public double getTotalDistance() {
        double totalDistance = 0;
        for (Lap lap : this.personalRecords) {
            totalDistance = totalDistance + lap.getTrack().getType().getDistance();
        }
        return totalDistance / 1000;
    }

    public int getMaxSpeed() {
        int maxSpeed = 0;
        for (Lap lap : this.personalRecords) {
            if (lap.getSpeed() > maxSpeed) {
                maxSpeed = lap.getSpeed();
            }
        }
        return maxSpeed;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
