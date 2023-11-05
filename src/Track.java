import java.util.HashMap;

public class Track {
    private final TrackType type;
    private int trackDistance;
    private HashMap<Athlete, Integer> trackRecords;

    public Track(TrackType type) {
        this.type = type;
        switch (type) {
            case GRASS -> trackDistance = 300;
            case GRAVEL -> trackDistance = 400;
        }
        this.trackRecords = new HashMap<>();
    }

    public HashMap<Athlete, Integer> getTrackRecords() {
        return this.trackRecords;
    }

    public void setTrackRecords(HashMap<Athlete, Integer> trackRecords) {
        this.trackRecords = trackRecords;
    }

    public TrackType getType() {
        return this.type;
    }

    public int getTrackDistance() {
        return this.trackDistance;
    }
}