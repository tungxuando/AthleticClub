public class Lap {
    private Athlete athlete;
    private Track track;
    private int duration;

    public Lap(Athlete athlete, Track track, int duration) {
        this.athlete = athlete;
        this.duration = duration;

        if (track.getType() == TrackType.GRASS) {
            this.duration -= 5;
        }

        this.track = track;
    }

    public Athlete getAthlete() {
        return this.athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public int getSpeed() {
        return this.track.getType().getDistance() / this.duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Track getTrack() {
        return this.track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
