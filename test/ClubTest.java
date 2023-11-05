import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ClubTest {
    Athlete athlete;
    Athlete athlete1;

    Lap lap;
    Lap lap1;

    Lap lap2;
    Lap lap3;

    Track grass;
    Track gravel;

    Club club;
    @BeforeEach
    void setUp() {
        athlete = new Athlete("Tom");
        athlete1 = new Athlete("John");

        grass = new Track(TrackType.GRASS);
        gravel = new Track(TrackType.GRAVEL);

        lap = new Lap(athlete, grass, 100);
        lap1 = new Lap(athlete, gravel, 50);

        lap2 = new Lap(athlete1, grass, 50);
        lap3 = new Lap(athlete1, gravel, 100);

        club = new Club();
        club.addAthlete(athlete);
        club.addAthlete(athlete1);
        club.addTrack(grass);
        club.addTrack(gravel);
    }

    @Test
    void getFastestAthleteByTrack() {
        grass.addLapTime(lap);
        grass.addLapTime(lap2);

        assertEquals(athlete1, club.getFastestAthleteByTrack(grass));
    }

    @Test
    void getFastestAthleteAndLapTimeOnAllTrack() {
        grass.addLapTime(lap);
        grass.addLapTime(lap2);

        gravel.addLapTime(lap1);
        gravel.addLapTime(lap3);
        assertEquals("The fastest athlete is John with PR on GRAVEL of: 50 seconds", club.getFastestAthleteAndLapTimeOnAllTrack());
    }

    @Test
    void getTracks() {
        assertEquals(2, club.getTracks().size());
    }

    @Test
    void getAthletes() {
        assertEquals(2, club.getAthletes().size());
    }

    @Test
    void removeAthlete() {
        club.removeAthlete(athlete);
        assertEquals(1, club.getAthletes().size());
    }

    @Test
    void removeTrack() {
        club.removeTrack(grass);
        assertEquals(1, club.getTracks().size());
    }
}