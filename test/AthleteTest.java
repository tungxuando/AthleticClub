import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {
    Athlete athlete;

    @BeforeEach
    void setUp() {
        athlete = new Athlete("Tom");
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
}