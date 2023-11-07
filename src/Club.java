import java.util.ArrayList;

public class Club {
    private final ArrayList<Lap> laps;

    public Club() {
        this.laps = new ArrayList<>();
    }

    /**
     * This method add Lap object to ArrayList laps
     * @param lap Lap object
     */
    public void addLapTime(Lap lap) {
        this.laps.add(lap);
    }

    /**
     * This method get total laps by athlete
     * @param athlete Athlete object
     * @return totalLaps
     */
    public int getTotalLapsByAthlete(Athlete athlete) {
        int totalLaps = 0;
        for (Lap lap : this.laps) {
            if(lap.getAthlete() == athlete) {
                totalLaps++;
            }
        }
        return totalLaps;
    }

    /**
     * This method get total distance by athlete
     * @param athlete Athlete object
     * @return totalDistance
     */
    public double getTotalDistanceByAthlete(Athlete athlete){
        double totalDistance = 0;
        for (Lap lap : this.laps) {
            if(lap.getAthlete() == athlete) {
                totalDistance += lap.getTrack().getType().getDistance();
            }
        }
        return totalDistance / 1000;
    }

    /**
     * This method get average time by athlete
     * @param athlete Athlete object
     * @return averageTime
     */
    public double getAverageTimeByAthlete(Athlete athlete){
        return this.getTotalTimeByAthlete(athlete) / this.getTotalLapsByAthlete(athlete);
    }

    /**
     * This method get total time by athlete
     * @param athlete Athlete object
     * @return totalTime
     */
    public double getTotalTimeByAthlete(Athlete athlete){
        double totalTime = 0;
        for (Lap lap : this.laps) {
            if(lap.getAthlete() == athlete) {
                totalTime += lap.getTime();
            }
        }
        return totalTime;
    }

    /**
     * This method get max speed by athlete
     * @param athlete Athlete object
     * @return maxSpeed
     */
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

    /**
     * This method get the fastest athlete and lap time
     * @return fastest athlete's name and lapTime
     */
    public String getFastestAthleteAndLapTime() {
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

    /**
     * This method get the fastest athlete on certain track type
     * @param trackType TrackType object
     * @return fastest athlete
     */
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