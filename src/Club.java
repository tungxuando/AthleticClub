import java.util.ArrayList;

public class Club {
    private final ArrayList<Track> tracks;
    private final ArrayList<Athlete> athletes;

    public Club() {
        this.tracks = new ArrayList<>();
        this.athletes = new ArrayList<>();
    }

    public Athlete getFastestAthleteByTrack(Track track) {
        return track.getFastestAthlete();
    }

    public void addAthlete(Athlete athlete) {
        this.athletes.add(athlete);
    }

    public void removeAthlete(Athlete athlete) {
        this.athletes.remove(athlete);
    }

    public String getFastestAthleteAndLapTimeOnAllTrack() {
        //get only the fastest athlete of all tracks
        String result = "";
        for (Track track : this.tracks) {
            Athlete fastestAthlete = this.getFastestAthleteByTrack(track);
            if (fastestAthlete != null) {
                result = "The fastest athlete is " + fastestAthlete.getName() + " with PR on " + track.getType() + " of: " + track.getFastestLapTime() + " seconds";
            }
        }
        return result;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    public void removeTrack(Track track) {
        this.tracks.remove(track);
    }

    public ArrayList<Track> getTracks() {
        return this.tracks;
    }

    public ArrayList<Athlete> getAthletes() {
        return this.athletes;
    }
}
