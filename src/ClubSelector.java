import components.shottracker.ShotTracker;
import components.shottracker.ShotTrackerOnSequence;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Provides a possible use case of the ShotTracker component.
 *
 * Uses the ShotTracker to recommend a club to use for your next shot based on
 * your previously saved shots.
 */
public final class ClubSelector {

    /**
     * Prevents instantiation.
     */
    private ClubSelector() {
    }

    /**
     * Adds all shots in array to s.
     *
     * @param s
     *            The ShotTracker to add the shots to.
     * @param array
     *            The int array of info for the shots. Every 3 indexes is a new
     *            shot.
     */
    static void addAllShots(ShotTracker s, int[] array) {
        for (int i = 0; i < array.length; i += 3) {
            s.addShot(array[i], array[i + 1], array[i + 2]);
        }
    }

    /**
     * Finds the correct clubType to use for next shot based on d.
     *
     * @param d
     *            The distance of the upcoming shot
     * @param averageDistances
     *            The int array of average distances for each club
     * @return the recommended club
     */
    static int findCorrectClub(int d, int[] averageDistances) {
        int club = -1;
        int error = 1000;

        for (int i = 0; i < averageDistances.length; i++) {
            int current = averageDistances[i];
            if (current != -1) {
                int currentError = Math.abs(Math.abs(d) - Math.abs(current));
                if (currentError < error) {
                    error = currentError;
                    club = i;
                }
            }
        }

        return club;
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean runAgain = true;
        while (runAgain) {

            int[] shots = { 100, 9, 2, 120, 9, 2, 130, 9, 2, 105, 9, 2, 200, 1,
                    1, 210, 1, 1, 230, 1, 1, 190, 1, 1, 150, 7, 2, 140, 7, 2,
                    160, 7, 2 };

            ShotTracker s = new ShotTrackerOnSequence();
            addAllShots(s, shots);

            final int numClubs = 14;
            int[] avgDistances = new int[numClubs];
            for (int i = 0; i < numClubs; i++) {
                avgDistances[i] = s.averageDistance(i);
            }

            SimpleReader in = new SimpleReader1L();
            SimpleWriter out = new SimpleWriter1L();

            out.print("Enter the integer distance of your next shot: ");
            int d = in.nextInteger();

            int club = findCorrectClub(d, avgDistances);
            out.println("The recommended club for your " + d + " yard shot is "
                    + club);

            out.print("Press 1 to enter another shot: ");
            int again = in.nextInteger();
            if (again != 1) {
                runAgain = false;
            }

            in.close();
            out.close();

        }
    }
}
