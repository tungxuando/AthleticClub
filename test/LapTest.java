import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LapTest {
    Athlete athlete;
    Lap lap;
    Track grass;
    Track gravel;
    @BeforeEach
    void setUp() {
        athlete = new Athlete("Tom");
        grass = new Track(TrackType.GRASS);
        gravel = new Track(TrackType.GRAVEL);
        lap = new Lap(athlete, grass, 100);
    }

    @Test
    void getAthlete() {
        assertEquals(athlete, lap.getAthlete());
    }

    @Test
    void setAthlete() {
        lap.setAthlete(athlete);
        assertEquals(athlete, lap.getAthlete());
    }

    @Test
    void getSpeed() {
        assertEquals(lap.getTrack().getType().getDistance()/lap.getTime(), lap.getSpeed());
    }

    @Test
    void getTime() {
        assertEquals(95, lap.getTime());
    }

    @Test
    void setTime() {
        lap.setTime(100);
        assertEquals(100, lap.getTime());
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