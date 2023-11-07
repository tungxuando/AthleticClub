import java.util.ArrayList;

public class Club {
    private final ArrayList<Lap> laps;

    public Club() {
        this.laps = new ArrayList<>();
    }

    public void addLapTime(Lap lap) {
        this.laps.add(lap);
    }

    public int getTotalLapsByAthlete(Athlete athlete) {
        int totalLaps = 0;
        for (Lap lap : this.laps) {
            if(lap.getAthlete() == athlete) {
                totalLaps++;
            }
        }
        return totalLaps;
    }

    public double getTotalDistanceByAthlete(Athlete athlete){
        double totalDistance = 0;
        for (Lap lap : this.laps) {
            if(lap.getAthlete() == athlete) {
                totalDistance += lap.getTrack().getType().getDistance();
            }
        }
        return totalDistance / 1000;
    }

    public double getAverageTimeByAthlete(Athlete athlete){
        return this.getTotalTimeByAthlete(athlete) / this.getTotalLapsByAthlete(athlete);
    }

    public double getTotalTimeByAthlete(Athlete athlete){
        double totalTime = 0;
        for (Lap lap : this.laps) {
            if(lap.getAthlete() == athlete) {
                totalTime += lap.getTime();
            }
        }
        return totalTime;
    }

    public double getMaxSpeedByAthlete(Athlete athlete){
        double maxSpeed = 0;
        for (Lap lap : this.laps) {
            if(lap.getAthlete() == athlete) {
                if(lap.getSpeed() > maxSpeed) {
                    maxSpeed = lap.getSpeed();
                }
            }
        }
        return maxSpeed;
    }
    public String getFastestAthleteAndLapTime() {
        //get only the fastest athlete of all tracks
        String result = "";
        Athlete fastestAthlete = null;
        double fastestTime = Integer.MAX_VALUE;

        for (Lap lap : this.laps) {
            if (lap.getTime() < fastestTime) {
                fastestAthlete = lap.getAthlete();
                fastestTime = lap.getTime();
            }
        }

        if (fastestAthlete != null) {
            result += fastestAthlete.getName() + " "+ fastestTime;
        }
        return result;
    }

    public Athlete getFastestAthleteOnCertainTrackType(TrackType trackType) {
        Athlete fastestAthlete = null;
        double fastestTime = Integer.MAX_VALUE;

        for (Lap lap : this.laps) {
            if (lap.getTrack().getType() == trackType) {
                if (lap.getTime() < fastestTime) {
                    fastestAthlete = lap.getAthlete();
                    fastestTime = lap.getTime();
                }
            }
        }
        return fastestAthlete;
    }

    public ArrayList<Lap> getLaps() {
        return this.laps;
    }

    public void removeLap(Lap lap) {
        this.laps.remove(lap);
    }
}