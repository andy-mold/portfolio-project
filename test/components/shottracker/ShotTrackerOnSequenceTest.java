package components.shottracker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code ShotTracker}'s standard and kernel methods.
 */
public class ShotTrackerOnSequenceTest {

    /**
     * Test addShot with distance = 100, clubType = 9, and shotType = 2.
     */
    @Test
    public final void testAddShot() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        final int distance = 100;
        final int clubType = 9;
        final int shotType = 2;
        ShotTracker.Shot expectedShot = new ShotTrackerSecondary.Shot(distance,
                clubType, shotType);

        //Call appropriate method
        s.addShot(distance, clubType, shotType);

        //Check for equivalence
        ShotTracker.Shot shot = s.getShot(0);
        assertEquals(expectedShot.getDistance(), shot.getDistance());
        assertEquals(expectedShot.getClubType(), shot.getClubType());
        assertEquals(expectedShot.getShotType(), shot.getShotType());
        assertEquals(1, s.length());
    }

    /**
     * Test removeShot with distance = 100, clubType = 9, and shotType = 2.
     */
    @Test
    public final void testRemoveShot() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        final int distance = 100;
        final int clubType = 9;
        final int shotType = 2;
        ShotTracker.Shot expectedShot = new ShotTrackerSecondary.Shot(distance,
                clubType, shotType);

        //Call appropriate method
        s.addShot(distance, clubType, shotType);
        ShotTracker.Shot shot = s.removeShot(0);

        //Check for equivalence
        assertEquals(expectedShot.getDistance(), shot.getDistance());
        assertEquals(expectedShot.getClubType(), shot.getClubType());
        assertEquals(expectedShot.getShotType(), shot.getShotType());
        assertEquals(0, s.length());
    }

    /**
     * Test length (0).
     */
    @Test
    public final void testLength0() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        ShotTracker sExpected = new ShotTrackerOnSequence();

        //Check for equivalence
        assertEquals(0, s.length());
        assertEquals(sExpected, s);
    }

    /**
     * Test length (2).
     */
    @Test
    public final void testLength2() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        ShotTracker sExpected = new ShotTrackerOnSequence();
        final int distance = 100;
        final int clubType = 9;
        final int shotType = 2;

        s.addShot(distance, clubType, shotType);
        s.addShot(distance, clubType, shotType);
        sExpected.addShot(distance, clubType, shotType);
        sExpected.addShot(distance, clubType, shotType);

        //Check for equivalence
        assertEquals(2, s.length());
        assertEquals(sExpected, s);
    }

    /**
     * Test getShot with distance = 100, clubType = 9, and shotType = 2.
     */
    @Test
    public final void testGetShot() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        ShotTracker sExpected = new ShotTrackerOnSequence();
        final int distance = 100;
        final int clubType = 9;
        final int shotType = 2;

        //Call appropriate method
        s.addShot(distance, clubType, shotType);
        sExpected.addShot(distance, clubType, shotType);

        //Check for equivalence
        assertEquals(1, s.length());
        assertEquals(sExpected, s);
    }

    /**
     * Test newInstance.
     */
    @Test
    public final void testNewInstance() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        ShotTracker s1 = new ShotTrackerOnSequence();
        ShotTracker sExpected = new ShotTrackerOnSequence();
        final int distance = 100;
        final int clubType = 9;
        final int shotType = 2;

        //Call appropriate method
        s1.addShot(distance, clubType, shotType);
        s = s1.newInstance();

        //Check for equivalence
        assertEquals(0, s.length());
        assertEquals(sExpected, s);
    }

    /**
     * Test clear.
     */
    @Test
    public final void testClear() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        ShotTracker sExpected = new ShotTrackerOnSequence();
        final int distance = 100;
        final int clubType = 9;
        final int shotType = 2;

        //Call appropriate method
        s.addShot(distance, clubType, shotType);
        s.clear();

        //Check for equivalence
        assertEquals(0, s.length());
        assertEquals(sExpected, s);
    }

    /**
     * Test transferFrom with distance = 100, clubType = 9, and shotType = 2.
     */
    @Test
    public final void testTransferFrom() {
        //Initialize variables
        ShotTracker s = new ShotTrackerOnSequence();
        ShotTracker s1 = new ShotTrackerOnSequence();
        ShotTracker sExpected = new ShotTrackerOnSequence();
        ShotTracker s1Expected = new ShotTrackerOnSequence();
        final int distance = 100;
        final int clubType = 9;
        final int shotType = 2;

        //Call appropriate method
        s1.addShot(distance, clubType, shotType);
        sExpected.addShot(distance, clubType, shotType);
        s.transferFrom(s1);

        //Check for equivalence
        assertEquals(1, s.length());
        assertEquals(sExpected, s);
        assertEquals(s1Expected, s1);
    }

}
