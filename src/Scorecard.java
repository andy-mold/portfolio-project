import components.sequence.Sequence;
import components.sequence.Sequence1L;
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
public final class Scorecard {

    /**
     * Prevents instantiation.
     */
    private Scorecard() {
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        boolean keepRunning = true;
        ShotTracker s = new ShotTrackerOnSequence();
        Sequence<ShotTracker> card = new Sequence1L<ShotTracker>();
        int shotsOnCurrentHole = 0;

        while (keepRunning) {
            out.print(
                    "Enter 1 to add a shot, 2 to finish the hole, or another number to end round: ");
            int action = in.nextInteger();
            out.println("");

            if (action == 1) {
                out.print("Enter the distance of the shot in yards: ");
                int distance = in.nextInteger();
                out.print("Enter the club type, 0-14: ");
                int clubType = in.nextInteger();
                out.print("Enter the shot type, 0-5: ");
                int shotType = in.nextInteger();
                out.println("");

                s.addShot(distance, clubType, shotType);
                shotsOnCurrentHole++;

            } else if (action == 2) {
                card.add(card.length(), s.saveHole(shotsOnCurrentHole));
                shotsOnCurrentHole = 0;

            } else {
                keepRunning = false;
            }
        }

        out.println("Printing scorecard...");
        for (int i = 0; i < card.length(); i++) {
            out.println("Hole " + (i + 1) + ": " + card.entry(i));
        }
    }
}
