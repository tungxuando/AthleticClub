import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrackTest {
    Athlete athlete;
    Athlete athlete1;

    Lap lap;
    Lap lap1;
    Lap lap2;
    Lap lap3;
    Track grass;
    Track gravel;

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
    }

    @Test
    void addLapTime() {
        grass.addLapTime(lap);
        assertEquals(1, grass.getRecords().size());
    }

    @Test
    void getFastestAthlete() {
        grass.addLapTime(lap);
        grass.addLapTime(lap2);

        assertEquals(athlete1, grass.getFastestAthlete());
    }

    @Test
    void getFastestAthleteAndLapTime() {
        grass.addLapTime(lap);
        grass.addLapTime(lap2);

        assertEquals("The fastest athlete is John with PR on GRASS of: 45 seconds", grass.getFastestAthleteAndLapTime());
    }

    @Test
    void getType() {
        assertEquals(TrackType.GRASS, grass.getType());
    }
}