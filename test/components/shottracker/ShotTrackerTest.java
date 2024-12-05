package components.shottracker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code ShotTracker}'s secondary methods.
 */
public class ShotTrackerTest {

    /**
     * Test append of ShotTracker of length 2.
     */
    @Test
    public final void testAppend() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        ShotTracker sTemp = new ShotTrackerOnSequence();
        ShotTracker sExpected = new ShotTrackerOnSequence();
        final int distance = 100;
        final int clubType = 9;
        final int shotType = 2;

        //Call appropriate method
        sExpected.addShot(distance, clubType, shotType);
        sExpected.addShot(distance, clubType, shotType);
        sTemp.addShot(distance, clubType, shotType);
        sTemp.addShot(distance, clubType, shotType);
        s.append(sTemp);

        //Check for equivalence
        assertEquals(2, s.length());
        assertEquals(sExpected, s);
    }

    /**
     * Test averageDistance for shots (100, 9, 2), (130, 9, 2), (200, 8, 2).
     */
    @Test
    public final void testAverageDistance() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        ShotTracker sExpected = new ShotTrackerOnSequence();
        final int distance1 = 100;
        final int distance2 = 130;
        final int distance3 = 200;
        final int clubType1 = 9;
        final int clubType2 = 8;
        final int shotType = 2;

        //Call appropriate method
        s.addShot(distance1, clubType1, shotType);
        s.addShot(distance2, clubType1, shotType);
        s.addShot(distance3, clubType2, shotType);
        sExpected.addShot(distance1, clubType1, shotType);
        sExpected.addShot(distance2, clubType1, shotType);
        sExpected.addShot(distance3, clubType2, shotType);

        int averageDistance = s.averageDistance(clubType1);
        final int averageDistanceExpected = 115;

        //Check for equivalence
        assertEquals(averageDistanceExpected, averageDistance);
        assertEquals(sExpected, s);
    }

    /**
     * Test saveHole for shots (100, 9, 2), (130, 9, 2), (200, 8, 2) and
     * parameter n = 2.
     */
    @Test
    public final void testSaveHole() {
        //Initialize variables
        ShotTracker s;
        ShotTracker s1 = new ShotTrackerOnSequence();
        ShotTracker sExpected = new ShotTrackerOnSequence();
        ShotTracker s1Expected = new ShotTrackerOnSequence();
        final int distance1 = 100;
        final int distance2 = 130;
        final int distance3 = 200;
        final int clubType1 = 9;
        final int clubType2 = 8;
        final int shotType = 2;

        //Call appropriate method
        s1.addShot(distance1, clubType1, shotType);
        s1.addShot(distance2, clubType1, shotType);
        s1.addShot(distance3, clubType2, shotType);
        sExpected.addShot(distance2, clubType1, shotType);
        sExpected.addShot(distance3, clubType2, shotType);
        s1Expected.addShot(distance1, clubType1, shotType);

        s = s1.saveHole(2);

        //Check for equivalence
        assertEquals(2, s.length());
        assertEquals(sExpected, s);
    }

}
