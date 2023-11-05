import java.util.ArrayList;

public class Track {
    private final TrackType type;
    private final ArrayList<Lap> records;

    public Track(TrackType type) {
        this.type = type;
        this.records = new ArrayList<>();
    }

    public void addLapTime(Lap lap) {
        if (lap.getTrack().getType() != this.type) {
            throw new IllegalArgumentException("Lap track type is not the same as the track type");
        }
        this.records.add(lap);
        lap.getAthlete().addPersonalLap(lap);
    }

    public Athlete getFastestAthlete() {
        Athlete fastestAthlete = null;
        int fastestTime = Integer.MAX_VALUE;

        for (Lap lap : this.records) {
            if (lap.getDuration() < fastestTime) {
                fastestAthlete = lap.getAthlete();
            }
        }

        return fastestAthlete;
    }

    public int getFastestLapTime() {
        int fastestTime = Integer.MAX_VALUE;

        for (Lap lap : this.records) {
            if (lap.getDuration() < fastestTime) {
                fastestTime = lap.getDuration();
            }
        }

        return fastestTime;
    }

    public String getFastestAthleteAndLapTime() {
        String result = "";
        Athlete fastestAthlete = this.getFastestAthlete();

        if (fastestAthlete != null) {
            result = "The fastest athlete is " + fastestAthlete.getName() + " with PR on " + this.type + " of: " + this.getFastestLapTime() + " seconds";
        }

        return result;
    }

    public TrackType getType() {
        return this.type;
    }

    public ArrayList<Lap> getRecords() {
        return this.records;
    }
}