/**
 *  * Layered implementations of secondary methods for {@code ShotTracker}.  
 */
public abstract class ShotTrackerSecondary implements ShotTracker {

    /**
     * * Layered implementations of secondary methods for {@code Shot}.
     */
    public abstract class Shot implements ShotTracker.Shot {

        /**
         * The distance of the shot in yards.
         */
        private int distance;

        /**
         * The type of club used for the shot (0-14).
         */
        private int clubType;

        /**
         * The type of shot taken (0-5).
         */
        private int shotType;

        /**
         * Constructor.
         *
         * @param distance
         * @param clubType
         * @param shotType
         */
        public Shot(int distance, int clubType, int shotType) {
            this.distance = distance;
            this.clubType = clubType;
            this.shotType = shotType;
        }

        // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
        @Override
        public int getDistance() {
            return this.distance;
        }

        // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
        @Override
        public int getClubType() {
            return this.clubType;
        }

        // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
        @Override
        public int getShotType() {
            return this.shotType;
        }
    }
    /*
     * Public members ---------------------------------------------------------
     */

    /*
     * Common methods (from Object) -------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < this.length(); i++) {
            s += "(";
            s += this.getShot(i).getDistance() + ", ";
            s += this.getShot(i).getClubType() + ", ";
            s += this.getShot(i).getShotType() + "), ";
        }
        s += "}";
        return s;
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void append(ShotTracker shots) {
        while (shots.length() > 0) {
            ShotTracker.Shot removed = shots.removeShot(0);
            this.addShot(removed.getDistance(), removed.getClubType(),
                    removed.getShotType());
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int averageDistance(int clubType) {
        int average = 0;
        int numberOfShots = 0;
        for (int i = 0; i < this.length(); i++) {
            if (this.getShot(i).getClubType() == clubType) {
                average += this.getShot(i).getDistance();
                numberOfShots++;
            }
        }
        return average / numberOfShots;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public ShotTracker saveHole(int n) {
        ShotTracker hole = this.newInstance();
        for (int i = this.length() - n; i < this.length(); i++) {
            ShotTracker.Shot current = this.getShot(0);
            hole.addShot(current.getDistance(), current.getClubType(),
                    current.getShotType());
        }
        return hole;
    }
}
