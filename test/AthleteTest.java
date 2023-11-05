import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {
    Athlete athlete;

    Lap lap;
    Lap lap1;
    Track grass;
    Track gravel;

    @BeforeEach
    void setUp() {
        athlete = new Athlete("Tom");

        grass = new Track(TrackType.GRASS);
        gravel = new Track(TrackType.GRAVEL);

        lap = new Lap(athlete, grass, 100);
        lap1 = new Lap(athlete, grass,50);
    }

    @Test
    void getAverageTime() {
        grass.addLapTime(lap);
        grass.addLapTime(lap1);

        int totalTime = lap.getDuration() + lap1.getDuration();
        int totalLap = athlete.getTotalLap();

        assertEquals(totalTime/totalLap, athlete.getAverageTime());
    }

    @Test
    void getName() {
        assertEquals("Tom", athlete.getName());
    }

    @Test
    void setName() {
        athlete.setName("John");
        assertEquals("John", athlete.getName());
    }

    @Test
    void getTotalTime() {
        athlete.addPersonalLap(lap);
        athlete.addPersonalLap(lap1);

        int totalTime = lap.getDuration() + lap1.getDuration();

        assertEquals(totalTime, athlete.getTotalTime());
    }

    @Test
    void addPersonalTime() {
        grass.addLapTime(lap);

        assertEquals(lap.getAthlete().getTotalTime(), athlete.getTotalTime());
    }

    @Test
    void getTotalLap() {
        grass.addLapTime(lap);
        assertEquals(1, athlete.getTotalLap());
    }

    @Test
    void getTotalDistance() {
        athlete.addPersonalLap(lap);
        athlete.addPersonalLap(lap1);

        assertEquals(0.6, athlete.getTotalDistance());
    }

    @Test
    void getMaxSpeed() {
        athlete.addPersonalLap(lap);
        athlete.addPersonalLap(lap1);

        assertEquals((grass.getType().getDistance())/45, athlete.getMaxSpeed());
    }
}