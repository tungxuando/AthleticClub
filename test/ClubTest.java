import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClubTest {
    Club club;
    Athlete athlete;
    Athlete athlete1;
    Track grass;
    Track gravel;
    Lap lap;
    Lap lap1;
    Lap lap2;
    Lap lap3;

    @BeforeEach
    void setUp() {
        club = new Club();

        athlete = new Athlete("Tom");
        athlete1 = new Athlete("Jerry");

        grass = new Track(TrackType.GRASS);
        gravel = new Track(TrackType.GRAVEL);

        lap = new Lap(athlete, grass, 100);
        lap1 = new Lap(athlete, gravel, 200);

        lap2 = new Lap(athlete1, grass, 300);
        lap3 = new Lap(athlete1, gravel, 400);

        club.addLapTime(lap);
        club.addLapTime(lap1);
        club.addLapTime(lap2);
        club.addLapTime(lap3);
    }

    @Test
    void addLapTime() {
        assertEquals(4, club.getLaps().size());
    }

    @Test
    void getTotalLapsByAthlete() {
        assertEquals(2, club.getTotalLapsByAthlete(athlete));
    }

    @Test
    void getTotalDistanceByAthlete() {
        double $calculation = (double)(grass.getType().getDistance() + gravel.getType().getDistance()) / 1000;
        assertEquals($calculation, club.getTotalDistanceByAthlete(athlete));
    }

    @Test
    void getAverageTimeByAthlete() {
        double $calculation = (lap.getTime() + lap1.getTime()) / 2;
        assertEquals($calculation, club.getAverageTimeByAthlete(athlete));
    }

    @Test
    void getTotalTimeByAthlete() {
        double $calculation = lap.getTime() + lap1.getTime();
        assertEquals($calculation, club.getTotalTimeByAthlete(athlete));
    }

    @Test
    void getMaxSpeedByAthlete() {
        double $calculation = lap.getSpeed();
        assertEquals($calculation, club.getMaxSpeedByAthlete(athlete));
    }

    @Test
    void getFastestAthleteAndLapTime() {
        String $string = "Tom 95.0";
        assertEquals($string, club.getFastestAthleteAndLapTime());
    }

    @Test
    void getFastestAthleteOnCertainTrackType() {
        assertEquals(athlete, club.getFastestAthleteOnCertainTrackType(TrackType.GRAVEL));
    }

    @Test
    void removeLap(){
        club.removeLap(lap);
        assertEquals(3, club.getLaps().size());
    }
}