import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LapTest {
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
    void getAthlete() {
        assertEquals(athlete, lap.getAthlete());
    }

    @Test
    void setAthlete() {
        lap.setAthlete(athlete1);
        assertEquals(athlete1, lap.getAthlete());
    }

    @Test
    void getSpeed() {
        assertEquals(3, lap.getSpeed());
    }

    @Test
    void getDuration() {
        assertEquals(95, lap.getDuration());
    }

    @Test
    void setDuration() {
        lap.setDuration(100);
        assertEquals(100, lap.getDuration());
    }

    @Test
    void getTrack() {
        assertEquals(grass, lap.getTrack());
    }

    @Test
    void setTrack() {
        lap.setTrack(gravel);
        assertEquals(gravel, lap.getTrack());
    }
}