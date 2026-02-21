import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Runs through different tests for the getEarlier method in the Clock class
 * 
 * @author Brayden Granger
 * @since 02/06/2024
 */
public class EarlierTests {
    /**
     * Checks result when clock one is a.m. and clock two is p.m.
     */
    @Test
    public void checkClockOneIsAmClockTwoIsPm() {
        Clock c1 = new Clock(12, 0, "a.m.");
        Clock c2 = new Clock(12, 0, "p.m.");

        Clock result = Clock.getEarlier(c1, c2);

        assertEquals(result, c1);
    }

    /**
     * Checks result when clock one is p.m. and clock two is a.m.
     */
    @Test
    public void checkClockOneIsPmClockTwoIsAm() {
        Clock c1 = new Clock(12, 0, "p.m.");
        Clock c2 = new Clock(12, 0, "a.m.");

        Clock result = Clock.getEarlier(c1, c2);

        assertEquals(result, c2);
    }

    /**
     * Checks result when clock one is at 12 hours and clock two is not at 12 hours
     */
    @Test
    public void checkClockOneAtTwelveClockTwoNotAtTwelve() {
        Clock c1 = new Clock(12, 0, "a.m.");
        Clock c2 = new Clock(1, 0, "a.m.");

        Clock result = Clock.getEarlier(c1, c2);

        assertEquals(result, c1);
    }

    /**
     * Checks result when clock one is not at 12 hours and clock two is at 12 hours
     */
    @Test
    public void checkClockOneNotAtTwelveClockTwoAtTwelve() {
        Clock c1 = new Clock(1, 0, "a.m.");
        Clock c2 = new Clock(12, 0, "a.m.");

        Clock result = Clock.getEarlier(c1, c2);

        assertEquals(result, c2);
    }

    /**
     * Checks result when clock one hours is less than clock two hours (same
     * meridian)
     */
    @Test
    public void checkClockOneHoursLessThanClockTwoHours() {
        Clock c1 = new Clock(6, 0, "p.m.");
        Clock c2 = new Clock(7, 0, "p.m.");

        Clock result = Clock.getEarlier(c1, c2);

        assertEquals(result, c1);
    }

    /**
     * Checks result when clock one hours is greater than clock two hours (same
     * meridian)
     */
    @Test
    public void checkClockOneHoursGreaterThanClockTwoHours() {
        Clock c1 = new Clock(7, 0, "p.m.");
        Clock c2 = new Clock(6, 0, "p.m.");

        Clock result = Clock.getEarlier(c1, c2);

        assertEquals(result, c2);
    }

    /**
     * Checks result when clock one minutes is less than clock two minutes (same
     * meridian and hours)
     */
    @Test
    public void checkClockOneMinutesLessThanClockTwoMinutes() {
        Clock c1 = new Clock(6, 0, "p.m.");
        Clock c2 = new Clock(6, 30, "p.m.");

        Clock result = Clock.getEarlier(c1, c2);

        assertEquals(result, c1);
    }

    /**
     * Checks result when clock one minutes is greater than clock two minutes (same
     * meridian and hours)
     */
    @Test
    public void checkClockOneMinutesGreaterThanClockTwoMinutes() {
        Clock c1 = new Clock(6, 30, "p.m.");
        Clock c2 = new Clock(6, 0, "p.m.");

        Clock result = Clock.getEarlier(c1, c2);

        assertEquals(result, c2);
    }

    /**
     * Checks result when clock one is equal to clock two
     */
    @Test
    public void checkClocksAreEqual() {
        Clock c1 = new Clock(6, 0, "p.m.");
        Clock c2 = new Clock(6, 0, "p.m.");

        Clock result = Clock.getEarlier(c1, c2);

        assertEquals(result, c1);
    }
}
