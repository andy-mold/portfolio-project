import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Class.
 */
public class ShotTrackerDemo {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private Sequence<Integer[]> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.rep = new Sequence1L<>();

    }

    /**
     * No-argument constructor.
     */
    public ShotTrackerDemo() {

        this.createNewRep();

    }

    //Kernel Methods

    /**
     * Adds a shot to the shotTracker.
     *
     * @param distance
     *            the distance of the shot in yards.
     * @param clubType
     *            the type of club used for the shot 0-14 representing the club
     * @param shotType
     *            the type of shot (0 = tee, 1 = fairway, 2 = rough, 3 = sand, 4
     *            = chip, 5 = putt)
     */
    public final void addShot(int clubType, int shotType, int distance) {

        Integer[] shot = { clubType, shotType, distance };
        this.rep.add(this.rep.length(), shot);

    }

    /**
     * Removes a shot from the shotTracker.
     *
     * @param n
     *            The index of the shot to be removed.
     * @return the shot that was removed.
     */
    public final Integer[] removeShot(int n) {
        assert this.length() > 0 : "Violation of: this /= empty_set";

        Integer[] shot = this.rep.remove(n);
        return shot;
    }

    /**
     *
     * @return length of the shotTracker (number of shots).
     */
    public final int length() {

        return this.rep.length();
    }

    /**
     * Gets the club type of a certain shot at index n.
     *
     * @param n
     *            The index of the shot to get the clubType from.
     * @return the club type between 0-14 (ex. 9 = 9 iron).
     */
    public final int getClubType(int n) {
        Integer[] shot = this.rep.entry(n);
        int clubType = shot[0];
        return clubType;
    }

    /**
     * Gets the distance of a certain shot at index n.
     *
     * @param n
     *            The index of the shot to get the distance from.
     * @return the distance of the shot at entry n in yards.
     */
    public final int getDistance(int n) {
        Integer[] shot = this.rep.entry(n);
        int distance = shot[2];
        return distance;
    }

    //Secondary methods

    /**
     * Calculates and returns the average distance of every shot in the
     * shotTracker that have the same clubType as the parameter.
     *
     * @param clubType
     * @return the average distance of all shots in the shotTracker that have a
     *         certain clubType.
     */
    public final int averageDistance(int clubType) {
        int average = 0;
        int numberOfShots = 0;
        for (int i = 0; i < this.length(); i++) {
            if (this.getClubType(i) == clubType) {
                average += this.getDistance(i);
                numberOfShots++;
            }
        }
        return average / numberOfShots;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        ShotTrackerDemo shotTracker = new ShotTrackerDemo();

        /*
         * ClubType key 0 = driver 1 = 3 wood 2 = 5 wood 3 = 3 iron 4 = 4 iron 5
         * = 5 iron 6 = 6 iron 7 = 7 iron 8 = 8 iron 9 = 9 iron 10 = pitching
         * wedge 11 = gap wedge 12 = sand wedge 13 = lob wedge 14 = putter
         *
         * ShotType key 0 = tee 1 = fairway 2 = rough 3 = bunker 4 = chip 5 =
         * putt
         */

        shotTracker.addShot(0, 0, 250);
        shotTracker.addShot(7, 1, 160);
        shotTracker.addShot(9, 2, 120);
        shotTracker.addShot(14, 5, 10);

        Integer[] secondShot = shotTracker.removeShot(1);
        System.out.println(secondShot);

        int length = shotTracker.length();
        System.out.println("Number of shots: " + length);

        int clubType = shotTracker.getClubType(0);
        int distance = shotTracker.getDistance(0);
        System.out.println("Shot 1 distance: " + distance);
        System.out.println("Shot 1 type: " + clubType);

        shotTracker.addShot(9, 2, 130);
        int averageDistance9Iron = shotTracker.averageDistance(9);
        System.out.println("Average 9 Iron Distance: " + averageDistance9Iron);
    }

}
