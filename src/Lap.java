public class Lap {
    private Athlete athlete;
    private Track track;
    private double time;

    public Lap(Athlete athlete, Track track, double time) {
        this.athlete = athlete;
        this.time = time;

        if (track.getType() == TrackType.GRASS) {
            this.time -= 5;
        }

        this.track = track;
    }

    public Athlete getAthlete() {
        return this.athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public double getSpeed() {
        return this.track.getType().getDistance() / this.getTime();
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Track getTrack() {
        return this.track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
