import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {
    Track grass;
    Track gravel;

    @BeforeEach
    void setUp() {
        grass = new Track(TrackType.GRASS);
        gravel = new Track(TrackType.GRAVEL);
    }

    @Test
    void getType() {
        assertEquals(TrackType.GRASS, grass.getType());
        assertEquals(TrackType.GRAVEL, gravel.getType());
    }

    @Test
    void setType() {
        grass.setType(TrackType.GRAVEL);
        gravel.setType(TrackType.GRASS);
        assertEquals(TrackType.GRAVEL, grass.getType());
        assertEquals(TrackType.GRASS, gravel.getType());
    }
}