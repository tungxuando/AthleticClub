public class Track {
    private TrackType type;

    public Track(TrackType type) {
        this.type = type;
    }

    public TrackType getType() {
        return this.type;
    }

    public void setType(TrackType type){
        this.type = type;
    }
}